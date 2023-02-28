package com.job.mapper;

import com.job.entities.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cjf
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-02-26 23:04:42
* @Entity com.job.entities.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




