package top.wigon.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.entity.Package;
import top.wigon.service.impl.ShippingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/5/3 0:55
 **/
@WebServlet("/getUserShippingByUserid")
public class GetUserShippingInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ShippingServiceImpl shippingService = new ShippingServiceImpl();
        //返回模糊查询的商品集合
        List<Package> items = shippingService.getShippingInfoByUserId((String) req.getSession().getAttribute("user_id"));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON = objectMapper.writeValueAsString(items);
        StringBuilder content = new StringBuilder();
        content.append("{\n" +
                "  \"status\": 0,\n" +
                "  \"packageList\": ");
        content.append(JSON);
        content.append("}");
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(content.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
