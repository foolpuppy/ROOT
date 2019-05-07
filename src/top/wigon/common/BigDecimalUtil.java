package top.wigon.common;

import java.math.BigDecimal;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/28 13:03
 * 本工具类用于BigDecimal 数据类型的数据添加
 **/
public class BigDecimalUtil {
    public static BigDecimal add(double a, double b) {
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        return b1.add(b2);
    }

    public static BigDecimal sub(double a, double b) {
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        return b1.subtract(b2);
    }

    public static BigDecimal mul(double a, double b) {
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        return b1.multiply(b2);
    }

    public static BigDecimal div(double a, double b) {
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
    }
}
