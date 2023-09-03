package bupt.ee.BoardGame.web.servlet;

import bupt.ee.BoardGame.service.UserService;
import bupt.ee.BoardGame.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 激活用户
 */
@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取激活码
        //获取到跳转请求时，传过来的code，在该servlet做处理
        String code = request.getParameter("code");
        //调用service完成激活
        UserService service = new UserServiceImpl();
        boolean flag = service.active(code);
        //判断标记
        String msg = null;
        if (flag){
            //激活成功
            //此时可以跳转到一个专门的html页面，然后有相关操作
            // 或者直接通过servlet给浏览器反馈一句浏览器可以识别的话，也就是html代码
            msg = "激活成功，请<a href = 'login.html'>登录</a>";
        }else {
            //激活失败
            msg = "激活失败，请联系管理员";
        }
        //设置响应给前端该用何种方式解析
        response.setContentType("text/html;charset=utf-8");
        //写响应消息到响应头和响应体
        response.getWriter().write(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
