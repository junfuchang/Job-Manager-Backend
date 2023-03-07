package com.job.modules.Student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.entities.Student;
import com.job.modules.Student.dto.StudentListDto;
import com.job.modules.Student.service.StudentService;
import com.job.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
* @author cjf
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-02-26 23:04:42
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Result selectAmountList(StudentListDto studentListDto) {
        Integer current = studentListDto.getCurrent();
        Integer pageSize = studentListDto.getPageSize();
        if(current == null || pageSize == null){
            return new Result(200,studentMapper.selectList(null),"无分页参数，返回全部数据");
        }{
            LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
            if(studentListDto.getStudentId() != null ){
                queryWrapper.eq(Student::getStudentId,studentListDto.getStudentId());
            }
            if(studentListDto.getName() != null ){
                queryWrapper.like(Student::getName,studentListDto.getName());
            }
            if(studentListDto.getMajorId() != null && studentListDto.getMajorId() != -1){
//                queryWrapper.eq(Student::get,studentListDto.getRoleId());
            }
            if(studentListDto.getBirthday() != null ){
                Date birthday = studentListDto.getBirthday();  //  Tue Mar 07 17:34:23 CST 2023
//                queryWrapper.between(Student::getBirthday, DateUtils.getStartTime(createTime),DateUtils.getEndTime(createTime));
            }

            Page<Student> data = studentMapper.selectPage(new Page<>(studentListDto.getCurrent(), pageSize), queryWrapper);
            return new Result(data);
        }
    }
}




