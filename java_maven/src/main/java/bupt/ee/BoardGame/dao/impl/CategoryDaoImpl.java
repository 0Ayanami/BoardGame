package bupt.ee.BoardGame.dao.impl;

import bupt.ee.BoardGame.dao.CategoryDao;
import bupt.ee.BoardGame.domain.Category;
import bupt.ee.BoardGame.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Category> findAll() {
        //编写sql语句
        String sql = "select * from category";
        //执行sql语句
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
