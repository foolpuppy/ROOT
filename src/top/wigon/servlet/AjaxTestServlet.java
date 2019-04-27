package top.wigon.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import top.wigon.common.DBUtils;
import top.wigon.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 22:29
 **/
@WebServlet("/get")
public class AjaxTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = new Item("0000001", "小米10", "电子产品", new BigDecimal(9999), 100, 1, 100001);
        ObjectMapper objectMapper = new ObjectMapper();
        //设置序列化后的格式，INDENT_OUTPUT表示缩进输出，true表示试该配置生效
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String JSON2 = objectMapper.writeValueAsString(item);
        System.out.println(JSON2);
        resp.getWriter().print(JSON2);
    }
}
