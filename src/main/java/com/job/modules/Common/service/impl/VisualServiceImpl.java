package com.job.modules.Common.service.impl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.mapper.CommonMapper;
import com.job.modules.Common.Vo.CommonVo;
import com.job.modules.Common.Vo.DetailNum;
import com.job.modules.Common.Vo.RateByYear;
import com.job.modules.Common.Vo.VisualVo;
import com.job.modules.Common.dto.LocationItem;
import com.job.modules.Common.dto.OverviewDto;
import com.job.modules.Common.service.VisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Array;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
public class VisualServiceImpl implements VisualService {
    @Autowired
    CommonMapper commonMapper;

    @Override
    public Result getOverviewInfo() {
        VisualVo visualVo = new VisualVo();
        visualVo.setDirection(commonMapper.selectAllDirection());
        visualVo.setDegree(commonMapper.selectAllDegree());
        visualVo.setSalary(commonMapper.selectAllSalary());

        // 遍历就业类型，获取每种类型的男女比例
        Integer[] directionList = {0,1,2};
        HashMap<Integer, List> hashMap = new HashMap<>();
        for (Integer i : directionList) {
            List<CommonVo> list = commonMapper.selectAllGender(i);
            hashMap.put(i,list);
        }
        visualVo.setGender(hashMap);
        return new Result(visualVo);
    }

    @Override
    public Result getOverviewMap(OverviewDto overviewDto) {
        List<LocationItem> locationList = overviewDto.getLocationList();
        if(locationList == null){
            throw new BusinessException(Code.BUSINESS_ERR,"缺少位置信息参数");
        }
        HashMap<String,Number> hashMap = new HashMap<>();
        for (LocationItem item : locationList) {
            hashMap.put(item.getName(),commonMapper.selectOverviewMap(item.getCode()));
        }
        return new Result(hashMap);
    }

    @Override
    public Result getOverviewDetailRateByYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        HashMap<String, RateByYear> hashMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            RateByYear list = commonMapper.selectRateByYear(year-i);
            hashMap.put((year-i)+"年",list);
        }
        RateByYear nullData = commonMapper.selectRateByYear(null);
        hashMap.put("无年份",nullData);
        return new Result(hashMap);
    }

    @Override
    public Result getOverviewDetailNum() {
        DetailNum detail = commonMapper.selectOverviewDetailNum();
        return new Result(detail);
    }
}
