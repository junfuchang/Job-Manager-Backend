package com.job.modules.Major.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.Major;
import com.job.mapper.MajorMapper;
import com.job.modules.Major.dto.MajorDto;
import com.job.modules.Major.service.MajorService;
import com.job.modules.Major.vo.CollageAndMajorVo;
import com.job.modules.Major.vo.SqlItemVo;
import com.job.modules.Major.vo.MajorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
    implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public Result getMajors() {
        List<SqlItemVo> allMajors = majorMapper.getAllMajors();
        List<Object> result = new ArrayList<>();

        HashMap<Integer, CollageAndMajorVo> resMap = new HashMap<>();
        for(SqlItemVo res : allMajors){
//            如果不存在
            if(!resMap.containsKey(res.getCollegeId())){
                List<MajorVo> majorVos = new ArrayList<>();
//                设置专业信息
                MajorVo majorVo = new MajorVo();
                majorVo.setValue(res.getMajorId());
                majorVo.setLabel(res.getMajorName());
                majorVos.add(majorVo);
//                设置专业信息
                CollageAndMajorVo collageAndMajorVo = new CollageAndMajorVo();
                collageAndMajorVo.setValue(res.getCollegeId());
                collageAndMajorVo.setLabel(res.getCollegeName());
                collageAndMajorVo.setChildren(majorVos);
//                将结果存入resmap
                resMap.put(res.getCollegeId(),collageAndMajorVo);
            }
            else {
                MajorVo majorVo = new MajorVo();
                majorVo.setValue(res.getMajorId());
                majorVo.setLabel(res.getMajorName());
                resMap.get(res.getCollegeId()).getChildren().add(majorVo);
            }
        }
        resMap.forEach((key, value) -> {
            result.add(value);
        });

        return new Result(Code.SUCCESS,result,"级联选择：学院-专业");
    }

    @Override
    public Result selectMajorList(MajorDto majorDto) {
        if(majorDto.getCollegeId() == null){
            throw new BusinessException(Code.BUSINESS_ERR , "collegeId不能为空");
        }
        LambdaQueryWrapper<Major> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Major::getCollegeId,majorDto.getCollegeId());
        return new Result(majorMapper.selectPage(new Page<>(1, 200), queryWrapper));
    }

    @Override
    public Result updateMajor(MajorDto majorDto) {
        if(majorDto.getMajorId() == null){
            throw new BusinessException(Code.BUSINESS_ERR , "majorId不能为空");
        }
        Major major = majorMapper.selectById(majorDto.getMajorId());
        major.setName(majorDto.getName());
        return new Result(majorMapper.updateById(major));
    }

    @Override
    public Result insertMajor(MajorDto majorDto) {
        if(majorDto.getCollegeId() == null){
            throw new BusinessException(Code.BUSINESS_ERR , "collegeId不能为空");
        }
        Major major = new Major();
        major.setCollegeId(majorDto.getCollegeId());
        major.setName(majorDto.getName());
        return new Result(majorMapper.insert(major));
    }

    @Override
    public Result deleteMajor(MajorDto majorDto) {
        if(majorDto.getMajorId() == null){
            throw new BusinessException(Code.BUSINESS_ERR , "majorId不能为空");
        }
        return new Result(majorMapper.deleteById(majorDto.getMajorId()));
    }
}




