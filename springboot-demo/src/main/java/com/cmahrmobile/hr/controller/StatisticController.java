package com.cmahrmobile.hr.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cmahrmobile.hr.dao.OrganizationDeptDao;
import com.cmahrmobile.hr.dao.StatisticalDao;
import com.cmahrmobile.hr.service.StatisticService;
import com.cmahrmobile.hr.service.TestClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

	@Autowired
	private StatisticalDao statisticalDao;

	@Autowired
	private OrganizationDeptDao deptDao;

	@Autowired
	private StatisticService statisticService;

	@Autowired
	private TestClass testClass;


	@RequestMapping(value = "/load-person-sex.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> showSexPie(String orgCode,String personType){
        orgCode = getOrgCode(orgCode);
		//List<Map<String,Object>> list = statisticalDao.findSexJsonData(orgCode,personType);
		List<Map<String,Object>> list = statisticService.findSexJsonData(orgCode,personType,"");
		Map<String,Object> result = new HashMap<>();
		result.put("data",list);
		return result;
	}


	@RequestMapping(value = "/load-person-nation.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> showNationPie(String orgCode,String personType){
        orgCode = getOrgCode(orgCode);
		//List<Map<String,Object>> list = statisticalDao.findNationJsonData(orgCode,personType);
		List<Map<String,Object>> list = statisticService.findNationJsonData(orgCode,personType,"");
		Map<String,Object> result = new HashMap<>();
		result.put("data",list);
		return result;
	}


	@RequestMapping(value = "/load-person-age.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> showAgePie(String orgCode,String personType){
        orgCode = getOrgCode(orgCode);
		//List<Map<String,Object>> list = statisticalDao.findAgeJsonData(orgCode,personType);
		List<Map<String,Object>> list = statisticService.findAgeJsonData(orgCode,personType,"");
		Map<String,Object> result = new HashMap<>();
		result.put("data",list);
		return result;
	}


	@RequestMapping(value = "/load-person-edu.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> showEduPie(String orgCode,String personType){
        orgCode = getOrgCode(orgCode);
		//List<Map<String,Object>> list = statisticalDao.findEduJsonData(orgCode,personType);
		List<Map<String,Object>> list = statisticService.findEduJsonData(orgCode,personType,"");
		Map<String,Object> result = new HashMap<>();
		result.put("data",list);
		return result;
	}


	@RequestMapping(value = "/load-person-degree.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> showDegreePie(String orgCode,String personType){
        orgCode = getOrgCode(orgCode);
		//List<Map<String,Object>> list = statisticalDao.findDegreeJsonData(orgCode,personType);
		List<Map<String,Object>> list = statisticService.findDegreeJsonData(orgCode,personType,"");
		Map<String,Object> result = new HashMap<>();
		result.put("data",list);
		return result;
	}


	@RequestMapping(value = "/load-person-major.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> showMajorPie(String orgCode,String personType){
        orgCode = getOrgCode(orgCode);
		//List<Map<String,Object>> list = statisticalDao.findMajorDJsonData(orgCode,personType);
		List<Map<String,Object>> list = statisticService.findMajorJsonData(orgCode,personType,"");
		Map<String,Object> result = new HashMap<>();
		result.put("data",list);
		return result;
	}

	@RequestMapping(value = "/load-person-tech.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> showTechPie(String orgCode,String personType){
        orgCode = getOrgCode(orgCode);
		//List<Map<String,Object>> list = statisticalDao.findTechJsonData(orgCode,personType);
		List<Map<String,Object>> list = statisticService.findTechJsonData(orgCode,personType,"");
		Map<String,Object> result = new HashMap<>();
		result.put("data",list);
		return result;
	}

	@RequestMapping(value = "/tree-org-dept.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> treeOrgDept(){
		Object data;
		if(null==InitDataListener.orgList){
			data= deptDao.orgDataTreeView();
		}else{
			data = InitDataListener.orgList;
		}
		Map<String,Object> result = new HashMap<>();
		result.put("data",data);
		return result;
	}

	@RequestMapping(value = "/index-person-data.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> indexPersonData(String orgCode){
		orgCode = getOrgCode(orgCode);
		List<Map<String,Object>> data= statisticService.index();
		Map<String,Object> result = new HashMap<>();
		result.put("data",data);
		return result;
	}

	@RequestMapping(value = "/list-person-by-statistic.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> ListPersonByStatisticData(String orgCode,String personType,String dataType,String dataVal,String page){
		orgCode = getOrgCode(orgCode);
		List<Map<String,Object>> data= statisticalDao.getPersonListByStatisticData(orgCode,personType,dataType,dataVal,page);
		Map<String,Object> result = new HashMap<>();
		result.put("data",JSON.toJSONString(data, SerializerFeature.WriteMapNullValue).replaceAll("null","\"暂无\""));
		return result;
	}

	public String getOrgCode(String orgCode){
        if(StringUtils.isEmpty(orgCode)||"R0001".equals(orgCode)){
            orgCode="R01";
        }
        return orgCode;
    }

}
