package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Area;
import org.springframework.stereotype.Component;

@Component
public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
