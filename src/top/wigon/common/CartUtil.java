package top.wigon.common;

import top.wigon.entity.CartInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/30 13:17
 **/
public class CartUtil {
    /**
     * 获取名为"cart"的cookie
     *
     * @param request
     * @return cookie
     */
    public static Cookie getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cart_cookie = null;
        for (Cookie cookie : cookies) {
            if ("cart".equals(cookie.getName())) {
                //获取购物车cookie
                cart_cookie = cookie;
            } else {
                cart_cookie = new Cookie("cart", "");
            }
        }
        return cart_cookie;
    }

    /**
     * 获取cookie中的购物车列表
     *
     * @param response
     * @param request
     * @return 购物车列表
     * @throws UnsupportedEncodingException 抛出异常
     */
    public List<CartInfo> getCartInCookie(HttpServletResponse response, HttpServletRequest request) throws
            UnsupportedEncodingException {
        // 定义空的购物车列表
        List<CartInfo> items = new ArrayList<CartInfo>();
        String value_1st = "";
        // 购物cookie
        Cookie cart_cookie = getCookie(request);
        // 判断cookie是否为空
        if (cart_cookie != null) {
            // 获取cookie中String类型的value
            value_1st = URLDecoder.decode(cart_cookie.getValue(), "utf-8");
            //从cookie获取购物车
            // 判断value是否为空或者""字符串
            if (value_1st != null && !"".equals(value_1st)) {
                // 解析字符串中的数据为对象并封装至list中返回给上一级
                String[] arr_1st = value_1st.split("==");
                CartInfo cartInfo = new CartInfo();
                for (String value_2st : arr_1st) {
                    String[] arr_2st = value_2st.split("=");
                    cartInfo.setItemId(arr_2st[0]);
                    //商品id
                    cartInfo.setNum(Integer.parseInt(arr_2st[1]));
                    //加入购物车数量
                    items.add(cartInfo);
                }
            }
        }
        return items;

    }

    /**
     * 制作cookie所需value
     *
     * @param cartVos 购物车列表
     * @return 解析为字符串的购物车列表，属性间使用"="相隔，对象间使用"=="相隔
     */
    public static String setCookiesVal(List<CartInfo> cartVos) {
        StringBuffer buffer_2st = new StringBuffer();
        for (CartInfo item : cartVos) {
            buffer_2st.append(item.getItemId() + "=" + item.getNum() + "==");
        }
        return buffer_2st.toString().substring(0, buffer_2st.toString().length() - 2);
    }
}
