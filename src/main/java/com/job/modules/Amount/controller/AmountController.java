package com.job.modules.Amount.controller;

import com.job.common.domain.Result;
import com.job.entities.Amount;
import com.job.mapper.AmountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/amount")
public class AmountController {

    @Autowired
    AmountMapper amountMapper;

    @PostMapping("/getAmountList")
    @PostAuthorize("@Permission.access('ADMIN')")
    public Result getAmountList(){

        return new Result(amountMapper.selectList(null));
    }



//    @Autowired
//    UserMapper userMapper;
//    @Autowired
//    UserServiceImpl userService;
//
//    @PostMapping("/save")
//    public Result addOne(@RequestBody HashMap<String,String> formData) {
//        User aUser = new User();
////        密码加密
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = bCryptPasswordEncoder.encode(formData.get("password"));
//        aUser.setPassword(encodedPassword);
//
//        aUser.setMajorId(Integer.valueOf(formData.get("majorId")));
//        aUser.setRole(Integer.valueOf(formData.get("role")));
//        aUser.setStudentNum(formData.get("studentNum"));
//        aUser.setUsername(formData.get("username"));
//        aUser.setAdmissionTime(DateUtils.getDateTime(formData.get("admissionTime")));
//        aUser.setCreateTime(new Date());
//
//        return new Result(userService.saveUser(aUser));
//    }
//
//    @PostMapping("/deleteById")
//    public Result deleteById(@RequestBody HashMap Body){
//        return new Result(userService.deleteUserById((Integer) Body.get("id")));
//    }
//
//    @PostMapping("/deleteBatch")
//    public Integer deleteBatch(List<Integer> idList){
//        Integer result =  userMapper.deleteBatchIds(idList);
//        return result;
//    }
//
//    @PostMapping("/update")
//    public Result updateUser(@RequestBody User Body){
//        return new Result(userService.updateUser(Body));
//    }
//
////    @ApiOperation("根据ID查询用户")
////    @ApiImplicitParams(@ApiImplicitParam(name = "id",dataType = "Integer",required = true,value = "传入用户ID"))
////    @PostMapping("/getById")
////    public Result getOne(@RequestBody Integer id){
////        return new Result(userService.getUserById(id));
////    }
//

}
