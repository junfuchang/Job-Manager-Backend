package com.job.modules.Major.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.job.common.domain.Result;
import com.job.entities.Major;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cjf
 * @description 针对表【major(专业表)】的数据库操作Service
 * @createDate 2023-02-26 23:04:35
 */
@Transactional
public interface MajorService extends IService<Major> {
    Result getMajors();

}
