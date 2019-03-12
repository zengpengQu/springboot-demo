package com.cmahrmobile.hr.controller;

import com.cmahrmobile.hr.service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:RosterController
 * @Description: 花名册Controller层
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date:2018年11月20
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/roster")
public class RosterController {

	@Autowired
	RosterService rosterService;


	/**
	 * 根据机构或者部门的Id加载花名册的数据
	 * @return
	 */
	@RequestMapping(value = "/load-person-roster-data.action", method = RequestMethod.GET)
	@ResponseBody
	public String loadPersonRosterData(String orgId, String personType, String page) {
		return rosterService.loadRosterPerson(orgId, personType, page);
	}

	/**
	 * 根据人员ID加载人员基本信息
	 * @param personId
	 * @return
	 */
	@RequestMapping(value = "/load-person-data.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> loadPersonData(String personId) {
		Map<String, Object> map = new HashMap<>(2);
		map.put("personData", rosterService.loadPersonInformation(personId));
		return map;
	}

	/**
	 * 模糊搜索人员信息通过人员姓名
	 * @param personName
	 * @return
	 */
	@RequestMapping(value = "/load-person-data-with-person-name.action", method = RequestMethod.GET)
	@ResponseBody
	public String loadPersonDataWithPersonName(String personName,String orgId, String personType, String page) {
		return rosterService.loadPersonDataWithName(personName,orgId, personType, page);
	}
}
