package com.cmahrmobile.hr.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Title: PersonInfoDao
 * @Description: 人员表Dao接口
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date: 2019年01月18
 * @author: 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version: 1.0
 */
@Mapper
public interface PersonSetInfoDao {

    /**
     * `
     * 加载花名册人员详细信息通过personId
     *
     * @param personId
     * @return List
     */
    List<Map<String, Object>> loadPersonDataWithPersonId(String personId);
}
