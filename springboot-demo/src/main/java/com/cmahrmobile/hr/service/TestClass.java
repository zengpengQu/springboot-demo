package com.cmahrmobile.hr.service;

import com.cmahrmobile.hr.mapper.PersonSetInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Title: TestClass
 * @Description: // TODO
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date: 2019年01月18
 * @author: 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version: 1.0
 */
@Service
public class TestClass {

    @Autowired
    PersonSetInfoDao personInfoDao;

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
}
