package com.example.demo.dao;

import com.example.demo.entity.Administor;
import com.example.demo.entity.AdministorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AdministorDao {
    long countByExample(AdministorExample example);

    int deleteByExample(AdministorExample example);

    int deleteByPrimaryKey(String aId);

    int insert(Administor record);

    int insertSelective(Administor record);

    List<Administor> selectByExample(AdministorExample example);

    Administor selectByPrimaryKey(String aId);

    int updateByExampleSelective(@Param("record") Administor record, @Param("example") AdministorExample example);

    int updateByExample(@Param("record") Administor record, @Param("example") AdministorExample example);

    int updateByPrimaryKeySelective(Administor record);

    int updateByPrimaryKey(Administor record);
}