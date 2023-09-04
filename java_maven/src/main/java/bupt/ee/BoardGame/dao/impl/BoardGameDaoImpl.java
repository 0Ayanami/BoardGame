package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.BoardGameDao;
import bupt.ee.BoardGame.domain.BoardGame;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class BoardGameDaoImpl implements BoardGameDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据cid查询总记录数
     * @param cid
     * @return
     */
    @Override
    public int findTotalCount(int cid,String bname) {
        //定义模板
        String sql = "select count(*) from boardgame where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();//条件们
        //判断参数是否有值
        if (cid != 0){
            sb.append(" and cid = ? ");
            //有上面append，就有下面的add
            params.add(cid);//添加？对应的值
        }
        //注意：bname如果传递进来的值是null，也要排除掉，不能进行拼接
        if(bname != null && bname.length() > 0 && !"null".equals(bname)){
            sb.append(" and bname like ? ");

            params.add("%"+bname+"%");
        }

        sql = sb.toString();

        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    /**
     * 根据cid，start，pageSize查询当前的数据集合
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<BoardGame> findByPage(int cid, int start, int pageSize,String bname) {
        String sql = " select * from boardgame where 1=1 ";
        //定义模板
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();//条件们
        //判断参数是否有值
        if (cid != 0){
            sb.append(" and cid = ? ");
            //有上面append，就有下面的add
            params.add(cid);//添加？对应的值
        }
        if(bname != null && bname.length() > 0 && !"null".equals(bname)){
            sb.append(" and bname like ? ");

            params.add("%"+bname+"%");
        }
        sb.append(" order by score  ");//完成排序
        sb.append(" limit ? , ?  ");//完成分页条件

        sql = sb.toString();

        params.add(start);
        params.add(pageSize);

        return template.query(sql,new BeanPropertyRowMapper<BoardGame>(BoardGame.class),params.toArray());
    }

    /**
     * 根据bid查询boardgame表记录（BoardGame实体类的部分数据）
     * @param bid
     * @return
     */
    @Override
    public BoardGame findOne(int bid) {
        String sql = "select * from boardgame where bid = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<BoardGame>(BoardGame.class),bid);
    }
}
