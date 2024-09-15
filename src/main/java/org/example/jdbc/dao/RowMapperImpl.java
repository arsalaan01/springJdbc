package org.example.jdbc.dao;

import org.example.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
       Student student = new Student();
       student.setSid(rs.getInt(1));
       student.setName(rs.getString(2));
       student.setCity(rs.getString(3));
       return student;
    }
}
