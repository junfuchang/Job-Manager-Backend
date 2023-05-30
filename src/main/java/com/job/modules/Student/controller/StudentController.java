package com.job.modules.Student.controller;


import com.job.common.domain.Result;
import com.job.entities.Student;
import com.job.modules.Student.dto.StudentListDto;
import com.job.modules.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/selectStudentList")
     public Result selectStudentList(@RequestBody StudentListDto studentListDto){
        return studentService.selectAmountList(studentListDto);
    }

    @PostMapping("/updateStudent")
    public Result updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
}
