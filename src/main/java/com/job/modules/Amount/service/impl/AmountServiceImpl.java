package com.job.modules.Amount.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.Amount;
import com.job.modules.Amount.service.AmountService;
import com.job.mapper.AmountMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author cjf
* @description 针对表【amount】的数据库操作Service实现
* @createDate 2023-02-26 23:04:21
*/
@Service
public class AmountServiceImpl extends ServiceImpl<AmountMapper, Amount>
    implements AmountService {

    @Autowired
    private AmountMapper amountMapper;

    @Override
    public Page<Amount> alist() {
        Page<Amount> amountPage = new Page<>(1,2);
        return  amountMapper.selectPage(amountPage,null);


//        return amountMapper.getById();
    }
}




