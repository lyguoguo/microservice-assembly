//package com.gly.test.filter;
//
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.annotation.Order;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Arrays;
//import java.util.concurrent.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Slf4j
//@Order(-999)
//@WebFilter(urlPatterns = {"/*"})
//public class TimeoutFilter extends OncePerRequestFilter {
//
//    private String[] interPath = {"/hello/timeout"};
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        String srcId = getSrcIdByRequest(request.getRequestURI());
//        if(Arrays.asList(interPath).contains(srcId)){
//            final ExecutorService exec = Executors.newFixedThreadPool(1);
//            Callable<Object> call = new Callable<Object>() {
//                public Object call() throws Exception {
//                    return chain.doFilter(request,response);
//                }
//            };
//
//            PrintWriter writer = null;
//            response.setHeader("Content-type", "application/json;charset=UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            try {
//                writer = response.getWriter();
//
//                Future<Object> future = exec.submit(call);
//                Object result = null; // 任务处理超时时间设为10秒
//                try {
//                    result = future.get(3*1000, TimeUnit.MILLISECONDS);
//                    writer.write(JSONObject.toJSONString(result));
//                } catch (InterruptedException e) {
//                    writer.write("处理中断啦");
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                    writer.write("处理异常啦");
//                } catch (TimeoutException e) {
//                    e.printStackTrace();
//                    writer.write("处理超时啦");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                writer.write("IO异常啦");
//            }finally {
//                if (writer != null)
//                    writer.close();
//            }
//        }
//    }
//
//    private String getSrcIdByRequest(String requestURI) {
//        int indexOf = requestURI.indexOf("/r/");
//        //跳过“r”后的“/”
//        int startIdx = indexOf + 3;
//        //后面第一个“/”字符前面的位置
//        int lastIdx = requestURI.length()-1;
//        String lastStr = requestURI.substring(startIdx,requestURI.length()-1);
//        Matcher matcher= Pattern.compile("/").matcher(lastStr);
//        if(matcher.find()){
//            lastIdx = matcher.start();
//        }
//        return lastStr.substring(0,lastIdx);
//    }
//}
