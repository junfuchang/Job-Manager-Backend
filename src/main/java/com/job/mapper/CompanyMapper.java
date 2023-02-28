package com.job.mapper;

import com.job.entities.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cjf
* @description 针对表【company(企业表)】的数据库操作Mapper
* @createDate 2023-02-26 23:04:27
* @Entity com.job.entities.Company
*/
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {

}




