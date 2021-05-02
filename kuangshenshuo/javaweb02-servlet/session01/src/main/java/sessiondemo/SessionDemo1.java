package sessiondemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决编码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;character=utf-8");

        //得到session
        HttpSession session = req.getSession();

        //给session存东西
        session.setAttribute("name", new Person("longge",2));

        //获取ID
        String sessionID = session.getId();

        //判断是不是新建的
        if (session.isNew()){
            resp.getWriter().write("session 创建成功"+sessionID);
        }else {
            resp.getWriter().write("session 已存在"+sessionID);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
