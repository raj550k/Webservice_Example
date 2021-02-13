package com.example.demo.controller;

import com.example.demo.repo.Employee;
import com.example.demo.repo.EmployeeRepositry;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private EmployeeRepositry repositry;
     EmployeeController(EmployeeRepositry repositry){
         this.repositry = repositry;
     }

     @GetMapping("getEmployees")
    List<Employee> all(){
        return  repositry.findAll();
    }

    @GetMapping("getDetails/{id}")
    Optional<Employee> getEmployeeDetails(@PathVariable Long id){

        return  repositry.findById(id);
    }

    @PostMapping("/save")
    Employee saveDetails(@RequestBody Employee e){
         return repositry.save(e);
    }

    @PutMapping("/update/{id}")
    Optional<Employee> updateEmployeeDetails(@RequestBody Employee e, @PathVariable Long id){

         return repositry.findById(id).map( employee -> {employee.setName(e.getName());
           return repositry.save(employee);
                 }
         );

    }

    @DeleteMapping("delete/{id}")
    void deleteEmployee(@PathVariable Long id){
         repositry.deleteById(id);
    }

}
