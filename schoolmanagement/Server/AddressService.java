package com.example.schoolmanagement.Server;

import com.example.schoolmanagement.API.ApiException;
import com.example.schoolmanagement.DTO.TeacherAdressDTO;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public void addAddress(TeacherAdressDTO teacherAdressDTO){
        Teacher teacher = teacherRepository.findTeacherById(teacherAdressDTO.getTeacher_id());

        if (teacher == null){
            throw new ApiException("Teacher not found");
        }

        Address address = new Address(null, teacherAdressDTO.getArea(), teacherAdressDTO.getStreet(), teacherAdressDTO.getBuildingNumber(), teacher);

        addressRepository.save(address);
    }

    public void updateAddress(TeacherAdressDTO teacherAdressDTO){
        Teacher teacher = teacherRepository.findTeacherById(teacherAdressDTO.getTeacher_id());

        if (teacher == null){
            throw new ApiException("Teacher not found");
        }

        Address address = teacher.getAddress();

        address.setArea(teacherAdressDTO.getArea());
        address.setStreet(teacherAdressDTO.getStreet());
        address.setBuildingNumber(teacherAdressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null){
            throw new ApiException("Teacher not found");
        }

        Address address = teacher.getAddress();

        if (address == null){
            throw new ApiException("Teacher has no address");
        }

        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }

//    public Teacher teacherDetails(Integer id){
//        Teacher teacher = teacherRepository.findTeacherById(id);
//
//        if (teacher == null){
//            throw new ApiException("Teacher not found");
//        }
//
//        if(teacher.getAddress() == null){
//            throw new ApiException("Missing data! The teacher "+ teacher.getName() +" has no address");
//        }
//
//        return teacher.getAddress().getTeacher();
//    }
}
