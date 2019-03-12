package com.cmahrmobile.hr.service;

import com.cmahrmobile.hr.mapper.StatisticDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {

    @Autowired
    private StatisticDao statisticDao;

    public List<Map<String,Object>> index(){
        String deptCode = "R01";
        String deptType = "org";
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        map.put("deptType",deptType);
        List<Map<String,Object>> list = statisticDao.indexPersonTypeData(map);
        return list;
    }

    public List<Map<String,Object>> findSexJsonData(String deptCode,String personType,String deptType){
        deptCode = "R01";
        deptType = "org";
        personType = "ZZ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        map.put("deptType",deptType);
        map.put("personType",personType);
        map.put("len",deptCode.length());
        List<Map<String,Object>> list = statisticDao.findSexJsonData(map);
        return list;
    }
    public List<Map<String,Object>> findNationJsonData(String deptCode,String personType,String deptType){
        deptCode = "R01";
        deptType = "org";
        personType = "ZZ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        map.put("deptType",deptType);
        map.put("personType",personType);
        map.put("len",deptCode.length());
        List<Map<String,Object>> list = statisticDao.findNationJsonData(map);
        return list;
    }
    public List<Map<String,Object>> findAgeJsonData(String deptCode,String personType,String deptType){
        deptCode = "R01";
        deptType = "org";
        personType = "ZZ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        map.put("deptType",deptType);
        map.put("personType",personType);
        map.put("len",deptCode.length());
        List<Map<String,Object>> list = statisticDao.findAgeJsonData(map);
        return list;
    }
    public List<Map<String,Object>> findEduJsonData(String deptCode,String personType,String deptType){
         deptCode = "R01";
         deptType = "org";
         personType = "ZZ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        map.put("deptType",deptType);
        map.put("personType",personType);
        map.put("len",deptCode.length());
        List<Map<String,Object>> list = statisticDao.findEduJsonData(map);
        return list;
    }
    public List<Map<String,Object>> findDegreeJsonData(String deptCode,String personType,String deptType){
        deptCode = "R01";
        deptType = "org";
        personType = "ZZ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        map.put("deptType",deptType);
        map.put("personType",personType);
        map.put("len",deptCode.length());
        List<Map<String,Object>> list = statisticDao.findDegreeJsonData(map);
        return list;
    }

    public List<Map<String,Object>> findMajorJsonData(String deptCode,String personType,String deptType){
        deptCode = "R01";
        deptType = "org";
        personType = "ZZ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        map.put("deptType",deptType);
        map.put("personType",personType);
        map.put("len",deptCode.length());
        List<Map<String,Object>> list = statisticDao.findMajorDJsonData(map);
        return list;
    }

    public List<Map<String,Object>> findTechJsonData(String deptCode,String personType,String deptType){
        deptCode = "R01";
        deptType = "org";
        personType = "ZZ";
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        map.put("deptType",deptType);
        map.put("personType",personType);
        map.put("len",deptCode.length());
        List<Map<String,Object>> list = statisticDao.findTechJsonData(map);
        return list;
    }

    public List<Map<String,Object>> getPersonListByStatisticData(String deptCode,String personType,String dataType,String dataVal,String page){
        return null;
    }
}
