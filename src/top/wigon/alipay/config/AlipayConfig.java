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
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCQLVioTkq4izNqJF8j46isAUVQrautRwT91671je5ZBMTS3F90J1hVE4x0AXgcqVFdIWfhlbyZSif2zDcvlhmHhN/sT6DagxuMIOH+o0ZfGt7Fm1XkfbMARC9vkTDGE1LU3k7P6NfAb0lIAu8Nnq/CUfbOvtgxHPMDNFxE0H2EKeBV3cn7BIGb3YZQ/xTnZcLi/73OrAj81B6EnxQxdMMcqHbObirgxGk5bG3ry5QpMAPVaYsOfE2N/cz1vTSzsFhcdvms2mhnf7mnhAh+6HFXJLzP0VrM2/Wck6cQxUPDvVbwT1/J5ZpPcyb2vhHrhIW1PJYm2ScROHUpMtWkb/G5AgMBAAECggEADkeff1P5zJtk5T9i+PAEdbzOe7Ynycq98NJa7tE26TQytlvDTILVGeAMyjSXC+etOlcjrdEh0+DnYmdJk/n+31BGyWX9nYbcxJ1BJPJQ9vx3UgUXlcDpaL5YIGm19fhV/OVj0u3R6KpdDLfVq3irGcj6c/GtAfhHDWszNFGeDOfdb0VkGXFyFPmS6v2W4lFd1Lqo2yELaKzYf1D2cHjo/rKd2tXba4L36Gw2xyQiOHj7E4oWL4J/DSvG1DKxtOf8ozW+1qacvt456wbV+xTs2c1TeP9XuwFNvXCSrrQAfr3mV6nDo47DOiNaOSnedqXAxCfw2qX7ayTkYlmPxzkrgQKBgQD7sIvAXl8QOi3Zw3pQYCJwaPOxVddP/ywkWyCaYg0E2GKAcvJKFJNSeK913w/2tZmgOWuVgdBhfuMzyaBHAGlOgqe2Ho+omdgWwZThQi5ne5IbPC4EE0vC/e+DYiK+XMvyZu+YpUqoDjDmH6sXS84yG4xoiesZGhZ2b/dIfikPEQKBgQCSpXIWR0c9x0uU3fRiuQaAQwyoG4WMAHJBEUKd4UHnD/PoLkxD0KIQ0lLATuA9ZKHOCQj5O7cj4O1mptPFw54PNPBFycm6V377oF+D7DIOAnPvxZ1k6MVLANUeOonI7qNCotkAjcYZ70f/RZRGhiWlrU0RJ3Jo8lkwaE4zeSQIKQKBgCjtZ3xLnEfGPih4Gg6x40fGOUJwBAg1JVdwHhgcs6NDEJl0l6OmPuKdT2Lqd+0VULr2O2Ffb6Q6/vUv50lEbttecakyxQeUpMfmiLAsk+Et/e9B1PXCsYIuyuDhd2bfLibnyDRZRI+ZZyg0pBywrgIF6sohC0LUtCxkPqDiKwkRAoGALyDop2xE4v/XtIIYdlnMUxA5UxV1N+c00OCBLkgka+PemTG35Nt6GjndylwPCOv8bEDPF3ovg2JYKXNX/+i8NVroFSWipTZVYvzJdZZFB+eV5ur1iGaecVpVI5/ghCjdYx7+6oSls9QIqWttGbUnCDXH3Ml2pW+tZjc/Wp+GCvECgYAv6zCZowTTNe+1wK++Lk2xJ9UlVXNhz9h8jKYGIQ71MiN8vMxz+AtEni7eM4AzE/3CwN0riwyidhjHQkR46xS/5+fcQiLodfR9rp+uN1W23D4lqeu8K2YKVhJ95txzadLfCUbpGVWGAkA4Rx1jbZ87q9I0Xgn6QnDi0obX68SG6g==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArOemhl/eZM0RaTBG/2eCoYlbc8dy3MQe2X4NPh8cylxQ6AUl+DN+qvTr6fWu/SJltCdK8NQA6wE1F8MfMo5Z/TwRqbr1bl/8qYwk86eUEoUPOMOG/UR5fEfcJIIHwYKQ3/Y5ywH0FWhjeOLO552EAAEemRIPAShEHgSMPpTJRKPubbOQhE6xMEf9gTqqvX9plLZkCHFnKnMaV6LImm3dmcI6EM8LTu4dABSLQ/mbmGnvpkczplEFwviQpJQQGZZTsUurhHofp3eUDV0eSRMyjn5O71xQCrC3y2VDr7zeWHqo2mnH+wwl91Jeyyl3HuBrcumn0079a1/i9HSG+z9u7wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://beauty9.xicp.net/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
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

