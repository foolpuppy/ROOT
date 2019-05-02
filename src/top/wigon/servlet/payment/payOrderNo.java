package top.wigon.servlet.payment;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import top.wigon.alipay.config.AlipayConfig;
import top.wigon.entity.Order;
import top.wigon.entity.Shipping;
import top.wigon.service.impl.OrderServiceImpl;
import top.wigon.service.impl.ShippingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/27 22:18
 **/
@WebServlet("/GoPay")
public class payOrderNo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order_no = req.getParameter("order_no") != null ? req.getParameter("order_no") : (String) req.getSession().getAttribute("order_no");
        //数据库取得相应订单号的支付信息
        OrderServiceImpl orderService = new OrderServiceImpl();
        ShippingServiceImpl shippingService = new ShippingServiceImpl();
        Shipping shipping = new Shipping();
        shipping.setOrderId(order_no);
        shipping.setReceiverName(req.getParameter("name"));
        shipping.setReceiverTel(req.getParameter("tel"));
        shipping.setReceiverState(req.getParameter("province"));
        shipping.setReceiverCity(req.getParameter("city"));
        shipping.setReceiverDistrict(req.getParameter("district"));
        shipping.setReceiverZip(req.getParameter("zip"));
        shipping.setReceiverAddress(req.getParameter("address"));
        Order order = orderService.getByOrderNo(order_no);
        shippingService.add(shipping);
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = order_no;
        //付款金额，必填
        String total_amount = order.getPayment().toString();
        //订单名称，必填
        String subject = "电子商城订单";
        //商品描述，可空
        String body = "";

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"" + timeout_express + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
            //write才能跳转支付
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(result);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
