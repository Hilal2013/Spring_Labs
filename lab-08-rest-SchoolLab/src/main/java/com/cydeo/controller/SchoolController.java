package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }
    @GetMapping("/teachers")
    public List<TeacherDTO> getTeachers() {

        return teacherService.findAll();
    }
// "success": true,
//    "message": "Students are retrieved successfully",
//    "code": 200,
//    "data": [
//        {
//
    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getStudents() {

        return ResponseEntity.ok(new ResponseWrapper("Students are retrieved successfully", studentService.findAll()));

    }
    /*
               create a parents endpoint where status code is 202
               additional header has "Parent" , "Returned"
               and following json body structure
              "Parents are successfully retrieved." message
               code:202
               success:true
               and student data
            */
    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {
        ResponseWrapper responseWrapper =
                new ResponseWrapper(true, "Parents are retrieved successfully",
                        HttpStatus.ACCEPTED.value(), parentService.findAll());

        return ResponseEntity.status(HttpStatus.ACCEPTED).header("Parent", "Returned").body(responseWrapper);

    }
    /*
            create an endpoint for individual address information
            /address/1
            return status code 200
            "address .. is successfully retrieved" message
            and address information
         */
    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> retrieveAddress(@PathVariable("id") Long id) throws  Exception{

        return ResponseEntity.ok(new ResponseWrapper("Address is retrieved successfully", addressService.findById(id)));


    }
}
