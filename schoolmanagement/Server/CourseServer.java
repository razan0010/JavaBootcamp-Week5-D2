package com.example.schoolmanagement.Server;

import com.example.schoolmanagement.API.ApiException;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServer {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
       Course course1 = courseRepository.findCourseById(id);

        if (course1 == null){
            throw new ApiException("ID not found");
        }

        course1.setName(course.getName());

        courseRepository.save(course1);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);

        if (course == null){
            throw new ApiException("ID not found");
        }

        courseRepository.delete(course);
    }

    public void assignCourseToTeacher(Integer teacher_id, Integer course_id){

        Teacher teacher= teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);

        if (course == null || teacher == null){

            throw new ApiException("can't assign");
        }

        course.setTeacher(teacher);

        courseRepository.save(course);
    }

//    Create endpoint that take course id and return the teacher name for that class

    public String getTeacherByCourse(Integer id){
        Course course = courseRepository.findCourseById(id);

        if (course == null){
            throw new ApiException("Course not found");
        }
        String teacherName = course.getTeacher().getName();

        if (teacherName == null){
            throw new ApiException("Course not assign to teacher");
        }
        return teacherName;
    }

}
