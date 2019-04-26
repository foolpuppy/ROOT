package top.wigon.servlet.payment;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import top.wigon.alipay.config.AlipayConfig;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 18:52
 **/
//@WebServlet("/pay")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//        //设置请求参数
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(req.getParameter("order_id").getBytes("ISO-8859-1"), "UTF-8");
        //付款金额，必填
        String total_amount = new String(req.getParameter("money").getBytes("ISO-8859-1"), "UTF-8");
        //订单名称，必填
        String subject = new String(req.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
        //商品描述，可空
        String body = new String(req.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(out_trade_no + " " + total_amount + " " + subject + " " + body);
//        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
//                + "\"total_amount\":\"" + total_amount + "\","
//                + "\"subject\":\"" + subject + "\","
//                + "\"body\":\"" + body + "\","
//                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
//        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//        //		+ "\"total_amount\":\""+ total_amount +"\","
//        //		+ "\"subject\":\""+ subject +"\","
//        //		+ "\"body\":\""+ body +"\","
//        //		+ "\"timeout_express\":\"10m\","
//        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
//
//        //请求
//        String result = null;
//        try {
//            result = alipayClient.pageExecute(alipayRequest).getBody();
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//
//        //输出
//        resp.getWriter().println(result);
    }
}
