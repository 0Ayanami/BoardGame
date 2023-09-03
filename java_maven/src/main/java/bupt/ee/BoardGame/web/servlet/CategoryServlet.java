package bupt.ee.BoardGame.web.servlet;


import bupt.ee.BoardGame.domain.Category;
import bupt.ee.BoardGame.service.CategoryService;
import bupt.ee.BoardGame.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询所有
        List<Category> cs = service.findAll();
        //序列化json返回
        //因为该流程会被频繁的调用（与前端Ajax交互会非常的多），所以最好封装到父类的一个方法中
        /*ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),cs);*/

        //调用父类的封装好的序列化方法
        writeValue(cs,response);
    }
}
