package com.example.demo.dao;

import com.example.demo.entity.Area;
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
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;


    @Test
    public void queryArea() throws Exception {
        List<Area> arealist=areaDao.queryArea();
        System.out.println(arealist);
    }

    @Test
    public void queryAreaById() throws Exception {

    }

    @Test
    public void insertArea() throws Exception {
    }

    @Test
    public void updateArea() throws Exception {
    }

    @Test
    public void deleteArea() throws Exception {
    }

}