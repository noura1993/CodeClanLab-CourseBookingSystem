package com.codeclan.example.codeclanbookingsystem.Controllers;

import com.codeclan.example.codeclanbookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity get(
        @RequestParam(required = false, name = "course") String courseName,
        @RequestParam(required = false, name = "town") String town,
        @RequestParam(required = false, name = "age") Integer age
    ) {
        if(town != null && courseName != null && age != null) {
            return new ResponseEntity<>(customerRepository.findCustomerByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, courseName), HttpStatus.OK);
        }
        if(town != null && courseName != null ) {
            return new ResponseEntity<>(customerRepository.findCustomerByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, courseName), HttpStatus.OK);
        }
        if(courseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}

