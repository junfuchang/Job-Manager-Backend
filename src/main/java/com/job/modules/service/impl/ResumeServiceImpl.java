package com.job.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.Resume;
import com.job.modules.service.ResumeService;
import com.job.mapper.ResumeMapper;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【resume】的数据库操作Service实现
* @createDate 2023-02-26 23:04:37
*/
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume>
    implements ResumeService {

}




