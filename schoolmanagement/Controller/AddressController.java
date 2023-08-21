package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.DTO.TeacherAdressDTO;
import com.example.schoolmanagement.Server.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address/")
public class AddressController {

    public final AddressService addressService;

    @GetMapping("get")
    public ResponseEntity getAllAddresses(){
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }

    @PostMapping("add")
    public ResponseEntity addAddress(@RequestBody @Valid TeacherAdressDTO teacherAdressDTO){
        addressService.addAddress(teacherAdressDTO);
        return ResponseEntity.status(200).body("Teacher address added");
    }

    @PutMapping("update")
    public ResponseEntity updateAddress(@RequestBody @Valid TeacherAdressDTO teacherAdressDTO){
        addressService.updateAddress(teacherAdressDTO);
        return ResponseEntity.status(200).body("Teacher address updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Teacher address deleted");
    }

}
