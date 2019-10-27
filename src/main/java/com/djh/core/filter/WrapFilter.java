package com.djh.core.filter;

import com.djh.core.wrapper.RequestWrapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 用于替换默认的 HttpServletRequest
 * @author Djh
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WrapFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        ServletRequest requestWrapper = new RequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
