package com.chinabear.jdbc.dao;

import com.chinabear.jdbc.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bear on 2020/7/6
 */
public interface StudentDao {
    int insertStudent(Student student) throws ClassNotFoundException, SQLException;
    int updateStudent(Student student) throws ClassNotFoundException, SQLException;
    Student getStudentOne(int id) throws ClassNotFoundException, SQLException;
    List<Student> getStudentList() throws ClassNotFoundException, SQLException;

}
