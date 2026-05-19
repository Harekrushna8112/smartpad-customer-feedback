package com.kristallball.Utility;

import java.lang.reflect.Method;


public class LoggerUtil {
    

    public static void logStatus(String type,String message,String status) {

        System.out.println(String.format("%s | %s | %s | %s",java.time.LocalDateTime.now(),type,message,status));
    }

    public static void log(Method method) {

        LoggerUtil.logStatus("INFO",method.getName(),"Test Started");
    }
}

