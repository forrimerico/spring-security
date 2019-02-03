package com.imooc.web.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Callable;

public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/order")
    public String order() throws Exception
    {
        logger.info("主线程开始");
//        Thread.sleep(1000);
        // 这种方式写代码，可以极大提高系统吞吐量
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程结束");

                return "success";
            }
        };
        logger.info("主线程结束");

        return "success";
    }
}
