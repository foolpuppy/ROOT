package top.wigon.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/28 10:21
 **/
public class ResponseUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }
}
