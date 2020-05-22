package com.jxufe.sight.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (request.getSession().getAttribute("user") == null) {
            // 获取到项目名，以便下面进行重定向
            String homeUrl = request.getContextPath();
            // 如果是 ajax 请求，则设置 session 状态 、CONTEXTPATH 的路径值
            // 如果是ajax请求响应头会有，x-requested-with
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                response.setHeader("SESSIONSTATUS", "TIMEOUT");
                response.setHeader("CONTEXTPATH", homeUrl+"/admin");
                // FORBIDDEN，forbidden。也就是禁止、403
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }else{
                // 如果不是 ajax 请求，则直接跳转即可
                response.sendRedirect("/admin");
            }
            return false;
        }
        return true;
    }
}
