package com.elbon.hibernate.annotation.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elbon.hibernate.annotation.spring.dao.EmployeeDao;
import com.elbon.hibernate.annotation.spring.model.Employee;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImp implements EmployeeService {

   @Autowired
   private EmployeeDao employeeDao;

   @Transactional
   @Override
   public long save(Employee employee) {
      return employeeDao.save(employee);
   }

   @Override
   public Employee get(long id) {
      return employeeDao.get(id);
   }

   @Override
   public List<Employee> list() {
      return employeeDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Employee employee) {
      employeeDao.update(id, employee);
   }

   @Transactional
   @Override
   public void delete(long id) {
      employeeDao.delete(id);
   }

}
