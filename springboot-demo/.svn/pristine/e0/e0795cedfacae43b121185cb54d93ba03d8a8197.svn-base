package com.cmahrmobile.hr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticDao {

    // List<Map<String,Object>> indexPersonTypeData(@Param("deptCode") String deptCode,@Param("deptType") String deptType);
    List<Map<String,Object>> indexPersonTypeData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> findSexJsonData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> findNationJsonData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> findAgeJsonData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> findEduJsonData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> findDegreeJsonData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> findMajorDJsonData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> findTechJsonData(@Param("map") Map<String,Object> map);

    List<Map<String,Object>> getPersonListByStatisticData(@Param("map") Map<String,Object> map);
}
