package com.xuyangl.portal.filter;
/**
 * 跨域设置
 */

import  javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class CrosFilter implements  Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String origin = request.getHeader("Origin");
        if(origin!=null){

            response.addHeader("Access-Control-Allow-Origin",origin);
            response.addHeader("Access-Control-Allow-Headers","Authorization");
        }
        //带有cookie的跨域请求必须使用全url
        response.addHeader("Access-Control-Allow-Methods","*");

        //开启cookie
        response.addHeader("Access-Control-Allow-Credentials","true");

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
