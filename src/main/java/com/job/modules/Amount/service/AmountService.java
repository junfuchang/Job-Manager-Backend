package com.job.modules.Amount.service;

import com.job.common.domain.Result;
import com.job.entities.Amount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.job.modules.Amount.dto.AmountListDto;

import java.lang.reflect.InvocationTargetException;

/**
* @author cjf
* @description 针对表【amount】的数据库操作Service
* @createDate 2023-02-26 23:04:21
*/
public interface AmountService extends IService<Amount> {
    Result selectAmountList(AmountListDto amountListDto);
    Result insertAmount(AmountListDto amountListDto) throws InvocationTargetException, IllegalAccessException;
    Result deleteAmountById(AmountListDto amountListDto);
    Result updateAmount(AmountListDto amountListDto);
}
