package com.job.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.entities.Student;
import com.job.modules.service.StudentService;
import com.job.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author cjf
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-02-26 23:04:42
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

}




