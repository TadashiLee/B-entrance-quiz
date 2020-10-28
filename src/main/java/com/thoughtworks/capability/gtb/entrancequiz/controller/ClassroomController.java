package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(classroomService.getAllStudents());
    }

    // TODO GTB-知识点: - 违反Restful实践, url不合理
    @PostMapping("/student")
    // TODO GTB-知识点: - 没有使用泛型
    // TODO GTB-知识点: - 违反Restful实践, Post请求成功后应该返回201
    public ResponseEntity addStudent(@RequestBody Student student){
        classroomService.addStudent(student);
        return ResponseEntity.ok().build();
    }
}
