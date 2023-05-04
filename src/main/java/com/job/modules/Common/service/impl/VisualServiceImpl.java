package com.job.modules.Common.service.impl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.mapper.CommonMapper;
import com.job.modules.Common.Vo.CommonVo;
import com.job.modules.Common.Vo.VisualVo;
import com.job.modules.Common.dto.LocationItem;
import com.job.modules.Common.dto.OverviewDto;
import com.job.modules.Common.service.VisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
