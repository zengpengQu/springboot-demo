package com.cmahrmobile.hr.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmahrmobile.hr.dao.PersonInfoDao;
import com.cmahrmobile.hr.dao.StatisticalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 * @Title:RosterService
 * @Description: 花名册业务服务层
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date:2018年11月20
 */
@Service
public class RosterService {

    @Autowired
    PersonInfoDao personInfoDao;
    /**
     * 加载人员花名册，根据机构ID或者DeptId
     *
     * @param orgId
     * @return String
     */
    public String loadRosterPerson(String orgId, String personType, String page) {
        List<Map<String, Object>> list = personInfoDao.loadRosterPerson(orgId, personType, page);
        return JSON.toJSONString(list, SerializerFeature.WriteMapNullValue).replaceAll("null", "\"暂无\"");
    }

    /**
     * 花名册加载人员详细信息
     *
     * @param personId
     * @return String
     */
    public List<Map<String, Object>> loadPersonInformation(String personId) {
        List<Map<String, Object>> list = personInfoDao.loadPersonDataWithPersonId(personId);
        return list;
    }

    /**
     * 模糊查找人员数据
     *
     * @param personName
     * @return String
     */
    public String loadPersonDataWithName(String personName, String orgId, String personType, String page) {
        List<Map<String, Object>> list = personInfoDao.loadPersonDataWithName(personName, orgId, personType, page);
        return JSON.toJSONString(list, SerializerFeature.WriteMapNullValue).replaceAll("null", "\"暂无\"");
    }
}
