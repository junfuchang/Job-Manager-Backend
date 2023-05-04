package com.job.modules.College.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.College;
import com.job.entities.Major;
import com.job.mapper.MajorMapper;
import com.job.modules.College.dto.CollegeDto;
import com.job.modules.College.service.CollegeService;
import com.job.mapper.CollegeMapper;
import com.job.modules.College.vo.CollegeVisualVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author cjf
* @description 针对表【college(学院表)】的数据库操作Service实现
* @createDate 2023-02-26 23:04:24
*/
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College>
    implements CollegeService{
    @Autowired
    CollegeMapper collegeMapper;
    @Autowired
    MajorMapper majorMapper;

    @Override
    public Result selectCollegeList() {
        Page<College> collegePage = new Page<>(1,200);
        return new Result(collegeMapper.selectPage(collegePage,null));
    }

    @Override
    public Result updateCollege(CollegeDto collegeDto) {
        if(collegeDto.getCollegeId() == null){
            throw new BusinessException(Code.BUSINESS_ERR , "collegeId不能为空");
        }
        College college = collegeMapper.selectById(collegeDto.getCollegeId());
        college.setName( collegeDto.getName());
        return new Result(collegeMapper.updateById(college));
    }

    @Override
    public Result insertCollege(CollegeDto collegeDto) {
        if(collegeDto.getName() != null){
            College college = new College();
            college.setName(collegeDto.getName());
            collegeMapper.insert(college);
        }else {
            throw new BusinessException(Code.BUSINESS_ERR , "不能输入空字符串");
        }
        return new Result(true);
    }

    @Override
    public Result deleteCollege(CollegeDto collegeDto) {
        if(collegeDto.getCollegeId() == null){
            throw new BusinessException(Code.BUSINESS_ERR , "collegeId不能为空");
        }
        LambdaQueryWrapper<Major> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Major::getCollegeId,collegeDto.getCollegeId());
        majorMapper.delete(queryWrapper);
        return new Result( collegeMapper.deleteById(collegeDto.getCollegeId()));
    }

    @Override
    public Result selectRateData() {
        System.out.println("......\n");
        List<CollegeVisualVo> rateData = collegeMapper.selectRateData();

        return new Result( rateData);
    }
}




