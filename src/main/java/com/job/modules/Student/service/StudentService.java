package com.job.modules.Student.service;

import com.job.common.domain.Result;
import com.job.entities.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.job.modules.Student.dto.StudentListDto;

/**
* @author cjf
* @description 针对表【student】的数据库操作Service
* @createDate 2023-02-26 23:04:42
*/
public interface StudentService extends IService<Student> {
    Result selectAmountList(StudentListDto studentListDto);

    Result updateStudent(Student student);
}
