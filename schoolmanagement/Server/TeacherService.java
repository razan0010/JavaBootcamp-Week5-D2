package com.example.schoolmanagement.Server;

import com.example.schoolmanagement.API.ApiException;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id , Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);

        if (teacher1 == null){
            throw new ApiException("Id not found");
        }

        teacher1.setName(teacher.getName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setAge(teacher.getAge());
        teacher1.setSalary(teacher.getSalary());

        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null){
            throw new ApiException("Id not found");
        }

        teacherRepository.delete(teacher);
    }


//    Create endpoint that takes teacher id and return All teacher details
    public Teacher teacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null){
            throw new ApiException("Teacher not found");
        }

        if(teacher.getAddress() == null){
            throw new ApiException("Missing data! The teacher "+ teacher.getName() +" has no address");
        }

        if (teacher.getCourses() == null){
            throw new ApiException("Missing data! The teacher "+ teacher.getName() +" has no courses");
        }

        return teacher.getAddress().getTeacher().getAddress().getTeacher();
    }
}
