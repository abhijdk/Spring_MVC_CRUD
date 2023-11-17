package controller.MVC_CRUD.service.impl;

import controller.MVC_CRUD.dao.StudentDao;
import controller.MVC_CRUD.pojo.Student;
import controller.MVC_CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> getAllStudent(int no) {
        return studentDao.showAllStudent(no);
    }

    @Override
    public Student getSingleStudent(int id) {
       return studentDao.getSingleStudent(id);
    }

    @Override
    public void studentADD(Student student) {
        studentDao.studentADD(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public List<Student> countROw() {
        return studentDao.countROw();
    }

//    public StudentDao getStudentDao() {
//        return studentDao;
//    }
//
//    public void setStudentDao(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }

    public int size(int size){
        int i=size%5;
        if(i==0){
            return size/=5;
        }else{
            size=(size/5)+1;
            return size;
        }

    }
}
