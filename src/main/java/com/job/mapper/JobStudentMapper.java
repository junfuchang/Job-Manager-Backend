package com.job.mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.job.entities.JobStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.job.modules.JobStudent.vo.JobStudentListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.HashMap;

/**
* @author cjf
* @description 针对表【job_resume(岗位-简历 关联表)】的数据库操作Mapper
* @createDate 2023-02-26 23:04:32
* @Entity com.job.entities.JobResume
*/
@Mapper
public interface JobStudentMapper extends BaseMapper<JobStudent> {
    Page<JobStudentListVo> selectJobStudentList(Page<JobStudentListVo> page, @Param("map") HashMap map);
}




