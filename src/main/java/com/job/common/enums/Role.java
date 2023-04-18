package com.job.common.enums;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Objects;

@Getter
public enum Role {
    STUDENT("STUDENT",0), // 0
    COMPANY("COMPANY",1), // 1
    ADMIN("ADMIN",2); // 2

    private String roleName;
    private Integer roleCode;

    Role(String roleName, Integer roleCode) {
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    /**
     * enum 定义的枚举类默认继承了 java.lang.Enum 类，并实现了 java.lang.Seriablizable 和 java.lang.Comparable 两个接口。
     *  values(), ordinal() 和 valueOf() 方法位于 java.lang.Enum 类中：
     *      values() 返回枚举类中所有的值。
     *      ordinal()方法可以找到每个枚举常量的索引，就像数组索引一样。
     *      valueOf()方法返回指定字符串值的枚举常量。
     * 传入值查询枚举，就是通过values()方法，返回所以枚举，再遍历全部枚举，只要传入的参数值 跟当前枚举的值跟相同，就返回当前枚举；
     */
    public static Boolean judge(String userRole,Integer userRoleCode){
        for (Role role: Role.values()
             ) {
//            拥有该接口的权限 并且 登陆用户的角色符合所需角色
            if(Objects.equals(role.getRoleName(), userRole) && Objects.equals(role.getRoleCode(), userRoleCode)){
                return true;
            }
        }
        return false;
    }
}
