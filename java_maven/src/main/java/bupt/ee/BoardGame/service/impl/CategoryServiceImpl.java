package bupt.ee.BoardGame.service.impl;

import bupt.ee.BoardGame.dao.CategoryDao;
import bupt.ee.BoardGame.dao.impl.CategoryDaoImpl;
import bupt.ee.BoardGame.domain.Category;
import bupt.ee.BoardGame.service.CategoryService;
import bupt.ee.BoardGame.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Category> findAll() {
        //redis缓存优化
        //获取jedis客户端
        Jedis jedis = JedisUtil.getJedis();//参数为空默认访问本机的redis
        //查询使用sortedset排序查询，这样以后的缓存数据就是有序的
        //查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("categories", 0, -1);//获取该键对应的所有值

        List<Category> cs = null;
        //判断查询的集合是否为空
        //如果为空，需要从数据库查询，再将数据存入redis
        if (categorys == null || categorys.size() == 0) {
            //redis缓存为空，从数据库中查询，并将数据存储进缓存
            cs = categoryDao.findAll();//返回一个list类型的结果集，该方法返回list类型，不需要做类型转换
            // 直接从数据库查询返回的数据是表中数据排列的顺序

            //将集合数据存储进redis缓存中，以后可以直接返回redis中的数据，存储的redis格式为sortedset类型
            for (int i = 0; i < cs.size(); i++) {
                //以有序集合的方式存进缓存
                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {
            //如果不为空，即是redis中有数据，将set存入list（因为返回的是一个list对象，需要做对象转换）

            cs = new ArrayList<Category>();//list的实现类
            //直接将redis中的数据返回，list和按set存储的缓存数据做一个类型转换

            //集合遍历缓存，有分数，有值
            for (Tuple tuple : categorys) {
                //categorys不为空
                Category category = new Category();//新建一个实体类
                //此时categorie对象的Cid为0
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                cs.add(category);
            }
        }
        return cs;
    }
}
