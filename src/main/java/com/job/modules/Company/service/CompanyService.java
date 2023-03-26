package com.job.modules.Company.service;

import com.job.common.domain.Result;
import com.job.entities.Company;
import com.baomidou.mybatisplus.extension.service.IService;
import com.job.modules.Company.dto.CompanyListDto;

/**
* @author cjf
* @description 针对表【company(企业表)】的数据库操作Service
* @createDate 2023-02-26 23:04:27
*/
public interface CompanyService extends IService<Company> {
    Result selectCompanyList(CompanyListDto companyListDto);

    Result updateCompany(Company company);
}
