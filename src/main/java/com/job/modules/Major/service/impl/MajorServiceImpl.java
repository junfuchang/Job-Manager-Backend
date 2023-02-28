package com.job.modules.Major.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.entities.Major;
import com.job.mapper.MajorMapper;
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
}




