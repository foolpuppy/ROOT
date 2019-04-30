package top.wigon.servlet.payment;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;

import static com.alipay.api.AlipayConstants.CHARSET_UTF8;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/27 22:25
 **/
public class payTest {
    public static void main(String[] args) throws AlipayApiException {

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016100100635864", "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCQLVioTkq4izNqJF8j46isAUVQrautRwT91671je5ZBMTS3F90J1hVE4x0AXgcqVFdIWfhlbyZSif2zDcvlhmHhN/sT6DagxuMIOH+o0ZfGt7Fm1XkfbMARC9vkTDGE1LU3k7P6NfAb0lIAu8Nnq/CUfbOvtgxHPMDNFxE0H2EKeBV3cn7BIGb3YZQ/xTnZcLi/73OrAj81B6EnxQxdMMcqHbObirgxGk5bG3ry5QpMAPVaYsOfE2N/cz1vTSzsFhcdvms2mhnf7mnhAh+6HFXJLzP0VrM2/Wck6cQxUPDvVbwT1/J5ZpPcyb2vhHrhIW1PJYm2ScROHUpMtWkb/G5AgMBAAECggEADkeff1P5zJtk5T9i+PAEdbzOe7Ynycq98NJa7tE26TQytlvDTILVGeAMyjSXC+etOlcjrdEh0+DnYmdJk/n+31BGyWX9nYbcxJ1BJPJQ9vx3UgUXlcDpaL5YIGm19fhV/OVj0u3R6KpdDLfVq3irGcj6c/GtAfhHDWszNFGeDOfdb0VkGXFyFPmS6v2W4lFd1Lqo2yELaKzYf1D2cHjo/rKd2tXba4L36Gw2xyQiOHj7E4oWL4J/DSvG1DKxtOf8ozW+1qacvt456wbV+xTs2c1TeP9XuwFNvXCSrrQAfr3mV6nDo47DOiNaOSnedqXAxCfw2qX7ayTkYlmPxzkrgQKBgQD7sIvAXl8QOi3Zw3pQYCJwaPOxVddP/ywkWyCaYg0E2GKAcvJKFJNSeK913w/2tZmgOWuVgdBhfuMzyaBHAGlOgqe2Ho+omdgWwZThQi5ne5IbPC4EE0vC/e+DYiK+XMvyZu+YpUqoDjDmH6sXS84yG4xoiesZGhZ2b/dIfikPEQKBgQCSpXIWR0c9x0uU3fRiuQaAQwyoG4WMAHJBEUKd4UHnD/PoLkxD0KIQ0lLATuA9ZKHOCQj5O7cj4O1mptPFw54PNPBFycm6V377oF+D7DIOAnPvxZ1k6MVLANUeOonI7qNCotkAjcYZ70f/RZRGhiWlrU0RJ3Jo8lkwaE4zeSQIKQKBgCjtZ3xLnEfGPih4Gg6x40fGOUJwBAg1JVdwHhgcs6NDEJl0l6OmPuKdT2Lqd+0VULr2O2Ffb6Q6/vUv50lEbttecakyxQeUpMfmiLAsk+Et/e9B1PXCsYIuyuDhd2bfLibnyDRZRI+ZZyg0pBywrgIF6sohC0LUtCxkPqDiKwkRAoGALyDop2xE4v/XtIIYdlnMUxA5UxV1N+c00OCBLkgka+PemTG35Nt6GjndylwPCOv8bEDPF3ovg2JYKXNX/+i8NVroFSWipTZVYvzJdZZFB+eV5ur1iGaecVpVI5/ghCjdYx7+6oSls9QIqWttGbUnCDXH3Ml2pW+tZjc/Wp+GCvECgYAv6zCZowTTNe+1wK++Lk2xJ9UlVXNhz9h8jKYGIQ71MiN8vMxz+AtEni7eM4AzE/3CwN0riwyidhjHQkR46xS/5+fcQiLodfR9rp+uN1W23D4lqeu8K2YKVhJ95txzadLfCUbpGVWGAkA4Rx1jbZ87q9I0Xgn6QnDi0obX68SG6g==", "json", CHARSET_UTF8, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArOemhl/eZM0RaTBG/2eCoYlbc8dy3MQe2X4NPh8cylxQ6AUl+DN+qvTr6fWu/SJltCdK8NQA6wE1F8MfMo5Z/TwRqbr1bl/8qYwk86eUEoUPOMOG/UR5fEfcJIIHwYKQ3/Y5ywH0FWhjeOLO552EAAEemRIPAShEHgSMPpTJRKPubbOQhE6xMEf9gTqqvX9plLZkCHFnKnMaV6LImm3dmcI6EM8LTu4dABSLQ/mbmGnvpkczplEFwviQpJQQGZZTsUurhHofp3eUDV0eSRMyjn5O71xQCrC3y2VDr7zeWHqo2mnH+wwl91Jeyyl3HuBrcumn0079a1/i9HSG+z9u7wIDAQAB", "RSA2");
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        request.setBizModel(model);
        model.setOutTradeNo(String.valueOf(System.currentTimeMillis()));
        model.setTotalAmount("36.99");
        model.setSubject("Iphone6 16G");
        AlipayTradePrecreateResponse response = alipayClient.execute(request);

        System.out.print(response.getBody());
        //System.out.print(response.getQrCode());
    }
}
