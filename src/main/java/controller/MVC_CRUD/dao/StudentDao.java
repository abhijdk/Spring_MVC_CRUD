package controller.MVC_CRUD.dao;

import controller.MVC_CRUD.pojo.Student;

import java.util.List;

public interface StudentDao {

    /* Get all student details
     * @Param no , no is the number based on that I am going to done pagenation "
     * @return List<Student> */
    List<Student> showAllStudent(int no);

    /* Get Single student details
     * @Param id , id is the number based on that I am going to search that particular record from my DataBase "
     * @return  Student */
    Student getSingleStudent(int id);

    /* Here I am going to add new student in Database
     * Also This method is used for at the time of doing any update in database
     * @Param student , student is usec only at the time of doing any updataion, It show the previous record in add page, By which we want to update  "
     *          Otherwise in 'new add' operation this param is not use */
    void studentADD(Student student);

    /* This method is used for at the time of doing any update in database
     * @Param student , student is usec only at the time of doing any updataion, It show the previous record in add page, By which we want to update  " */
    void update(Student student);

    /* Here I am going to delete a specific record from Database
     * @Param id , id is the number based on that I am going to search that particular record from my DataBase which i want to delete */
    void delete(int id);

    /* Get how many row avalable in my DataBase
     * By using this total number of row , I am going to create those many pagenation button=[(total no of row)/(how many record show in one page)+1]
     * @return List<Student> */
    public List<Student> countROw();
}
