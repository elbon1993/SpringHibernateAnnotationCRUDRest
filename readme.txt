
Database: MySQL

CREATE TABLE `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `DEPT` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)


Sample API's:

http://localhost:8080/SpringHibernateAnnotationCRUDRest/rest/employee - GET
http://localhost:8080/SpringHibernateAnnotationCRUDRest/rest/employee/111 - GET
http://localhost:8080/SpringHibernateAnnotationCRUDRest/rest/employee - POST
body - {"name": "ravi", "dept":"psycho"}
http://localhost:8080/SpringHibernateAnnotationCRUDRest/rest/employee/112 - PUT
body - {"name": "ravi", "dept":"psycho"}
http://localhost:8080/SpringHibernateAnnotationCRUDRest/rest/employee/112 - DELETE 


