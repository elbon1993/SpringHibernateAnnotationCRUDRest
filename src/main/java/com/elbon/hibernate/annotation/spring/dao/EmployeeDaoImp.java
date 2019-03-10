package com.elbon.hibernate.annotation.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elbon.hibernate.annotation.spring.model.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Employee employee) {
      sessionFactory.getCurrentSession().save(employee);
      return employee.getId();
   }

   @Override
   public Employee get(long id) {
      return sessionFactory.getCurrentSession().get(Employee.class, id);
   }

   @Override
   public List<Employee> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
      Root<Employee> root = cq.from(Employee.class);
      cq.select(root);
      Query<Employee> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Employee employee) {
      Session session = sessionFactory.getCurrentSession();
      Employee employee2 = session.byId(Employee.class).load(id);
      employee2.setName(employee.getName());
      employee2.setDept(employee.getDept());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Employee employee = session.byId(Employee.class).load(id);
      session.delete(employee);
   }

}
