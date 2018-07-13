package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.TeacherExample;
import com.jayway.jsonpath.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherDaoTest {
    @Autowired
    @Qualifier(value = "teacherDao")
    private TeacherDao teacherDao;

    @Test
    public void countByExample() throws Exception {
    }

    @Test
    public void deleteByExample() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        Teacher teacher=new Teacher();
        teacher.settId("13");
        teacher.settName("刘骥");
        teacher.settPassword("qwe");
        teacher.settUsername("liu");
        teacherDao.insert(teacher);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByExample() throws Exception {
        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria criteria= teacherExample.createCriteria();
        criteria.andTIdEqualTo("13");
        List<Teacher> teacherList=teacherDao.selectByExample(teacherExample);
        System.out.println(teacherList);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Teacher teacher=teacherDao.selectByPrimaryKey("13");
        System.out.println(teacher);
    }

    @Test
    public void updateByExampleSelective() throws Exception {
    }

    @Test
    public void updateByExample() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}