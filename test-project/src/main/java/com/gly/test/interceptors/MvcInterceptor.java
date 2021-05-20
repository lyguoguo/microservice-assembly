//package com.gly.test.interceptors;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.util.StopWatch;
//import org.springframework.util.StringUtils;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.Arrays;
//import java.util.Enumeration;
//import java.util.Map;
//import java.util.concurrent.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
///**
// *
// *
// * @Package: com.*.*.interceptor
// * @ClassName: MvcInterceptor
// * @Description:拦截器
// * @author: zk
// * @date: 2019年9月19日 下午2:20:57
// */
//@Slf4j
//public class MvcInterceptor extends HandlerInterceptorAdapter {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    private String[] interPath = {"/hello/timeout"};
//
//
//    /**
//     * 在请求处理之前进行调用（Controller方法调用之前）
//     *
//     * 如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
//     * 如果设置为true时，请求将会继续执行后面的操作
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
////        String srcId = getSrcIdByRequest(request.getRequestURI());
//        String reqUri = request.getServletPath();
//        if(!Arrays.asList(interPath).contains(reqUri)){
//            return true;
//        }
//
//        final ExecutorService exec = Executors.newFixedThreadPool(1);
//        Callable<Object> call = new Callable<Object>() {
//            public Object call() throws Exception {
////                return processByRemote(request,srcId);
//                return processByRemote(request,request.getRequestURL().toString());
//            }
//        };
//
//        PrintWriter writer = null;
//        response.setHeader("Content-type", "application/json;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        try {
//            writer = response.getWriter();
//            Future<Object> future = exec.submit(call);
//            Object result = null; // 任务处理超时时间设为10秒
//            try {
//                StopWatch stopWatch = new StopWatch();
//                stopWatch.start("timeout-task");
//                result = future.get(3*1000, TimeUnit.MILLISECONDS);
//                stopWatch.stop();
//                log.info("方法耗时：{}",stopWatch.prettyPrint());
//                writer.write(JSONObject.toJSONString(result));
//                return true;
//            } catch (InterruptedException e) {
//                log.error("处理中断啦");
//                writer.write("处理中断啦");
//                return false;
//            } catch (ExecutionException e) {
//                log.error("处理异常啦");
//                writer.write("处理异常啦");
//                return false;
//            } catch (TimeoutException e) {
//                log.error("处理超时啦");
//                writer.write("处理超时啦");
//                return false;
//            }
//        } catch (IOException e) {
//            log.error("IO异常啦");
//            writer.write("IO异常啦");
//            return false;
//        }finally {
//            if (writer != null)
//                writer.close();
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
//
//    private Object processByRemote(HttpServletRequest request, String remotePath) throws IOException, URISyntaxException {
//        String requestMethod = request.getMethod();
//        HttpMethod method = HttpMethod.resolve(requestMethod);
//        if(method.matches("GET")){
//            String params = convertGetParam(request);
//            if(!StringUtils.isEmpty(params)){
//                remotePath = remotePath + "?" + params;
//            }
//        }
//        String rawParam = readRaw(request.getInputStream());
//        JSONObject jsonObject = JSON.parseObject(rawParam);
//        HttpHeaders headers = new HttpHeaders();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String key = headerNames.nextElement();
//            String value = request.getHeader(key);
//            headers.add(key,value);
//        }
//        HttpEntity httpEntity = new HttpEntity<>(jsonObject, headers);
//        ResponseEntity resultResponseEntity = restTemplate.getForEntity(new URI(remotePath),String.class);
//
////        ResponseEntity resultResponseEntity = restTemplate.exchange(
////                remotePath,
////                method, httpEntity, Object.class);
//        if (resultResponseEntity.getStatusCode() == HttpStatus.OK) {
//            return resultResponseEntity.getBody();
//        }
//        return resultResponseEntity.getBody();
//    }
//
//    public static String readRaw(InputStream inputStream) {
//        String result = "";
//        try {
//            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = inputStream.read(buffer)) != -1) {
//                outSteam.write(buffer, 0, len);
//            }
//            outSteam.close();
//            inputStream.close();
//            result = new String(outSteam.toByteArray(), "UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//    private String replaceSrcId(String srcId, String remotePath) {
//        if(!remotePath.contains("{srcId}")){
//            return remotePath;
//        }
//        return remotePath.replace("{srcId}",srcId);
//    }
//
//    private String convertGetParam(HttpServletRequest request) {
//        StringBuffer sb = new StringBuffer();
//        Map<String,String[]> reqMap = request.getParameterMap();
//        reqMap.forEach((key,value)->{
//            sb.append(key).append("=").append(value[0]).append("&");
//        });
//        return sb.toString().length()==0?sb.toString():sb.toString().substring(0,sb.toString().length()-1);
//    }
//
//    /**
//     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
////         System.out.println("执行了TestInterceptor的postHandle方法");
//    }
//
//    /**
//     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
////        System.out.println("执行了TestInterceptor的afterCompletion方法");
//    }
//
//
//}