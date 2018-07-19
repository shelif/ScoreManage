package com.example.demo.dao;

import com.example.demo.entity.TeachingClass;
import com.example.demo.entity.TeachingClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public interface TeachingClassDao {
    long countByExample(TeachingClassExample example);

    int deleteByExample(TeachingClassExample example);

    int deleteByPrimaryKey(String tcId);

    int insert(TeachingClass record);

    int insertSelective(TeachingClass record);

    List<TeachingClass> selectByExample(TeachingClassExample example);
    @Cacheable(value="teachingClass", keyGenerator = "KeyGenerator")
    TeachingClass selectByPrimaryKey(String tcId);

    int updateByExampleSelective(@Param("record") TeachingClass record, @Param("example") TeachingClassExample example);

    int updateByExample(@Param("record") TeachingClass record, @Param("example") TeachingClassExample example);

    int updateByPrimaryKeySelective(TeachingClass record);

    int updateByPrimaryKey(TeachingClass record);
}