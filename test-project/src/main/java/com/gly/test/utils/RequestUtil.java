//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.gly.test.utils;

import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public RequestUtil() {
    }

    public static Map<String, String> allHead(HttpServletRequest request) {
        Map<String, String> map = new HashMap();
        Enumeration headerNames = request.getHeaderNames();

        while(headerNames.hasMoreElements()) {
            String key = (String)headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ip)) {
            ip = request.getHeader("Client_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
                InetAddress inet = null;

                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException var4) {
                    var4.printStackTrace();
                }

                ip = inet.getHostAddress();
            }
        }

        if (!StringUtils.isEmpty(ip)) {
            List<String> list = stringToList(ip, ",");
            if (list.size() > 1) {
                ip = (String)list.get(0);
            }
        }

        return ip;
    }

    private static List<String> stringToList(String str, String split) {
        List<String> list = new ArrayList();
        if (StringUtils.isEmpty(str)) {
            return list;
        } else {
            String[] var3 = str.split(split);
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String s = var3[var5];
                if (!StringUtils.isEmpty(s)) {
                    list.add(s);
                }
            }

            return list;
        }
    }
}
