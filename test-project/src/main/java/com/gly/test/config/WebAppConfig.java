//package com.gly.test.config;
//
//import com.gly.test.interceptors.MvcInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebAppConfig implements WebMvcConfigurer {
//
//    @Bean
//    public MvcInterceptor getMvcInstance(){
//        return new MvcInterceptor();
//    }
//
////    实现拦截器 要拦截的路径以及不拦截的路径
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(getMvcInstance());
//    }
//}
