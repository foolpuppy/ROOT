package top.wigon.servlet.user;

import top.wigon.entity.User;
import top.wigon.service.UserService;
import top.wigon.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 11:13
 **/
public class UserLoginServet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tel=req.getParameter("phone");
        String password=req.getParameter("password");
        User user=new User();
        user.setTel(tel);;
        user.setPassword(password);
        UserService userService=new UserServiceImpl();
        boolean login=userService.userLogin(user);
        if (login){

        }else {

        }
    }
}
