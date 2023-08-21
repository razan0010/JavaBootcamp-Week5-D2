package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Server.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher/")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted");
    }

    @GetMapping("get-teacher-by-id/{id}")
    public ResponseEntity teacherDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.teacherDetails(id));
    }
}
