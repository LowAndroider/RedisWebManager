package com.djh.core.interceptor;

import com.djh.core.wrapper.RequestWrapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RequestInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        // 所有请求第一个进入的方法
        String reqURL = httpServletRequest.getRequestURL().toString();
        String ip = httpServletRequest.getRemoteHost ();
        RequestWrapper requestWrapper=new RequestWrapper(httpServletRequest);
        InputStream is = requestWrapper.getInputStream ();
        StringBuilder responseStrBuilder = new StringBuilder ();
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String inputStr;
        while ((inputStr = streamReader.readLine ()) != null) {
            responseStrBuilder.append(inputStr);
        }

        long startTime = System.currentTimeMillis();
        httpServletRequest.setAttribute("startTime", startTime);
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);
            sb.append("------------------------------------------------------------\n");
            HandlerMethod h = (HandlerMethod) handler;
            //Controller 的包名
            sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
            //方法名称
            sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
            //请求方式  post\put\get 等等
            sb.append("RequestMethod    : ").append(httpServletRequest.getMethod()).append("\n");
            //所有的请求参数
            sb.append("Params    : ").append(getParameterInfo(httpServletRequest).toString()).append("\n");
            sb.append("body: ").append(responseStrBuilder.toString()).append("\n");
            //部分请求链接
            sb.append("URI       : ").append(httpServletRequest.getRequestURI()).append("\n");
            //完整的请求链接
            sb.append("AllURI    : ").append(reqURL).append("\n");
            //请求方的 ip地址
            sb.append("request IP: ").append(ip).append("\n");

            System.out.println(sb.toString());

        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private Map<String, Object> getParameterInfo(HttpServletRequest request) {
        Map<String, Object> parameter = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            parameter.put(key, request.getParameter(key));
        }

        return parameter;
    }
}