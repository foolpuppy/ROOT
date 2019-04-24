package top.wigon.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/10 15:56
 **/
@WebFilter("/*")
public class CharSetEncodingServlet implements Filter {
    private FilterConfig filterConfig = null;
    private String defaultCharset = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) {
        //得到过滤器的初始化配置信息
        this.filterConfig = filterConfig;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //取web.xml的值
        String charset = filterConfig.getInitParameter("charset");
        if (null == charset) {
            charset = defaultCharset;
        }
        //设置请求的字符集
        httpServletRequest.setCharacterEncoding("UTF-8");
        //为响应设置编码
        httpServletResponse.setContentType("text/html;charset=" + charset);
        //转发
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
