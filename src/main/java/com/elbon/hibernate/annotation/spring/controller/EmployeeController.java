package com.elbon.hibernate.annotation.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elbon.hibernate.annotation.spring.model.AbstractResponse;
import com.elbon.hibernate.annotation.spring.model.Employee;
import com.elbon.hibernate.annotation.spring.service.EmployeeService;

@RestController
public class EmployeeController {

   @Autowired
   private EmployeeService employeeService;

   /*---Add new employee---*/
   @PostMapping("/employee")
   public ResponseEntity<?> save(@RequestBody Employee employee) {
      long id = employeeService.save(employee);
      return ResponseEntity.ok().body("New Employee has been saved with ID:" + id);
   }

   /*---Get a employee by id---*/
   @GetMapping("/employee/{id}")
   public AbstractResponse get(@PathVariable("id") long id) {
      Employee employee = employeeService.get(id);
      AbstractResponse response = new AbstractResponse();
      response.setData(employee);
      response.setMessage("success");
      response.setStatusCode(200);
      return response;
   }

   /*---get all employees---*/
   @GetMapping("/employee")
   public ResponseEntity<List<Employee>> list() {
      List<Employee> employees = employeeService.list();
      return ResponseEntity.ok().body(employees);
   }

   /*---Update a employee by id---*/
   @PutMapping("/employee/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Employee employee) {
      employeeService.update(id, employee);
      return ResponseEntity.ok().body("Employee has been updated successfully.");
   }

   /*---Delete a employee by id---*/
   @DeleteMapping("/employee/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      employeeService.delete(id);
      return ResponseEntity.ok().body("Employee has been deleted successfully.");
   }
}