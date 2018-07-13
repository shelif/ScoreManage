package com.example.demo.dao;

import com.example.demo.entity.StExample;
import com.example.demo.entity.StKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface StDao {
    long countByExample(StExample example);

    int deleteByExample(StExample example);

    int deleteByPrimaryKey(StKey key);

    int insert(StKey record);

    int insertSelective(StKey record);

    List<StKey> selectByExample(StExample example);

    int updateByExampleSelective(@Param("record") StKey record, @Param("example") StExample example);

    int updateByExample(@Param("record") StKey record, @Param("example") StExample example);
}