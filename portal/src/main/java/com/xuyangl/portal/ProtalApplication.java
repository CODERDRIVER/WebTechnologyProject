package com.xuyangl.portal;

import com.xuyangl.portal.filter.CrosFilter;
import com.xuyangl.portal.filter.JwtFilter;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProtalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtalApplication.class, args);
	}

	//解决跨域的过滤器
	@Bean
	public FilterRegistrationBean myFilter(){

		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new CrosFilter());
		return filterRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterRegistrationBean  = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());

		//添加需要拦截的url
//		List<String> list = new ArrayList<>();
//		list.add("/user/**");
		return filterRegistrationBean;
	}
}
