package bupt.ee.BoardGame.service;

import bupt.ee.BoardGame.domain.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}
