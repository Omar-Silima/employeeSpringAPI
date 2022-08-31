//package com.sms.configs;
//
//import com.sun.net.httpserver.Filter;
//import com.sun.net.httpserver.HttpExchange;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CORSFilter extends GenericFilterBean implements Filter {
//    @Override
//    public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
//
//    }
//
//    @Override
//    public String description() {
//        return null;
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletResponse servletResponse = (HttpServletResponse) response;
//
//        servletResponse.setHeader("Access-Control-Allow-Origin", "*");
//        servletResponse.setHeader("Access-Control-Allow-Methods", "*");
//        servletResponse.setHeader("Access-Control-Allow-Headers", "*");
//        servletResponse.setHeader("Access-Control-Allow-Credentials", "*");
//        servletResponse.setHeader("Access-Control-Allow-Max-Age", "3600");
//
//        chain.doFilter(request, response);
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
//
//        registrationBean.setName("CORS Filter");
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(1);
//
//        return  registrationBean;
//    }
//}
