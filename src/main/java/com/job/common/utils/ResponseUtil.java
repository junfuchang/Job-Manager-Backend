package com.job.common.utils;


import cn.hutool.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于将json写入response中
 */
public class ResponseUtil {
    public static String write(HttpServletResponse response, String content){
        try{
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(content);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
