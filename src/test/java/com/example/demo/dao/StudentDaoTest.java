package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {
    @Autowired
    @Qualifier(value = "studentDao")
    private StudentDao studentDao;

    @Test
    public void queryStudent() throws Exception {
        List<Student> students=studentDao.queryStudent();
        System.out.println(students);
    }

    @Test
    public void queryStudentById() throws Exception {
        Student student=studentDao.queryStudentById("20154270");
        System.out.println(student);
    }

    @Test
    public void queryStudentByClass() throws Exception {
       // Student student=studentDao.queryStudentByClass("tire1");
        //System.out.println(student);
    }

    @Test
    public void queryStudentByName() throws Exception {
       //Student student=studentDao.queryStudentByName("陈雁彬");
        //System.out.println(student);
    }

    @Test
    public void insertStudent() throws Exception {
        Student student=new Student();
        student.setsId("20154272");
        student.setsClass("tire2");
        student.setsGpa(4);
        student.setsIQ((float)4.2);
        student.setsMajor("CS");
        student.setsName("廖雅樵");
        student.setsPassword("qwe");
        student.setsTotalScore(168);
        student.setsUsername("20154272");
        System.out.println("xixixix"+studentDao.insertStudent(student));
    }

    @Test
    public void updateStudent() throws Exception {
        Student student=new Student();
        student.setsId("20154270");
        student.setsIQ((float)5.52);
        studentDao.updateStudent(student);
    }

    @Test
    public void deleteStudent() throws Exception {
        studentDao.deleteStudent("20154272");
    }

}