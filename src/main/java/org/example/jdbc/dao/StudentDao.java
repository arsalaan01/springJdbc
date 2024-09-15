package org.example.jdbc.dao;

import org.example.entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);

    public int update(Student student);

    public int delete(int id);

    public Student getStudent(int id);

    public List<Student> getAllStudents();
}
