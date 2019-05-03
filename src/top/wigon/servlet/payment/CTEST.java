package top.wigon.servlet.payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/3 12:58
 **/
@WebServlet("/CTEST")
public class CTEST  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println((Arrays.toString(req.getParameterValues("goodsList"))));
        System.out.println(req.getParameter("goodsList"));
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write("失败?");
    }
}
