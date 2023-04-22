package com.job.modules.Amount.controller;

import com.job.common.domain.Result;
import com.job.modules.Amount.dto.AmountListDto;
import com.job.modules.Amount.dto.PasswordDto;
import com.job.modules.Amount.service.AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/amount")
public class AmountController {
    @Autowired
    AmountService amountService;

    @PostMapping("/selectAmountList")
    @PostAuthorize("@Permission.access('ADMIN')")
    public Result selectAmountList(@RequestBody AmountListDto amountListDto){
        return amountService.selectAmountList(amountListDto);
    }

    @PostMapping("/deleteAmountById")
    @PostAuthorize("@Permission.access('ADMIN')")
    public Result deleteAmountById(@RequestBody AmountListDto amountListDto){
        return amountService.deleteAmountById(amountListDto);
    }

    @PostMapping("/updateAmount")
    @PostAuthorize("@Permission.access('ADMIN STUDENT COMPANY')")
    public Result updateAmount(@RequestBody AmountListDto amountListDto){
        return amountService.updateAmount(amountListDto);
    }

    /**
     * 管理员账户的新增（amount） 与 学生、企业的新增（login） 放在了不同接口位置
     * 因为他们间的处理有很大不同
     */
    @PostMapping("/insertAmount")
    @PostAuthorize("@Permission.access('ADMIN')")
    public Result insertAmount(@RequestBody AmountListDto amountListDto) throws InvocationTargetException, IllegalAccessException {
        return amountService.insertAmount(amountListDto);
    }

    /**
     * 修改密码
     */
    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestBody PasswordDto passwordDto) {
        return amountService.updatePassword(passwordDto);
    }
}
