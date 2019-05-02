package top.wigon.servlet.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.wigon.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/2 21:00
 **/
@WebServlet("/getUnPaidOrders")
public class GetUserOrderInfoUnPaid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String JSON = userService.getUserOrderUnPaidInfoByTel((String) req.getSession().getAttribute("user_tel"));
        StringBuffer content = new StringBuffer();
        content.append("{\n" +
                "  \"status\": 0,\n" +
                "  \"confirmOrders\": [\n" +
                "    {\n" +
                "      \"orderList\":");
        content.append(JSON);
        content.append(",\"amount\":");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(JSON);
        content.append(node.findValue("payment"));
        content.append("}]}");
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(content.toString());
    }
}
