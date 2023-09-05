package bupt.ee.BoardGame.web.servlet;

import bupt.ee.BoardGame.domain.*;
import bupt.ee.BoardGame.service.CommentService;
import bupt.ee.BoardGame.service.MarkService;
import bupt.ee.BoardGame.service.BoardGameService;
import bupt.ee.BoardGame.service.PurchaseService;
import bupt.ee.BoardGame.service.impl.CommentServiceImpl;
import bupt.ee.BoardGame.service.impl.MarkServiceImpl;
import bupt.ee.BoardGame.service.impl.BoardGameServiceImpl;
import bupt.ee.BoardGame.service.impl.PurchaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/boardgame/*")
public class BoardGameServlet extends BaseServlet {
    private BoardGameService boardGameService = new BoardGameServiceImpl();
    private MarkService markService = new MarkServiceImpl();

    private PurchaseService purchaseService = new PurchaseServiceImpl();

    private CommentService commentService = new CommentServiceImpl();

    /**
     * 商品页面展示
     * 1）用输入框进行搜索时调用该方法可以显示所有名称包含搜索词的商品
     * 2）点击商品类别时可以通过cid显示所有该类别的商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //接收bname线路名称
        //注意，此时前台有可能传递一个bname的值，就为null，也要进行排除掉，此处缺代码
        String bname = request.getParameter("bname");
        if ("null".equals(bname) || bname == null){
            bname = null;
        }else {
            //由于tomcat7版本对url的get请求中文乱码，解决如下：转码
            //此步骤出错：bname没有值为null,转码错误
            bname = new String(bname.getBytes("iso-8859-1"), "utf-8");
        }

        //处理参数
        //注意，此时前台有可能传递一个cid的值，就为null，也要进行排除掉
        int cid = 0;//类别id
        if (cidStr != null && cidStr.length()>0 && !"null".equals(cidStr)){
            cid = Integer.parseInt(cidStr);
        }

        int currentPage = 0;//当前页码，如果不传递，默认为第一页
        if (currentPageStr != null && currentPageStr.length()>0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }

        int pageSize = 0;//每页显示条数,如果不传递，默认每页显示6条记录
        if (pageSizeStr != null && pageSizeStr.length()>0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else {
            pageSize = 6;
        }
        //调用service查询PageBean对象
        PageBean<BoardGame> pb = boardGameService.PageQuery(cid, currentPage, pageSize,bname);
        //将PageBean对象序列化为json，返回
        writeValue(pb,response);
    }

    /**
     * 根据bid查询一个桌游的详细信息
     * 用于展示商品的详细页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收id
        String bid = request.getParameter("bid");
        //调用service方法查询BoardGame对象
        BoardGame boardgame = boardGameService.findOne(bid);
        //转为json写回客户端
        writeValue(boardgame,response);
    }

    /**
     * 判断当前登录用户是否评分过该桌游
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isMark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路id
        String bid = request.getParameter("bid");
        //获取当前登录用户user
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if (user == null){
            //用户尚未登录
            uid = 0;
        }else {
            //用户已经登录
            uid = user.getUid();
        }
        //调用MarkServlet查询是否评分过该商品
        Mark mark = markService.myMark(bid, uid);
        //将mark写回客户端
        writeValue(mark,response);
        //若该用户还未打分则mark返回为空
    }

    /**
     * 评分
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addMark(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路bid
        String bid = request.getParameter("bid");
        //获取当前登录的用户
        User user = (User) request.getSession().getAttribute("user");
        int score = 0;//从前台获取用户打分分数
        int uid;//用户id
        if (user == null){
            //用户尚未登录,直接返回，前台没有数据，也可做判断
            return;
        }else {
            //用户已经登录
            uid = user.getUid();
        }
        //调用service添加
        markService.add(bid, score, uid);
    }

    /**
     * 购买商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void purchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路bid
        String bid = request.getParameter("bid");
        //获取当前登录的用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if (user == null){
            //用户尚未登录,直接返回，前台没有数据，也可做判断
            return;
        }else {
            //用户已经登录
            uid = user.getUid();
        }
        //调用service添加
        purchaseService.buy(bid);
    }

    /**
     *添加评论
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void comment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路bid
        String bid = request.getParameter("bid");
        //获取当前登录的用户
        User user = (User) request.getSession().getAttribute("user");
        String comment = request.getParameter("comment");//从前台获取用户评论内容
        int uid;//用户id
        if (user == null){
            //用户尚未登录,直接返回，前台没有数据，也可做判断
            return;
        }else {
            //用户已经登录
            uid = user.getUid();
        }
        //调用service添加
        commentService.addComment(bid, comment, uid);
    }
}
