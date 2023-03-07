package com.job.modules.Company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.Company;
import com.job.modules.Company.service.CompanyService;
import com.job.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【company(企业表)】的数据库操作Service实现
* @createDate 2023-02-26 23:04:27
*/
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company>
    implements CompanyService {

}




