package com.example.demo.dao;

import com.example.demo.entity.Sc;
import com.example.demo.entity.ScExample;
import com.example.demo.entity.ScKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;



@Component
public interface ScDao {
    long countByExample(ScExample example);

    int deleteByExample(ScExample example);

    int deleteByPrimaryKey(ScKey key);
    @Cacheable(value="sc",keyGenerator = "KeyGenerator")
    int insert(Sc record);

    int insertSelective(Sc record);

    @Cacheable(value="sc", keyGenerator = "KeyGenerator")
    List<Sc> selectByExample(ScExample example);

    @Cacheable(value="sc", keyGenerator = "KeyGenerator")
    Sc selectByPrimaryKey(ScKey key);

    int updateByExampleSelective(@Param("record") Sc record, @Param("example") ScExample example);

    int updateByExample(@Param("record") Sc record, @Param("example") ScExample example);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);
}