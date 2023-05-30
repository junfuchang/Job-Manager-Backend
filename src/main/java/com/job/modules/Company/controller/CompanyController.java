package com.job.modules.Company.controller;

import com.job.common.domain.Result;
import com.job.entities.Company;
import com.job.entities.Student;
import com.job.modules.Company.dto.CompanyListDto;
import com.job.modules.Company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping("/selectCompanyList")
    public Result selectCompanyList(@RequestBody CompanyListDto companyListDto){
        return companyService.selectCompanyList(companyListDto);
    }

    @PostMapping("/updateCompany")
    public Result updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

}
