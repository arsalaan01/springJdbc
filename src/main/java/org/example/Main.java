package org.example;

import org.example.entities.Student;
import org.example.jdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("db-config.xml");
        StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);

//        Student student = new Student();
//        student.setSid(3144);
//        student.setName("Jack");
//        student.setCity("Cincinati");

//        System.out.println("Number of records inserted "+ studentDao.insert(student));
//        student.setSid(1198);
//        System.out.println("Number of records inserted "+ studentDao.update(student));

//        System.out.println("No. of deleted rows are :" + studentDao.delete(1198));

//          System.out.println(studentDao.getStudent(2312));

        List<Student> students = studentDao.getAllStudents();
        for(Student s: students) {
            System.out.println(s);
        }

    }
}