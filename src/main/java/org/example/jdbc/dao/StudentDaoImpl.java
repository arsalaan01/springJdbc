package org.example.jdbc.dao;

import org.example.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        // Insert query
        String query = "insert into T_STUDENT (S_ID,NAME,CITY) VALUES (?,?,?)";
        int result = jdbcTemplate.update(query,student.getSid(),student.getName(),student.getCity());
        return result;
    }

    @Override
    public int update(Student student) {
        // Update query
        String query = "update T_STUDENT set name=?, city=? where s_id=?";
        int result = jdbcTemplate.update(query,student.getName(),student.getCity(),student.getSid());
        return result;
    }

    @Override
    public int delete(int id) {
        // delete query
        String query = "delete from T_STUDENT where s_id=?";
        int result = jdbcTemplate.update(query,id);
        return result;
    }

    @Override
    public Student getStudent(int id) {
        // select query with where clause
        String query = "select * from T_STUDENT where s_id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = jdbcTemplate.queryForObject(query,rowMapper,id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from T_STUDENT";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> students = jdbcTemplate.query(query,rowMapper);
        return students;
    }


}
