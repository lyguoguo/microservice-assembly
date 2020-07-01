package com.gly.oom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class OomProjectApplication {

    private static Logger logger = LogManager.getLogger(OomProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OomProjectApplication.class, args);
        new Thread(()->{
//            oom();
            OOM.oom();
        }).start();
        logger.info("=========Oom-project启动完成==========");
    }

    private static void oom(){
        List<Pilot> list = new ArrayList<>();
        while (true){
            int random = (int) (Math.random()*100+1);
            list.add(new Pilot("郭郭"+random,random,"MAT 不是一个万能工具，它并不能处理所有类型的堆存储文件。但是比较主流的厂家和格式，例如 Sun, HP, SAP 所采用的 HPROF 二进制堆存储文件，以及 IBM 的 PHD 堆存储文件等都能被很好的解析。下面来看看要怎么做呢，也许对你有用。官方文档：http://help.eclipse.org/luna/index.jsp?topic=/org.eclipse.mat.ui.help/welcome.html\n" +
                    "\nMAT 不是一个万能工具，它并不能处理所有类型的堆存储文件。但是比较主流的厂家和格式，例如 Sun, HP, SAP 所采用的 HPROF 二进制堆存储文件，以及 IBM 的 PHD 堆存储文件等都能被很好的解析。下面来看看要怎么做呢，也许对你有用。官方文档：http://help.eclipse.org/luna/index.jsp?topic=/org.eclipse.mat.ui.help/welcome.html\n" +
                    "\nMAT 不是一个万能工具，它并不能处理所有类型的堆存储文件。但是比较主流的厂家和格式，例如 Sun, HP, SAP 所采用的 HPROF 二进制堆存储文件，以及 IBM 的 PHD 堆存储文件等都能被很好的解析。下面来看看要怎么做呢，也许对你有用。官方文档：http://help.eclipse.org/luna/index.jsp?topic=/org.eclipse.mat.ui.help/welcome.html\n" +
                    "\n"));
            logger.info("【OomProjectApplication->main】当前list容量：{}",list.size());
        }

    }

}
