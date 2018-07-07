package com.xuyangl.portal.filter;

import com.xuyangl.portal.domain.Audience;
import com.xuyangl.portal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/27 15:59
 */
public class JwtFilter extends GenericFilterBean{

    @Autowired
    private Audience audience;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //获得请求头的authorization字段的值
        String authorization = httpServletRequest.getHeader("Authorization");
        if ("OPTIONS".equals(httpServletRequest.getMethod()))
        {

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            if (authorization==null||!authorization.startsWith("bearer;"))
            {
//                System.out.println("wrong authorization");
//                    return ;
            }else{
                String token = authorization.substring(7);

                try{
                    if (audience==null)
                    {
                        BeanFactory beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(httpServletRequest.getServletContext());
                        audience = (Audience)beanFactory.getBean("audience");
                    }

                    final Claims claims = JwtUtil.parseJWT(token,audience.getBase64Secret());
//                httpServletRequest.setAttribute(Constants.CLAIMS,claims);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
