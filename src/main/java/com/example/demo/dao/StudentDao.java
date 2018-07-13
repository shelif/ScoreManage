package com.example.demo.dao;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface StudentDao
{
    List<Student> queryStudent();
    Student queryStudentById(String sId);
    List<Student> queryStudentByClass(String sClass);
    List<Student> queryStudentByName(String sName);
    List<Student> queryStudentByMajor(String sMajor);
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(String sId);
}
