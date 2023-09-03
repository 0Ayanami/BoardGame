package bupt.ee.BoardGame.web.servlet;

import bupt.ee.BoardGame.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 获取用户登录后的信息
 */
//进入到主页后，主页异步请求加载，但并没有异步更新，访问进入该servlet，从而将获取的值反馈给主页
//并没有进入该servlet
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获取登录用户
        //登录成功后，user对象出了问题
        //错误：user为null,登录成功后session获取的数据为null
        User user = (User) request.getSession().getAttribute("user");
        //System.out.println(user.toString());
        //HttpSession session = request.getSession();
        //User user = (User) session.getAttribute("user");
        //将user写回客户端
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
