package com.cmahrmobile.hr;

import com.cmahrmobile.hr.dao.PersonInfoDao;
import com.cmahrmobile.hr.dao.StatisticalDao;
import com.cmahrmobile.hr.entity.hrset.PersonInfoSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrApplicationTests {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Autowired
	StatisticalDao statisticalDao;

	@Test
	public void contextLoads() {
		//List<PersonInfoSet> list = personInfoDao.findAllByDept("R01654107");
		String orgCode =null;
		List<Map<String,Object>> list =statisticalDao.findTechJsonData(orgCode,"");
	}

}
