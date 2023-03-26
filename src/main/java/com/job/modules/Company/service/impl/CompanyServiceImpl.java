package com.job.modules.Company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.Company;
import com.job.entities.Student;
import com.job.modules.Company.dto.CompanyListDto;
import com.job.modules.Company.service.CompanyService;
import com.job.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【company(企业表)】的数据库操作Service实现
* @createDate 2023-02-26 23:04:27
*/
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company>
    implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public Result selectCompanyList(CompanyListDto companyListDto) {
        Integer current = companyListDto.getCurrent();
        Integer pageSize = companyListDto.getPageSize();
        if(current == null || pageSize == null){
            return new Result(200,companyMapper.selectList(null),"无分页参数，返回全部数据");
        } else{
            LambdaQueryWrapper<Company> queryWrapper = new LambdaQueryWrapper<>();
            if(companyListDto.getCode() != null ){
                queryWrapper.eq(Company::getCode,companyListDto.getCode());
            }
            if(companyListDto.getName() != null ){
                queryWrapper.like(Company::getName,companyListDto.getName());
            }
            return new Result(companyMapper.selectPage(new Page<>(current,pageSize),queryWrapper));
        }
    }

    @Override
    public Result updateCompany(Company company) {
        if(company.getCompanyId() != null){
            companyMapper.updateById(company);
        }else if(company.getAmountId() != null){
            LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Company::getAmountId,company.getAmountId());
            Company one = companyMapper.selectOne(wrapper);
            if(one == null){
                throw new BusinessException(Code.BUSINESS_ERR,"不存在该企业，请退出登陆后重试");
            }
            companyMapper.updateById(one);
        }
        return new Result(true);
    }
}




