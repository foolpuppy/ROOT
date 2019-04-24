package test;

import sun.util.calendar.LocalGregorianCalendar;
import top.wigon.common.DBUtils;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/24 18:56
 **/
public class test {
    public static void main(String[] args) throws SQLException {
        Map<String, Object> val = new HashMap<>();
        val.put("now",DBUtils.getCurrDateTime());
        System.out.println(new java.sql.Timestamp(new java.util.Date().getTime()));
        System.out.println(DBUtils.getCurrDateTime());
        DBUtils.insert("test",val);


    }
}
