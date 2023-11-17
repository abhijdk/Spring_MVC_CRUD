package controller.MVC_CRUD.dao.impl;

import controller.MVC_CRUD.dao.StudentDao;
import controller.MVC_CRUD.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> showAllStudent(int no) {
        String query = "select * from student limit 5 offset " + no;
        List<Student> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<Student>(Student.class));
        return list;
    }

    @Override
    public Student getSingleStudent(int id) {
        String query = "select * from student where id=?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class), id);
    }

    @Override
    public void studentADD(Student student) {
        String query = "insert into  student (name,mobile,address) values (?,?,?)";
        jdbcTemplate.update(query, student.getName(), student.getMobile(), student.getAddress());
    }

    @Override
    public void update(Student student) {
        String query = "UPDATE student SET name=?, mobile=?, address=? WHERE id=?";
        jdbcTemplate.update(query, student.getName(), student.getMobile(), student.getAddress(), student.getId());
    }

    @Override
    public void delete(int id) {
        String query = "delete from student where id=?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<Student> countROw() {
        String query = "select * from student";
        List<Student> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<Student>(Student.class));
        return list;
    }


//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
}
