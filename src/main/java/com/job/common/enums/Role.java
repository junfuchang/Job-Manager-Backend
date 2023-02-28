package com.job.common.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Role {
    /**
     * 表示角色信息，角色的权限依次递增，0表示权限最低
     * 使用 Role.getCode(0) 获取权限值
     */
    public static final HashMap<String,Integer> List= new HashMap<String,Integer>(){{
        put("STUDENT",0);
        put("COMPANY",1);
        put("ADMIN",2);
    }};
    public static Integer getCode(String role){
        Integer code = Role.List.get(role);
        if(code == null){
            return 0;
        }
        return code;
    }
}
