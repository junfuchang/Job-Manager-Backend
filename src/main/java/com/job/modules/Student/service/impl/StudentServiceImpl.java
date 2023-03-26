package com.job.modules.Student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.entities.Student;
import com.job.modules.Student.dto.StudentListDto;
import com.job.modules.Student.service.StudentService;
import com.job.mapper.StudentMapper;
import com.job.modules.Student.vo.StudentListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
            HashMap<String, Object> map = new HashMap<>();
            if(studentListDto.getStudentId() != null ){
                map.put("studentId",studentListDto.getStudentId());
            }
            if(studentListDto.getName() != null ){
                map.put("name",studentListDto.getName());
            }
            if(studentListDto.getMajorId() != null && studentListDto.getMajorId() != -1){
                map.put("majorId",studentListDto.getMajorId());
            }
            if(studentListDto.getGraduateFlag() != null && studentListDto.getGraduateFlag() != -1){
                map.put("graduateFlag",studentListDto.getGraduateFlag());
            }
            Page<StudentListVo> data = studentMapper.selectStudentList(new Page<>(current, pageSize),map);
            return new Result(data);
        }
    }

    @Override
    public Result updateStudent(Student student) {
        if(student.getStudentId() != null){
            studentMapper.updateById(student);
        }else if(student.getAmountId() != null){
            LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Student::getAmountId,student.getAmountId());
            Student one = studentMapper.selectOne(wrapper);
            if(one == null){
                throw new BusinessException(Code.BUSINESS_ERR,"不存在该用户，请退出登陆后重试");
            }
            one.setResume(student.getResume());
            studentMapper.updateById(one);
        }
        return new Result(true);
    }
}




