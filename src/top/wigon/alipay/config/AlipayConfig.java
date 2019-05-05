package top.wigon.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016100100635864";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCVcn071ZwSYbEuFG7nNt6nNqKzqUj7QWbkd9sDJtdxCwKbjpAn6RepZbtmER930Fukt1zpeguD5Eejws6pG12YH5qmsH1wPPULAxM6XYFzDxRqMnpVsIE7pdTu/m8NdHgT8ki7HT6BwwBdS44iUy6rgwiDVz4vng85GyYHTkasCLcxlRsrYLgtbyaljRP/UT/Bz+ixqabtwpI+S+wdzGHRC+sl3neC9s3e6Uz/I55Ul5cPDRKhcEkdaJsG7piY8dLord3QI3c8TR92WVQsv/QJlpdRQtKDT3vz6vQgIm5YxgaOIcs9oihP6PVzp8ixu7UbzpF/VAZ2jP44alTnYLszAgMBAAECggEAOkD4g/xN6/RcpkOcv0/qFm/7l+Ci7B2gR+pYWrAnRo8uIwi9NHFtocBf/fcqtv9m2ZwIAZJrLqwrKLBk8hISt5uKIvOk0b1RH0vBkPyl2v3DzWmDuiclGOUZTVesXihKLixBIX7SwK4MVFGBQ+v8wyo+hUPan6ES+gWVGz/t2Fyn1i02UtxjScQD4NrsoqgT4+v6PbxJvWVXw/lk8yZvgNYY7D2ZgC4eKEwUxZ1DreQVkC0Bg2MbH7kW/A9MTAypEKM6QcWKLmfpcfyOYcYWw/ViBiydi389YGEj+rIxWRfapU6tZmOB/DDTlj2QDJ3p34yL4g+lALojRHZbPY4X4QKBgQD8uy+yWnSVFZbTxfJqVVRsPQaapJJOK/s5E+96qTKI0va8LHVMBJzgG2J0cGI49ofWPaxE/mvDm138+7fMppN1bv4WGlyRl5Edx6RSVBnq2keYjUGPT26uORAe+moAyHW89QRqe3361FoGGgxszKiOK1hinQdJLF+4SC+GpjRouQKBgQCXYVI5VdDMRLoF+4j4dFPIwYkrAASxTpCZ6KvC4bzBNan60iSMOERrhmAX7zLSgY8MEvNlRdCbXaR+r6h5DvWXzi6UIZs+1QkM8n1yQpZbf3nn5t9A6q0GkthiRENcUIHLZnmGd51zIfDxpOoKwwscONmje95Q23jQBg88m7X1SwKBgQD4u3Fx4zyiDaFnw4WVyW1RKa56PEYR0Y9q2Yfz/NnTd22GPWsj6dZLaig32POShG+kFwaY0J1W4m5aMZLvQ3IVPausLT21vKoB2R6MOGFZloKoTT2cwdx4c4i+NE5nfuMBmVNDSU7vslb3cmOQIMwzP825IDqvdZCvWbwMlT83YQKBgESqwMGBS9Vc14UfNGJ/YgIOyEnZGEfVe4JVKJSeESETVqeP60QvwdmEetJgjo0ud9TiQ8YMhTP0pklRJPrE7mKOBFLta550xEY7OOw7iDi4+nNXJq4rxZDVy5HHpUaavkWlljqIx8MSAlmalQ+Mqd2DbDXcWlwTMhoqpX64ozFBAoGAEbLrYRyKZFudzfhcYWWWnrK9R375HXrAG/oKUm55LocDdXZ9Xlcd4lEQo4saEUohF7doZ0B4/7VEptmbIwLU5wFSOb0wm9XBlLiRrVoX2+1v18gyVU/LRm+9il3/iRYNFlEBOq0EBPco1niEema516upo1WGCvQ5Xw0R5JfKSYU=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArOemhl/eZM0RaTBG/2eCoYlbc8dy3MQe2X4NPh8cylxQ6AUl+DN+qvTr6fWu/SJltCdK8NQA6wE1F8MfMo5Z/TwRqbr1bl/8qYwk86eUEoUPOMOG/UR5fEfcJIIHwYKQ3/Y5ywH0FWhjeOLO552EAAEemRIPAShEHgSMPpTJRKPubbOQhE6xMEf9gTqqvX9plLZkCHFnKnMaV6LImm3dmcI6EM8LTu4dABSLQ/mbmGnvpkczplEFwviQpJQQGZZTsUurhHofp3eUDV0eSRMyjn5O71xQCrC3y2VDr7zeWHqo2mnH+wwl91Jeyyl3HuBrcumn0079a1/i9HSG+z9u7wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://beauty9.xicp.net/notify_url.jsp";
    public static String notify_url = "http://beauty9.xicp.net/payCheck";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://beauty9.xicp.net/consumer_center.html";
    public static String return_url = "http://beauty9.xicp.net/consumer_center.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /*
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     *
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}

