package com.job.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.College;
import com.job.modules.service.CollegeService;
import com.job.mapper.CollegeMapper;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【college(学院表)】的数据库操作Service实现
* @createDate 2023-02-26 23:04:24
*/
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College>
    implements CollegeService{

}




