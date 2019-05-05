package top.wigon.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.entity.User;
import top.wigon.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/5 15:32
 **/
@WebServlet("/getUser")
public class QueryUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleType = req.getParameter("roleType");
        List<User> users;
        UserServiceImpl userService = new UserServiceImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> whereMap = new HashMap<>();
        try {
            if (req.getParameter("userId") != null) {
                whereMap.put("user_id", req.getParameter("userId"));
            }
            if (req.getParameter("userName") != null) {
                whereMap.put("username", req.getParameter("userName"));
            }
            if (req.getParameter("tel") != null) {
                whereMap.put("tel", req.getParameter("tel"));
            }
            if (req.getParameter("email") != null) {
                whereMap.put("email", req.getParameter("email"));
            }
            users = whereMap.size() > 0 ? userService.getUserByRole(roleType, whereMap) : userService.getUserByRole(roleType);
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            String JSON = objectMapper.writeValueAsString(users);
            StringBuilder content = new StringBuilder();
            content.append("{\n" +
                    "  \"code\": 0\n" +
                    "  ,\"msg\": \"\"\n" +
                    "  ,\"count\": \"" + users.size() + "\"\n" +
                    "  ,\"data\": \n");
            content.append(JSON);
            content.append("}");
            resp.setContentType("text/plain; charset=UTF-8;");
            resp.getWriter().write(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
