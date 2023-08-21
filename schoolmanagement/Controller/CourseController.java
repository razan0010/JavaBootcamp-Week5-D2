package com.example.schoolmanagement.Controller;


import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Server.CourseServer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course/")
public class CourseController {

    private final CourseServer courseServer;


    @GetMapping("get")
    public ResponseEntity getAllCourses(){
        return ResponseEntity.status(200).body(courseServer.getAllCourses());
    }


    @PostMapping("add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseServer.addCourse(course);
        return ResponseEntity.status(200).body("Course added");
    }


    @PutMapping("update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseServer.updateCourse(id, course);
        return ResponseEntity.status(200).body("Course updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseServer.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted");
    }

    @GetMapping("{teacher_id}/assign/{course_id}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseServer.assignCourseToTeacher(teacher_id, course_id);
        return ResponseEntity.status(200).body("Course assigned to Teacher");
    }


    @GetMapping("getTeacherByCourse/{id}")
    public ResponseEntity getTeacherByCourse(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseServer.getTeacherByCourse(id));
    }


}
