package bupt.ee.BoardGame.dao;

import bupt.ee.BoardGame.domain.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * check
     * 查询所有
     * @return
     */
    List<Category> findAll();


}
