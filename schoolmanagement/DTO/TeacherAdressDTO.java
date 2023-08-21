package com.example.schoolmanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherAdressDTO {

    private Integer teacher_id;

    private String area;

    private String street;

    private Integer buildingNumber;
}
