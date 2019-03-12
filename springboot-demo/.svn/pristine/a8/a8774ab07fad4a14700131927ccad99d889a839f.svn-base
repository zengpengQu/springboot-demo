package com.cmahrmobile.hr.dao;

import com.cmahrmobile.hr.base.impl.BaseDaoImpl;
import com.cmahrmobile.hr.entity.hrset.PersonInfoSet;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StatisticalDao extends BaseDaoImpl<PersonInfoSet, String> {

	private static String orgCodeStatic = "R01";

	private static String personTypeStatic ="ZZ";

	private static int orgGunStatic = 155;

	/**
	 * 性别统计（男，女）
	 * @param orgCode
	 * @return
	 */
	public List<Map<String,Object>> findSexJsonData(String orgCode,String personType){
		Map<String,String> res = dealWithOrgData(orgCode);
		String code = res.get("code");
		String sql = "";
		if(StringUtils.isEmpty(orgCode)){
			code = orgCodeStatic;
		}
		if(StringUtils.isEmpty(personType)){
			personType = personTypeStatic;
		}
		int len = code.length();
		//if("1".equals(res.get("type"))){
        if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
            sql = "select count(1) as value ,case when a.sex = 1 then '男' else '女' end as name ,a.DEPARTMENT as unit from tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0' and a.DEPARTMENT ='"+code+"'  GROUP BY a.sex";
        }else{
            sql = "select count(1) as value ,case when a.sex = 1 then '男' else '女' end as name ,'"+code+"' as unit from tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0' and SUBSTR(a.UNIT_NAME,1,"+len+")='"+code+"'  GROUP BY a.sex";
        }

			/*sql = "select count(1) as value ,case when a.sex = 1 then '男' else '女' end as name ,'"+code+"' as unit from tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0'  GROUP BY a.sex ,a.UNIT_NAME ";
			sql+=" having a.UNIT_NAME = :code ";*/
		/*}else{
			sql = "select count(1) as value ,case when a.sex = 1 then '男' else '女' end as name ,a.DEPARTMENT as DEPARTMENT from tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0' GROUP BY a.sex ,a.DEPARTMENT ";
			sql+=" having a.DEPARTMENT = :code";
		}*/

		Map<String,Object> params = new HashMap<>();
		params.put("code",code);
		params.put("personType",personType);
		return jdbcQueryForList(sql,params);
	}

	/**
	 * 民族统计（汉族，少数民族）
	 * @param orgCode
	 * @return
	 */
	public List<Map<String,Object>> findNationJsonData(String orgCode,String personType){
		Map<String,String> res = dealWithOrgData(orgCode);
		String code = res.get("code");
		String sql = "";
		int len = code.length();
		//if("1".equals(res.get("type"))){
        if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
            sql= "select count(1) as value, t.name,t.unit,t.seq  from (select case when a.NATION ='01' then '汉族' else '少数民族' end as name ,case when a.NATION ='01' then '1' else '2' end as seq,a.DEPARTMENT as unit  from  tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0' and a.DEPARTMENT ='"+code+"') t  GROUP BY t.name order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }else{
            sql= "select count(1) as value, t.name,t.unit,t.seq  from (select case when a.NATION ='01' then '汉族' else '少数民族' end as name ,case when a.NATION ='01' then '1' else '2' end as seq,'"+code+"'as unit  from  tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0' and SUBSTR(a.UNIT_NAME,1,"+len+")='"+code+"') t  GROUP BY t.name order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }

			/*sql= "select count(1) as value, t.name,t.unit,t.seq  from (select case when a.NATION ='01' then '汉族' else '少数民族' end as name ,case when a.NATION ='01' then '1' else '2' end as seq,a.UNIT_NAME as unit  from  tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0') t  GROUP BY t.name,t.unit ";*/
		/*}else{
			sql= "select count(1) as value, t.name,t.unit,t.seq  from (select case when a.NATION ='01' then '汉族' else '少数民族' end as name ,case when a.NATION ='01' then '1' else '2' end as seq,a.DEPARTMENT as unit  from  tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0') t  GROUP BY t.name,t.unit ";
		}*/

		//return isOrgCodeExist(code,sql,personType);
	}

	/**
	 * 年龄分布（'35岁以下', '36－40','41－45','46－50','51－55','56及以上'）
	 * @param orgCode
	 * @return
	 */
	public List<Map<String,Object>> findAgeJsonData(String orgCode,String personType){
		Map<String,String> res = dealWithOrgData(orgCode);
		String code = res.get("code");
		String sql = "";
		int len = code.length();
        if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
            sql="select count(1) as value, t.name,t.unit,t.seq from (select case when a.AGE <= 35 then '35以下' when a.AGE>35 and a.AGE<=40 then '36-40' when a.AGE >40 and a.AGE <=45 then '41-45' when a.AGE >=46 and a.AGE <=50 then '46-50' when a.AGE >50 and a.AGE <=55 then '51-55' else '56及以上' end as name,"
                    +"case when a.AGE <= 35 then '1' when a.AGE>35 and a.AGE<=40 then '2' when a.AGE >40 and a.AGE <=45 then '3' when a.AGE >=46 and a.AGE <=50 then '4' when a.AGE >50 and a.AGE <=55 then '5' else '6' end as seq,"
                    + "a.DEPARTMENT as unit from tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0' and a.DEPARTMENT ='"+code+"') t GROUP BY t.name order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }else{
            sql="select count(1) as value, t.name,t.unit,t.seq from (select case when a.AGE <= 35 then '35以下' when a.AGE>35 and a.AGE<=40 then '36-40' when a.AGE >40 and a.AGE <=45 then '41-45' when a.AGE >=46 and a.AGE <=50 then '46-50' when a.AGE >50 and a.AGE <=55 then '51-55' else '56及以上' end as name,"
                    +"case when a.AGE <= 35 then '1' when a.AGE>35 and a.AGE<=40 then '2' when a.AGE >40 and a.AGE <=45 then '3' when a.AGE >=46 and a.AGE <=50 then '4' when a.AGE >50 and a.AGE <=55 then '5' else '6' end as seq,"
                    + "'"+code+"' as unit from tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0' and SUBSTR(a.UNIT_NAME,1,"+len+")='"+code+"') t GROUP BY t.name order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }
		//if("1".equals(res.get("type"))){
			/*sql="select count(1) as value, t.name,t.unit,t.seq from (select case when a.AGE <= 35 then '35以下' when a.AGE>35 and a.AGE<=40 then '36-40' when a.AGE >40 and a.AGE <=45 then '41-45' when a.AGE >=46 and a.AGE <=50 then '46-50' when a.AGE >50 and a.AGE <=55 then '51-55' else '56及以上' end as name,"
					+"case when a.AGE <= 35 then '1' when a.AGE>35 and a.AGE<=40 then '2' when a.AGE >40 and a.AGE <=45 then '3' when a.AGE >=46 and a.AGE <=50 then '4' when a.AGE >50 and a.AGE <=55 then '5' else '6' end as seq,"
					+ "a.UNIT_NAME as unit from tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0') t GROUP BY t.name,t.unit";*/

		/*}else{
			sql="select count(1) as value, t.name,t.unit,t.seq from (select case when a.AGE <= 35 then '35以下' when a.AGE>35 and a.AGE<=40 then '36-40' when a.AGE >40 and a.AGE <=45 then '41-45' when a.AGE >=46 and a.AGE <=50 then '46-50' when a.AGE >50 and a.AGE <=55 then '51-55' else '56及以上' end as name,"
					+"case when a.AGE <= 35 then '1' when a.AGE>35 and a.AGE<=40 then '2' when a.AGE >40 and a.AGE <=45 then '3' when a.AGE >=46 and a.AGE <=50 then '4' when a.AGE >50 and a.AGE <=55 then '5' else '6' end as seq,"
					+ "a.DEPARTMENT as unit from tb_set_person_info a where a.PERSON_TYPE = :personType and a.DEL_FLAG='0') t GROUP BY t.name,t.unit";
		}*/
		//return isOrgCodeExist(code,sql,personType);
	}


	/**
	 * 学历分布 研究生 本科 专科 中专 高中及以下
	 * @param orgCode
	 * @return
	 */
	public List<Map<String,Object>> findEduJsonData(String orgCode,String personType){
		Map<String,String> res = dealWithOrgData(orgCode);
		String code = res.get("code");
		String sql = "";
		int len = code.length();
		//if("1".equals(res.get("type"))){
        if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
            sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n" + "\tt.unit\n" + "FROM\n" + "\t(\n"
                    + "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) <= 4 THEN\n" + "\t\t\t'高中及以下'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 5\n" + "\t\tOR SUBSTR(c.DIC_CODE, 1, 1) = 6 THEN\n"
                    + "\t\t\t'中专'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 7 THEN\n" + "\t\t\t'专科'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 8 THEN\n" + "\t\t\t'本科'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 9 THEN\n" + "\t\t\t'研究生'\n"
                    + "\t\tWHEN c.DIC_CODE is null or c.DIC_CODE ='' then '无学历'\n"
                    + "\t\tEND AS name,\n"
                    + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) <= 4 THEN\n" + "\t\t\t'5'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 5\n" + "\t\tOR SUBSTR(c.DIC_CODE, 1, 1) = 6 THEN\n"
                    + "\t\t\t'4'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 7 THEN\n" + "\t\t\t'3'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 8 THEN\n" + "\t\t\t'2'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 9 THEN\n" + "\t\t\t'1'\n"
                    + "\t\tWHEN c.DIC_CODE is null or c.DIC_CODE ='' then '6'\n"
                    + "\t\tEND AS seq,\n"
                    + "\t\ta.DEPARTMENT AS unit " + "\tFROM\n" + "\t\t( select * from tb_set_person_info a where a.DEPARTMENT ='"+code+"' and a.PERSON_TYPE = :personType and a.DEL_FLAG='0') a\n"
                    + "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.education from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b,( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT ='"+code+"' AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = b.person_id GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID \n"
                    + "\tleft JOIN tb_dic_code_def c ON b.education = c.dic_code\n" + "\tAND c.dic_id = 'WL'\n"
                    + "\t) t GROUP BY t.name ORDER BY\n" +
                    "\tt.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }else{
            sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n" + "\tt.unit\n" + "FROM\n" + "\t(\n"
                    + "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) <= 4 THEN\n" + "\t\t\t'高中及以下'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 5\n" + "\t\tOR SUBSTR(c.DIC_CODE, 1, 1) = 6 THEN\n"
                    + "\t\t\t'中专'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 7 THEN\n" + "\t\t\t'专科'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 8 THEN\n" + "\t\t\t'本科'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 9 THEN\n" + "\t\t\t'研究生'\n"
                    + "\t\tWHEN c.DIC_CODE is null or c.DIC_CODE ='' then '无学历'\n"
                    + "\t\tEND AS name,\n"
                    + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) <= 4 THEN\n" + "\t\t\t'5'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 5\n" + "\t\tOR SUBSTR(c.DIC_CODE, 1, 1) = 6 THEN\n"
                    + "\t\t\t'4'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 7 THEN\n" + "\t\t\t'3'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 8 THEN\n" + "\t\t\t'2'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 9 THEN\n" + "\t\t\t'1'\n"
                    + "\t\tWHEN c.DIC_CODE is null or c.DIC_CODE ='' then '6'\n"
                    + "\t\tEND AS seq,\n"
                    + "\t\tsubstr(a.UNIT_NAME,1,"+len+") AS unit " + "\tFROM\n" + "\t\t( select * from tb_set_person_info a where substr(a.UNIT_NAME,1,"+len+") ='"+code+"' and a.PERSON_TYPE = :personType and a.DEL_FLAG='0') a\n"
                    + "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.education from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b,( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1,"+len+") ='"+code+"' AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = b.person_id GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID \n"
                    + "\tleft JOIN tb_dic_code_def c ON b.education = c.dic_code\n" + "\tAND c.dic_id = 'WL'\n"
                    + "\t) t GROUP BY t.name ORDER BY\n" +
                    "\tt.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }


		/*}else{
			sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n" + "\tt.unit\n" + "FROM\n" + "\t(\n"
					+ "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) <= 4 THEN\n" + "\t\t\t'高中及以下'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 5\n" + "\t\tOR SUBSTR(c.DIC_CODE, 1, 1) = 6 THEN\n"
					+ "\t\t\t'中专'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 7 THEN\n" + "\t\t\t'专科'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 8 THEN\n" + "\t\t\t'本科'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 9 THEN\n" + "\t\t\t'研究生'\n"
					+ "\t\tWHEN c.DIC_CODE is null or c.DIC_CODE ='' then '无学历'\n"
					+ "\t\tEND AS name,\n"
					+ "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) <= 4 THEN\n" + "\t\t\t'5'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 5\n" + "\t\tOR SUBSTR(c.DIC_CODE, 1, 1) = 6 THEN\n"
					+ "\t\t\t'4'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 7 THEN\n" + "\t\t\t'3'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 8 THEN\n" + "\t\t\t'2'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 9 THEN\n" + "\t\t\t'1'\n"
					+ "\t\tWHEN c.DIC_CODE is null or c.DIC_CODE ='' then '6'\n"
					+ "\t\tEND AS seq,\n"
					+ "\t\ta.DEPARTMENT AS unit\n" + "\tFROM\n" + "\t\ttb_set_person_info a\n"
					+ "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.education from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID\n"
					+ "\tleft JOIN tb_dic_code_def c ON b.education = c.dic_code\n" + "\tAND c.dic_id = 'WL' where  a.PERSON_TYPE = :personType and a.DEL_FLAG='0'\n"
					+ "\t) t GROUP BY t.name,t.unit";
		}*/
		//return isOrgCodeExist(code,sql,personType);
	}

	/**
	 * 学位分布 '博士','硕士','学士','无学位'
	 * @param orgCode
	 * @return
	 */
	public List<Map<String,Object>> findDegreeJsonData(String orgCode,String personType){
		Map<String,String> res = dealWithOrgData(orgCode);
		String code = res.get("code");
		String sql = "";
		int len = code.length();
		//if("1".equals(res.get("type"))){
        if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
            sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n"  + "\tt.unit,t.PERSON_TYPE\n" + "FROM\n" + "\t(\n"
                    + "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 2 THEN\n" + "\t\t\t'博士'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 3 THEN\n" + "\t\t\t'硕士'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 4 THEN\n" + "\t\t\t'学士'\n" + "\t\tELSE\n" + "\t\t\t'无学位'\n"
                    + "\t\tEND AS name,\n"
                    + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 2 THEN\n" + "\t\t\t'1'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 3 THEN\n" + "\t\t\t'2'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 4 THEN\n" + "\t\t\t'3'\n" + "\t\tELSE\n" + "\t\t\t'4'\n"
                    + "\t\tEND AS seq,\n"
                    + " a.DEPARTMENT AS unit,a.PERSON_TYPE\n" + "\tFROM\n" + "\t\t( select * from tb_set_person_info a where a.DEPARTMENT ='"+code+"' and a.PERSON_TYPE = :personType and a.DEL_FLAG='0') a\n"
                    + "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.degree from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b ,( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT ='"+code+"' AND PERSON_TYPE = :personType ) t WHERE t.id = b.person_id GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID and a.DEL_FLAG='0'\n"
                    + "\tleft JOIN tb_dic_code_def c ON b.degree = c.dic_code\n" + "\tAND c.dic_id = 'AN'\n" + "\t) t\n"
                    + "where  t.PERSON_TYPE = :personType "
                    + "GROUP BY\n" + "\tt.name\n order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }else{
            sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n"  + "\tt.unit,t.PERSON_TYPE\n" + "FROM\n" + "\t(\n"
                    + "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 2 THEN\n" + "\t\t\t'博士'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 3 THEN\n" + "\t\t\t'硕士'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 4 THEN\n" + "\t\t\t'学士'\n" + "\t\tELSE\n" + "\t\t\t'无学位'\n"
                    + "\t\tEND AS name,\n"
                    + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 2 THEN\n" + "\t\t\t'1'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 3 THEN\n" + "\t\t\t'2'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 4 THEN\n" + "\t\t\t'3'\n" + "\t\tELSE\n" + "\t\t\t'4'\n"
                    + "\t\tEND AS seq,\n"
                    + " substr(a.UNIT_NAME,1,"+len+") AS unit,a.PERSON_TYPE\n" + "\tFROM\n" + "\t\t( select * from tb_set_person_info a where substr(a.UNIT_NAME,1,"+len+") ='"+code+"' and a.PERSON_TYPE = :personType and a.DEL_FLAG='0') a\n"
                    + "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.degree from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b ,( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1,"+len+") ='"+code+"' AND PERSON_TYPE = :personType ) t WHERE t.id = b.person_id GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID and a.DEL_FLAG='0'\n"
                    + "\tleft JOIN tb_dic_code_def c ON b.degree = c.dic_code\n" + "\tAND c.dic_id = 'AN'\n" + "\t) t\n"
                    + "where  t.PERSON_TYPE = :personType "
                    + "GROUP BY\n" + "\tt.name\n order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }

			/*sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n"  + "\tt.unit,t.PERSON_TYPE\n" + "FROM\n" + "\t(\n"
					+ "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 2 THEN\n" + "\t\t\t'博士'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 3 THEN\n" + "\t\t\t'硕士'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 4 THEN\n" + "\t\t\t'学士'\n" + "\t\tELSE\n" + "\t\t\t'无学位'\n"
					+ "\t\tEND AS name,\n"
					+ "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 2 THEN\n" + "\t\t\t'1'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 3 THEN\n" + "\t\t\t'2'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 4 THEN\n" + "\t\t\t'3'\n" + "\t\tELSE\n" + "\t\t\t'4'\n"
					+ "\t\tEND AS seq,\n"
					+ "\t\ta.UNIT_NAME AS unit,a.PERSON_TYPE\n" + "\tFROM\n" + "\t\ttb_set_person_info a\n"
					+ "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.degree from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID and a.DEL_FLAG='0'\n"
					+ "\tleft JOIN tb_dic_code_def c ON b.degree = c.dic_code\n" + "\tAND c.dic_id = 'AN'\n" + "\t) t\n"
					+ "where  t.PERSON_TYPE = :personType "
					+ "GROUP BY\n" + "\tt.name,\n" + "\tt.unit";*/
		/*}else{
			sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n" + "\tt.seq,\n" + "\tt.unit,t.PERSON_TYPE\n" + "FROM\n" + "\t(\n"
					+ "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 2 THEN\n" + "\t\t\t'博士'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 3 THEN\n" + "\t\t\t'硕士'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 4 THEN\n" + "\t\t\t'学士'\n" + "\t\tELSE\n" + "\t\t\t'无学位'\n"
					+ "\t\tEND AS name,\n"
					+ "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 2 THEN\n" + "\t\t\t'1'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 3 THEN\n" + "\t\t\t'2'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 1) = 4 THEN\n" + "\t\t\t'3'\n" + "\t\tELSE\n" + "\t\t\t'4'\n"
					+ "\t\tEND AS seq,\n"
					+ "\t\ta.DEPARTMENT AS unit,a.PERSON_TYPE\n" + "\tFROM\n" + "\t\ttb_set_person_info a\n"
					+ "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.degree from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID  and a.DEL_FLAG='0'\n"
					+ "\tleft JOIN tb_dic_code_def c ON b.degree = c.dic_code\n" + "\tAND c.dic_id = 'AN'\n" + "\t) t\n"
					+ "where  t.PERSON_TYPE = :personType "
					+ "GROUP BY\n" + "\tt.name,\n" + "\tt.unit";
		}*/


		//return isOrgCodeExist(code,sql,personType);
	}


	/**
	 * 专业分布 '大气科学'0709,'地球科学及其他专业'0707,'信息技术类'0712
	 * @param orgCode
	 * @return
	 */
	public List<Map<String,Object>> findMajorDJsonData(String orgCode,String personType){
		Map<String,String> res = dealWithOrgData(orgCode);
		String code = res.get("code");
		String sql = "";
		int len = code.length();
		//if("1".equals(res.get("type"))){
        if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
            sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n"  + "\tt.unit\n" + "FROM\n" + "\t(\n"
                    + "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0712' THEN\n"
                    + "\t\t\t'信息技术类'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0707' THEN\n" + "\t\t\t'地球科学及其他专业'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0709' THEN\n" + "\t\t\t'大气科学'\n" + "\t\telse '其他' END AS name,\n"
                    +"\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0712' THEN\n"
                    + "\t\t\t'3'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0707' THEN\n" + "\t\t\t'2'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0709' THEN\n" + "\t\t\t'1'\n" + "\t\t else '4' END AS seq,\n"
                    + " a.DEPARTMENT AS unit " + "\tFROM\n" + "\t\t( select * from tb_set_person_info a where a.DEPARTMENT ='"+code+"' and a.PERSON_TYPE = :personType and a.DEL_FLAG='0') a\n"
                    + "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.major from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b,( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT ='"+code+"' AND PERSON_TYPE = :personType ) t WHERE t.id = b.person_id  GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID\n"
                    + "\tleft JOIN tb_dic_code_def c ON b.major = c.dic_code\n" + "\tAND c.dic_id = 'AI' where  a.PERSON_TYPE = :personType and a.DEL_FLAG='0'\n" + "\t) t\n"
                    + "GROUP BY\n" + "\tt.name order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }else{
            sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n"  + "\tt.unit\n" + "FROM\n" + "\t(\n"
                    + "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0712' THEN\n"
                    + "\t\t\t'信息技术类'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0707' THEN\n" + "\t\t\t'地球科学及其他专业'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0709' THEN\n" + "\t\t\t'大气科学'\n" + "\t\telse '其他' END AS name,\n"
                    +"\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0712' THEN\n"
                    + "\t\t\t'3'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0707' THEN\n" + "\t\t\t'2'\n"
                    + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0709' THEN\n" + "\t\t\t'1'\n" + "\t\t else '4' END AS seq,\n"
                    + " substr(a.UNIT_NAME,1,"+len+") AS unit " + "\tFROM\n" + "\t\t( select * from tb_set_person_info a where substr(a.UNIT_NAME,1,"+len+") ='"+code+"' and a.PERSON_TYPE = :personType and a.DEL_FLAG='0') a\n"
                    + "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.major from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b,( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1,"+len+") ='"+code+"' AND PERSON_TYPE = :personType ) t WHERE t.id = b.person_id  GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID\n"
                    + "\tleft JOIN tb_dic_code_def c ON b.major = c.dic_code\n" + "\tAND c.dic_id = 'AI' where  a.PERSON_TYPE = :personType and a.DEL_FLAG='0'\n" + "\t) t\n"
                    + "GROUP BY\n" + "\tt.name order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }

			/*sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n"+ "\tt.seq,\n"  + "\tt.unit\n" + "FROM\n" + "\t(\n"
					+ "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0712' THEN\n"
					+ "\t\t\t'信息技术类'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0707' THEN\n" + "\t\t\t'地球科学及其他专业'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0709' THEN\n" + "\t\t\t'大气科学'\n" + "\t\telse '其他' END AS name,\n"
					+"\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0712' THEN\n"
					+ "\t\t\t'3'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0707' THEN\n" + "\t\t\t'2'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0709' THEN\n" + "\t\t\t'1'\n" + "\t\t else '4' END AS seq,\n"
					+ "\t\ta.UNIT_NAME AS unit\n" + "\tFROM\n" + "\t\ttb_set_person_info a\n"
					+ "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.major from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID \n"
					+ "\tleft JOIN tb_dic_code_def c ON b.major = c.dic_code\n" + "\tAND c.dic_id = 'AI' where a.PERSON_TYPE = :personType and a.DEL_FLAG='0'\n" + "\t) t\n"
					+ "GROUP BY\n" + "\tt.name,\n" + "\tt.unit";*/
		/*}else{
			sql = "SELECT\n" + "\tcount(1) AS value,\n" + "\tt.name,\n" + "\tt.seq,\n" + "\tt.unit\n" + "FROM\n" + "\t(\n"
					+ "\t\tSELECT\n" + "\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0712' THEN\n"
					+ "\t\t\t'信息技术类'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0707' THEN\n" + "\t\t\t'地球科学及其他专业'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0709' THEN\n" + "\t\t\t'大气科学'\n" + "\t\t else '其他' END AS name,\n"
					+"\t\t\tCASE\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0712' THEN\n"
					+ "\t\t\t'3'\n" + "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0707' THEN\n" + "\t\t\t'2'\n"
					+ "\t\tWHEN SUBSTR(c.DIC_CODE, 1, 4) = '0709' THEN\n" + "\t\t\t'1'\n" + "\t\t else '4' END AS seq,\n"
					+ "\t\ta.DEPARTMENT AS unit\n" + "\tFROM\n" + "\t\ttb_set_person_info a\n"
					+ "\tleft JOIN (select DISTINCT bi.PERSON_ID,bi.major from tb_set_edu_deg bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_edu_deg b GROUP BY b.PERSON_ID having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.PERSON_ID \n"
					+ "\tleft JOIN tb_dic_code_def c ON b.major = c.dic_code\n" + "\tAND c.dic_id = 'AI' where  a.PERSON_TYPE = :personType and a.DEL_FLAG='0'\n" + "\t) t\n"
					+ "GROUP BY\n" + "\tt.name,\n" + "\tt.unit";
		}*/
		//return isOrgCodeExist(code,sql,personType);
	}

	/**
	 * '正研'1,'副研'2,'中级'3,'初级'4,5,'见习'9,'无资格'null
	 * @param orgCode
	 * @return
	 */
	public List<Map<String,Object>> findTechJsonData(String orgCode,String personType){
		Map<String,String> res = dealWithOrgData(orgCode);
		String code = res.get("code");
		String sql = "";
		int len = code.length();
		//if("1".equals(res.get("type"))){
        if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
            sql = "select count(1) as value, t.name,t.unit,t.seq from (" + "SELECT "
                    + " case when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='1' then '正研' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='2' then '副研' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='3' then '中级' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='5' or SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='4'  then '初级' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='9' then '见习' else '无资格' end as name,a.DEPARTMENT AS unit,"
                    +"case when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='1' then '1' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='2' then '2' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='3' or SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='4' then '3' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='5'  then '4' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='9' then '5' else '6' end as seq "
                    + "FROM " + " ( select * from tb_set_person_info a where a.DEPARTMENT ='"+code+"' and a.PERSON_TYPE = :personType and a.DEL_FLAG='0') a "
                    + "left JOIN (select DISTINCT bi.PERSON_ID,bi.TEC_QUA from tb_set_prof_tech_post bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_prof_tech_post b ,( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT ='"+code+"' AND PERSON_TYPE = :personType ) t WHERE t.id = b.person_id GROUP BY b.PERSON_ID  having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.person_id  "
                    + "left JOIN tb_dic_code_def c ON b.tec_qua = c.dic_code " + "AND c.dic_id = 'AJ' where a.PERSON_TYPE = :personType and a.DEL_FLAG='0'"
                    + ") t " + "GROUP BY t.name,t.unit order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }else{
            sql = "select count(1) as value, t.name,t.unit,t.seq from (" + "SELECT "
                    + " case when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='1' then '正研' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='2' then '副研' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='3' then '中级' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='5' or SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='4'  then '初级' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='9' then '见习' else '无资格' end as name,substr(a.UNIT_NAME,1,"+len+") AS unit,"
                    +"case when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='1' then '1' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='2' then '2' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='3' or SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='4' then '3' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='5'  then '4' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='9' then '5' else '6' end as seq "
                    + "FROM " + " ( select * from tb_set_person_info a where substr(a.UNIT_NAME,1,"+len+") ='"+code+"' and a.PERSON_TYPE = :personType and a.DEL_FLAG='0') a "
                    + "left JOIN (select DISTINCT bi.PERSON_ID,bi.TEC_QUA from tb_set_prof_tech_post bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_prof_tech_post b ,( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1,"+len+") ='"+code+"' AND PERSON_TYPE = :personType ) t WHERE t.id = b.person_id GROUP BY b.PERSON_ID  having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.person_id  "
                    + "left JOIN tb_dic_code_def c ON b.tec_qua = c.dic_code " + "AND c.dic_id = 'AJ' where a.PERSON_TYPE = :personType and a.DEL_FLAG='0'"
                    + ") t " + "GROUP BY t.name,t.unit order by t.seq";
            Map<String,Object> params = new HashMap<>();
            params.put("code",orgCode);
            params.put("personType",personType);
            return jdbcQueryForList(sql,params);
        }

		/*	sql = "select count(1) as value, t.name,t.unit,t.seq from (" + "SELECT "
					+ " case when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='1' then '正研' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='2' then '副研' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='3' or SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='4' then '中级' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='5'  then '初级' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='9' then '见习' else '无资格' end as name,a.UNIT_NAME as unit,"
					+"case when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='1' then '1' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='2' then '2' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='3' or SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='4' then '3' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='5'  then '4' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='9' then '5' else '6' end as seq "
					+ "FROM " + " tb_set_person_info a "
					+ "left JOIN (select DISTINCT bi.PERSON_ID,bi.TEC_QUA from tb_set_prof_tech_post bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_prof_tech_post b GROUP BY b.PERSON_ID  having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.person_id  "
					+ "left JOIN tb_dic_code_def c ON b.tec_qua = c.dic_code " + "AND c.dic_id = 'AJ' where  a.PERSON_TYPE = :personType and a.DEL_FLAG='0'"
					+ ") t " + "GROUP BY t.name,t.unit";*/
		/*}else{
			sql = "select count(1) as value, t.name,t.unit,t.seq from (" + "SELECT "
					+ " case when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='1' then '正研' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='2' then '副研' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='3'  then '中级' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='5' or SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='4'  then '初级' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='9' then '见习' else '无资格' end as name,a.DEPARTMENT as unit,"
					+"case when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='1' then '1' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='2' then '2' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='3' or SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='4' then '3' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='5'  then '4' when SUBSTR(c.DIC_CODE,LENGTH(c.DIC_CODE), 1) ='9' then '5' else '6' end as seq "
					+ "FROM " + " tb_set_person_info a "
					+ "left JOIN (select DISTINCT bi.PERSON_ID,bi.TEC_QUA from tb_set_prof_tech_post bi inner join (select b.PERSON_ID,MAX(b.ENTRY_NUM) as num,b.del_flag from tb_set_prof_tech_post b GROUP BY b.PERSON_ID  having b.del_flag='0') bt on bt.num=bi.ENTRY_NUM and bi.PERSON_ID=bt.PERSON_ID) b ON a.id = b.person_id  "
					+ "left JOIN tb_dic_code_def c ON b.tec_qua = c.dic_code " + "AND c.dic_id = 'AJ' where  a.PERSON_TYPE = :personType and a.DEL_FLAG='0'"
					+ ") t " + "GROUP BY t.name,t.unit";
		}*/
		//return isOrgCodeExist(code,sql,personType);
	}


	/**
	 * 首页人员类别分组
	 * @param orgCode
	 * @return
	 */
	public List<Map<String,Object>> indexPersonTypeData(String orgCode){
		Map<String,String> res = dealWithOrgData(orgCode);
		String code = res.get("code");
		String sql = "";
		if(orgCodeStatic.equals(code)){
			sql="select  aa.count ,tt.type_name,tt.type_code,tt.id from tb_dic_person_type  tt LEFT JOIN (select a.UNIT_NAME,count(1) as count,a.PERSON_TYPE from tb_set_person_info a inner JOIN  tb_dic_person_type t\n"
					+ "on a.PERSON_TYPE = t.TYPE_CODE where a.DEL_FLAG='0' GROUP BY a.PERSON_TYPE ) aa on tt.type_code = aa.PERSON_TYPE  order by tt.id";
		}else{

		    if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
                sql="select  aa.count ,tt.type_name,tt.type_code,tt.id from tb_dic_person_type  tt LEFT JOIN (select a.DEPARTMENT,count(1) as count,a.PERSON_TYPE from tb_set_person_info a inner JOIN  tb_dic_person_type t\n"
                        + "on a.PERSON_TYPE = t.TYPE_CODE where a.DEL_FLAG='0' GROUP BY a.PERSON_TYPE,a.DEPARTMENT) aa on tt.type_code = aa.PERSON_TYPE and aa.DEPARTMENT = '"+code+"'  order by tt.id";
            }else{
                sql="select  aa.count ,tt.type_name,tt.type_code,tt.id from tb_dic_person_type  tt LEFT JOIN (select a.UNIT_NAME,count(1) as count,a.PERSON_TYPE from tb_set_person_info a inner JOIN  tb_dic_person_type t\n"
                        + "on a.PERSON_TYPE = t.TYPE_CODE where a.DEL_FLAG='0' and a.UNIT_NAME like '"+code+"%' GROUP BY a.PERSON_TYPE) aa on tt.type_code = aa.PERSON_TYPE  order by tt.id";
            }
			/*if("1".equals(res.get("type"))){*/

			/*}else{
				sql="select  aa.count ,tt.type_name,tt.type_code,tt.id from tb_dic_person_type  tt LEFT JOIN (select a.DEPARTMENT,count(1) as count,a.PERSON_TYPE from tb_set_person_info a inner JOIN  tb_dic_person_type t\n"
						+ "on a.PERSON_TYPE = t.TYPE_CODE where a.DEL_FLAG='0' GROUP BY a.PERSON_TYPE,a.DEPARTMENT) aa on tt.type_code = aa.PERSON_TYPE and aa.DEPARTMENT = '"+code+"'  order by tt.id";
			}*/
		}
 		Map<String,Object> params = new HashMap<>();
		return jdbcQueryForList(sql,params);
	}



	/**
	 * 处理筛选条件
	 */
	public List<Map<String,Object>> isOrgCodeExist(String orgCode,String sql,String personType){
		if(StringUtils.isEmpty(orgCode)){
			orgCode = orgCodeStatic;
		}
		if(StringUtils.isEmpty(personType)){
			personType = personTypeStatic;
		}

		sql+=" having t.unit = :code and t.name <> '' order by t.seq ";

		Map<String,Object> params = new HashMap<>();
		params.put("code",orgCode);
		params.put("personType",personType);
		return jdbcQueryForList(sql,params);
	}

	/**
	 * 处理前端机构的数据，type=1为单位，2为部门，code是具体值
	 * @param orgCode
	 * @return
	 */
	public Map<String,String> dealWithOrgData(String orgCode){
		Map<String,String> res = new HashMap<>();
		if(orgCode.indexOf(",")!=-1){
			String [] orgArr = orgCode.split(",");
            String orgCodes ="";
            String deptCodes="";
            if(orgArr.length==2){
                orgCodes = orgArr[0];
                deptCodes = orgArr[1];
            }else{
                if(orgGunStatic>=Integer.parseInt(orgArr[0].substring(1))){
                    orgCodes = orgArr[0];
                    deptCodes = orgArr[1];
                }else{
                    orgCodes = orgArr[1];
                    deptCodes = orgArr[2];
                }
            }
            String deptDefault = "R00"+orgCodes.substring(1);
            if(deptCodes.equals(deptDefault)){
                res.put("type","1");
                res.put("code",orgCodes);
            }else{
                res.put("type","2");
                res.put("code",deptCodes);
            }
		}else{
			res.put("type","1");
			res.put("code",orgCode);
		}
		return res;
	}


	public List<Map<String,Object>> getPersonListByStatisticData(String orgCode,String personType,String dataType,String dataVal,String page){
		Map<String,String> res = dealWithOrgData(orgCode);
		String orgSql ="";
		int offset = 0;
		int pageSize = 20;
		String limit = "";
		if(!StringUtils.isEmpty(page)){
			int pages = Integer.parseInt(page);
			offset = pageSize*pages;
		}
		limit = "limit "+offset+","+pageSize+"";
		String code = res.get("code");
		int len = code.length();
		/*if(orgCodeStatic.equals(orgCode)){
			orgSql =" where t.PERSON_TYPE = '"+personType+"'";
		}else{
			*//*if(res.get("type").equals("2")){*//*
				//orgSql=" where t.DEPARTMENT = '"+res.get("code")+"' and t.PERSON_TYPE = '"+personType+"' ";
			//}else{
				orgSql=" where substr(t.UNIT_NAME,1,"+len+") = '"+code+"' and t.PERSON_TYPE = '"+personType+"' ";
			//}
		}*/

		String dataSql ="";
		dataSql = " t."+dataType+" = "+"'"+dataVal+"'";
		/*String sql = "select DISTINCT * from ( SELECT\n" + "\t t.ID,\n" + "   t.PERSON_TYPE,\n t.seq," + "\t t.AGE age,\n"
				+ "\t t.NAME name,\n" + "\tdept.DEPT_NAME dept,\n"
				+ "\t( CASE WHEN t.SEX = '1' THEN '男' WHEN t.SEX = '2' THEN '女' END ) AS sex,\n"
				+ "postFin.POST_NAME postName,\n" + "polFin.pol_sta_name mm ,\n" + "substr(t.UNIT_NAME,1,"+len+") as  UNIT_NAME,\n" + "\t(\n"
				+ "\tCASE\n" + "\t\t\t\n" + "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '1' THEN\n"
				+ "\t\t\t'正研' \n" + "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '2' THEN\n"
				+ "\t\t\t'副研' \n" + "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '3' \n"
				+ "\t\t\t THEN\n" + "\t\t\t\t'中级' \n"
				+ "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '5' or SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '4' THEN\n" + "\t\t\t\t'初级' \n"
				+ "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '9' THEN\n" + "\t\t\t\t'见习' ELSE '无资格' \n"
				+ "\t\t\tEND \n" + "\t\t\t) AS post,\n" + "\t(\n" + "\tCASE\n" + "\t\t\t\n"
				+ "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '1' THEN\n" + "\t\t\t'正研' \n"
				+ "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '2' THEN\n" + "\t\t\t'副研' \n"
				+ "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '3' \n"
				+ "\t\t\tTHEN\n" + "\t\t\t\t'中级' \n"
				+ "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '5' OR SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '4'  THEN\n" + "\t\t\t\t'初级' \n"
				+ "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '9' THEN\n" + "\t\t\t\t'见习' ELSE '无资格' \n"
				+ "\t\t\tEND \n" + "\t\t\t) AS stech,\n" + "\t\t\n"
				+ "( CASE WHEN t.SEX = '1' THEN '男' WHEN t.SEX = '2' THEN '女' END ) AS ssex,\n" + "CASE\n"
				+ "\t\tWHEN SUBSTR(eduFin.education, 1, 1) <= 4 THEN\n" + "\t\t\t'高中及以下'\n"
				+ "\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 5\n" + "\t\tOR SUBSTR(eduFin.education, 1, 1) = 6 THEN\n"
				+ "\t\t\t'中专'\n" + "\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 7 THEN\n" + "\t\t\t'专科'\n"
				+ "\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 8 THEN\n" + "\t\t\t'本科'\n"
				+ "\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 9 THEN\n" + "\t\t\t'研究生' else '无学历'\n"
				+ "\t\tEND AS sedu,\n" + "\t\n" + "CASE\n" + "\t\tWHEN SUBSTR(eduFin.degree, 1, 1) = 2 THEN\n"
				+ "\t\t\t'博士'\n" + "\t\tWHEN SUBSTR(eduFin.degree, 1, 1) = 3 THEN\n" + "\t\t\t'硕士'\n"
				+ "\t\tWHEN SUBSTR(eduFin.degree, 1, 1) = 4 THEN\n" + "\t\t\t'学士'\n" + "\t\tELSE\n" + "\t\t\t'无学位'\n"
				+ "\t\tEND AS sdegree,\n" + "\t\n" + "\tCASE\n" + "\t\tWHEN SUBSTR(eduFin.major, 1, 4) = '0712' THEN\n"
				+ "\t\t\t'信息技术类'\n" + "\t\tWHEN SUBSTR(eduFin.major, 1, 4) = '0707' THEN\n" + "\t\t\t'地球科学及其他专业'\n"
				+ "\t\tWHEN SUBSTR(eduFin.major, 1, 4) = '0709' THEN\n" + "\t\t\t'大气科学'\n" + "    else '其他'\n"
				+ "\t\tEND AS smajor,\n"
				+ "case when t.AGE <= 35 then '35以下' when t.AGE>35 and t.AGE<=40 then '36-40' when t.AGE >40 and t.AGE <=45 then '41-45' when t.AGE >=46 and t.AGE <=50 then '46-50' when t.AGE >50 and t.AGE <=55 then '51-55' else '56及以上' end as sage,\n"
				+ "\t\t\tcase when t.NATION ='01' then '汉族' else '少数民族' end as snation\n" + "\n" + "\t\tFROM\n"
				+ "\t\t\ttb_set_person_info t\n" + "\t\t\tLEFT JOIN (\n" + "\t\t\tSELECT\n" + "\t\t\t\tdept.id,\n"
				+ "\t\t\t\tdept.DEPT_NAME \n" + "\t\t\tFROM\n" + "\t\t\t\ttb_dic_organization org\n"
				+ "\t\t\t\tINNER JOIN tb_dic_dept dept ON org.id = dept.p_id \n" + "\t\t\tWHERE\n"
				+ "\t\t\t\torg.ID = 'R0112'\n" + "\t\t\t) dept ON t.DEPARTMENT = dept.ID\n" + "\t\t\tLEFT JOIN (\n"
				+ "\t\t\tSELECT\n" + "\t\t\t\tbi.PERSON_ID,\n" + "\t\t\t\tbi.TEC_QUA \n" + "\t\t\tFROM\n"
				+ "\t\t\t\ttb_set_prof_tech_post bi\n"
				+ "\t\t\t\tINNER JOIN ( SELECT b.PERSON_ID, MAX( b.ENTRY_NUM ) AS num FROM tb_set_prof_tech_post b GROUP BY b.PERSON_ID ) bt ON bt.num = bi.ENTRY_NUM \n"
				+ "\t\t\t\tAND bi.PERSON_ID = bt.PERSON_ID \n" + "\t\t\t) b ON t.id = b.PERSON_ID\n"
				+ "\t\t\tLEFT JOIN (\n" + "\t\t\tSELECT\n" + "\t\t\t\tpol.PERSON_ID,\n"
				+ "\t\t\t\tdic.CODE_NAME pol_sta_name  \n" + "\t\t\tFROM\n" + "\t\t\t\ttb_set_pol_sta pol\n"
				+ "\t\t\t\tINNER JOIN ( SELECT pola.PERSON_ID, MAX( pola.ENTRY_NUM ) AS num FROM tb_set_pol_sta pola GROUP BY pola.PERSON_ID ) polMax ON polMax.num = pol.ENTRY_NUM \n"
				+ "\t\t\t\tAND pol.PERSON_ID = polMax.PERSON_ID INNER JOIN tb_dic_code_def dic ON dic.DIC_ID = 'BU' \n"
				+ "\t\t\t\tAND pol.pol_sta_name = dic.DIC_CODE \n" + "\t\t\t) polFin ON t.id = polFin.PERSON_ID \n"
				+ "\t\t\tLEFT JOIN (\n" + "\t\t\tSELECT\n" + "\t\t\t\tedu.PERSON_ID,\n" + "\t\t\t\tedu.education,\n"
				+ "\t\t\t\tedu.degree,\n" + "\t\t\t\tedu.major \n" + "\t\t\tFROM\n" + "\t\t\t\ttb_set_edu_deg edu\n"
				+ "\t\t\t\tINNER JOIN ( SELECT edua.PERSON_ID, MAX( edua.ENTRY_NUM ) AS num FROM tb_set_edu_deg edua GROUP BY edua.PERSON_ID ) deuMax ON deuMax.num = edu.ENTRY_NUM\n"
				+ "\t\t\tWHERE\n" + "\t\t\t\tedu.del_flag = '0' \n" + "\t\t\t\tAND edu.PERSON_ID = deuMax.PERSON_ID \n"
				+ "\t\t\t) eduFin ON t.id = eduFin.PERSON_ID\n" + "\t\t\tLEFT JOIN (\n" + "\t\t\tSELECT\n"
				+ "\t\t\t\tpost.PERSON_ID,\n" + "\t\t\t\tdic.CODE_NAME POST_NAME  \n" + "\t\t\tFROM\n"
				+ "\t\t\t\ttb_set_adm_post post\n"
				+ "\t\t\t\tINNER JOIN ( SELECT posta.PERSON_ID, MAX( posta.ENTRY_NUM ) AS num FROM tb_set_adm_post posta GROUP BY posta.PERSON_ID ) postMax ON postMax.num = post.ENTRY_NUM \n"
				+ "\t\t\t\tAND post.PERSON_ID = postMax.PERSON_ID INNER JOIN tb_dic_code_def dic ON dic.DIC_ID = 'VX' \n"
				+ "\t\t\t\tAND post.POST_NAME = dic.DIC_CODE \n" + "\t\t\t) postFin ON t.id = postFin.PERSON_ID \n"
				+ "\t\tORDER BY\n" + "\t\t\tt.seq ) t ";*/
		String sql;
		if("2".equals(res.get("type")) && orgGunStatic>=Integer.parseInt(code.substring(1,5))){
			sql = "SELECT DISTINCT\n" +
					"\t*\n" +
					"FROM\n" +
					"\t(\n" +
					"\t\tSELECT\n" +
					"\t\t\tt.ID,\n" +
					"\t\t\tt.PERSON_TYPE,\n" +
					"\t\t\tt.seq,\n" +
					"\t\t\tt.AGE age,\n" +
					"\t\t\tt.NAME name,\n" +
					"\t\t\tdept.DEPT_NAME dept,\n" +
					"\t\t\t(\n" +
					"\t\t\t\tCASE\n" +
					"\t\t\t\tWHEN t.SEX = '1' THEN\n" +
					"\t\t\t\t\t'男'\n" +
					"\t\t\t\tWHEN t.SEX = '2' THEN\n" +
					"\t\t\t\t\t'女'\n" +
					"\t\t\t\tEND\n" +
					"\t\t\t) AS sex,\n" +
					"\t\t\tpostFin.POST_NAME postName,\n" +
					"\t\t\tpolFin.pol_sta_name mm,\n" +
					"\t\t\tt.DEPARTMENT AS UNIT_NAME,\n" +
					"\t\t\t(\n" +
					"\t\t\t\tCASE\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '1' THEN\n" +
					"\t\t\t\t\t'正研'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '2' THEN\n" +
					"\t\t\t\t\t'副研'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '3' THEN\n" +
					"\t\t\t\t\t'中级'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '5'\n" +
					"\t\t\t\tOR SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '4' THEN\n" +
					"\t\t\t\t\t'初级'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '9' THEN\n" +
					"\t\t\t\t\t'见习'\n" +
					"\t\t\t\tELSE\n" +
					"\t\t\t\t\t'无资格'\n" +
					"\t\t\t\tEND\n" +
					"\t\t\t) AS post,\n" +
					"\t\t\t(\n" +
					"\t\t\t\tCASE\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '1' THEN\n" +
					"\t\t\t\t\t'正研'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '2' THEN\n" +
					"\t\t\t\t\t'副研'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '3' THEN\n" +
					"\t\t\t\t\t'中级'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '5'\n" +
					"\t\t\t\tOR SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '4' THEN\n" +
					"\t\t\t\t\t'初级'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '9' THEN\n" +
					"\t\t\t\t\t'见习'\n" +
					"\t\t\t\tELSE\n" +
					"\t\t\t\t\t'无资格'\n" +
					"\t\t\t\tEND\n" +
					"\t\t\t) AS stech,\n" +
					"\t\t\t(\n" +
					"\t\t\t\tCASE\n" +
					"\t\t\t\tWHEN t.SEX = '1' THEN\n" +
					"\t\t\t\t\t'男'\n" +
					"\t\t\t\tWHEN t.SEX = '2' THEN\n" +
					"\t\t\t\t\t'女'\n" +
					"\t\t\t\tEND\n" +
					"\t\t\t) AS ssex,\n" +
					"\t\t\tCASE\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) <= 4 THEN\n" +
					"\t\t\t'高中及以下'\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 5\n" +
					"\t\tOR SUBSTR(eduFin.education, 1, 1) = 6 THEN\n" +
					"\t\t\t'中专'\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 7 THEN\n" +
					"\t\t\t'专科'\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 8 THEN\n" +
					"\t\t\t'本科'\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 9 THEN\n" +
					"\t\t\t'研究生'\n" +
					"\t\tELSE\n" +
					"\t\t\t'无学历'\n" +
					"\t\tEND AS sedu,\n" +
					"\t\tCASE\n" +
					"\tWHEN SUBSTR(eduFin.degree, 1, 1) = 2 THEN\n" +
					"\t\t'博士'\n" +
					"\tWHEN SUBSTR(eduFin.degree, 1, 1) = 3 THEN\n" +
					"\t\t'硕士'\n" +
					"\tWHEN SUBSTR(eduFin.degree, 1, 1) = 4 THEN\n" +
					"\t\t'学士'\n" +
					"\tELSE\n" +
					"\t\t'无学位'\n" +
					"\tEND AS sdegree,\n" +
					"\tCASE\n" +
					"WHEN SUBSTR(eduFin.major, 1, 4) = '0712' THEN\n" +
					"\t'信息技术类'\n" +
					"WHEN SUBSTR(eduFin.major, 1, 4) = '0707' THEN\n" +
					"\t'地球科学及其他专业'\n" +
					"WHEN SUBSTR(eduFin.major, 1, 4) = '0709' THEN\n" +
					"\t'大气科学'\n" +
					"ELSE\n" +
					"\t'其他'\n" +
					"END AS smajor,\n" +
					" CASE\n" +
					"WHEN t.AGE <= 35 THEN\n" +
					"\t'35以下'\n" +
					"WHEN t.AGE > 35\n" +
					"AND t.AGE <= 40 THEN\n" +
					"\t'36-40'\n" +
					"WHEN t.AGE > 40\n" +
					"AND t.AGE <= 45 THEN\n" +
					"\t'41-45'\n" +
					"WHEN t.AGE >= 46\n" +
					"AND t.AGE <= 50 THEN\n" +
					"\t'46-50'\n" +
					"WHEN t.AGE > 50\n" +
					"AND t.AGE <= 55 THEN\n" +
					"\t'51-55'\n" +
					"ELSE\n" +
					"\t'56及以上'\n" +
					"END AS sage,\n" +
					" CASE\n" +
					"WHEN t.NATION = '01' THEN\n" +
					"\t'汉族'\n" +
					"ELSE\n" +
					"\t'少数民族'\n" +
					"END AS snation\n" +
					"FROM\n" +
					"(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\t*\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tDEPARTMENT = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tdept.id,\n" +
					"\t\tdept.DEPT_NAME\n" +
					"\tFROM\n" +
					"\t\ttb_dic_organization org\n" +
					"\tINNER JOIN tb_dic_dept dept ON org.id = dept.p_id\n" +
					"\tWHERE\n" +
					"\t\torg.ID = '"+code+"'\n" +
					") dept ON t.DEPARTMENT = dept.ID\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tbi.PERSON_ID,\n" +
					"\t\tbi.TEC_QUA\n" +
					"\tFROM\n" +
					"\t\ttb_set_prof_tech_post bi\n" +
					"\tINNER JOIN (\n" +
					"\t\tSELECT\n" +
					"\t\t\tb.PERSON_ID,\n" +
					"\t\t\tMAX(b.ENTRY_NUM) AS num\n" +
					"\t\tFROM\n" +
					"\t\t\ttb_set_prof_tech_post b,(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\tid,\n" +
					"\t\t\t\t\tNAME\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tDEPARTMENT = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t  WHERE\n" +
					"\t\t\t\t\tt.id = b.person_id \n" +
					"\t\tGROUP BY\n" +
					"\t\t\tb.PERSON_ID\n" +
					"\t) bt ON bt.num = bi.ENTRY_NUM\n" +
					"\tAND bi.PERSON_ID = bt.PERSON_ID\n" +
					") b ON t.id = b.PERSON_ID\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tpol.PERSON_ID,\n" +
					"\t\tdic.CODE_NAME pol_sta_name\n" +
					"\tFROM\n" +
					"\t\ttb_set_pol_sta pol\n" +
					"\tINNER JOIN (\n" +
					"\t\tSELECT\n" +
					"\t\t\tpola.PERSON_ID,\n" +
					"\t\t\tMAX(pola.ENTRY_NUM) AS num\n" +
					"\t\tFROM\n" +
					"\t\t\ttb_set_pol_sta pola,(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\tid,\n" +
					"\t\t\t\t\tNAME\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tDEPARTMENT = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t WHERE\n" +
					"\t\t\t\t\tt.id = pola.person_id \n" +
					"\t\tGROUP BY\n" +
					"\t\t\tpola.PERSON_ID\n" +
					"\t) polMax ON polMax.num = pol.ENTRY_NUM\n" +
					"\tAND pol.PERSON_ID = polMax.PERSON_ID\n" +
					"\tINNER JOIN tb_dic_code_def dic ON dic.DIC_ID = 'BU'\n" +
					"\tAND pol.pol_sta_name = dic.DIC_CODE\n" +
					") polFin ON t.id = polFin.PERSON_ID\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tedu.PERSON_ID,\n" +
					"\t\tedu.education,\n" +
					"\t\tedu.degree,\n" +
					"\t\tedu.major\n" +
					"\tFROM\n" +
					"\t\ttb_set_edu_deg edu\n" +
					"\tINNER JOIN (\n" +
					"\t\tSELECT\n" +
					"\t\t\tedua.PERSON_ID,\n" +
					"\t\t\tMAX(edua.ENTRY_NUM) AS num\n" +
					"\t\tFROM\n" +
					"\t\t\ttb_set_edu_deg edua,(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\tid,\n" +
					"\t\t\t\t\tNAME\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tDEPARTMENT = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t WHERE\n" +
					"\t\t\t\t\tt.id = edua.person_id \n" +
					"\t\tGROUP BY\n" +
					"\t\t\tedua.PERSON_ID\n" +
					"\t) deuMax ON deuMax.num = edu.ENTRY_NUM\n" +
					"\tWHERE\n" +
					"\t\tedu.del_flag = '0'\n" +
					"\tAND edu.PERSON_ID = deuMax.PERSON_ID\n" +
					") eduFin ON t.id = eduFin.PERSON_ID\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tpost.PERSON_ID,\n" +
					"\t\tdic.CODE_NAME POST_NAME\n" +
					"\tFROM\n" +
					"\t\ttb_set_adm_post post\n" +
					"\tINNER JOIN (\n" +
					"\t\tSELECT\n" +
					"\t\t\tposta.PERSON_ID,\n" +
					"\t\t\tMAX(posta.ENTRY_NUM) AS num\n" +
					"\t\tFROM\n" +
					"\t\t\ttb_set_adm_post posta,(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\tid,\n" +
					"\t\t\t\t\tNAME\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tDEPARTMENT = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t\n" +
					"\t\tWHERE\n" +
					"\t\t\tt.id = posta.person_id\n" +
					"\t\tGROUP BY\n" +
					"\t\t\tposta.PERSON_ID\n" +
					"\t) postMax ON postMax.num = post.ENTRY_NUM\n" +
					"\tAND post.PERSON_ID = postMax.PERSON_ID\n" +
					"\tINNER JOIN tb_dic_code_def dic ON dic.DIC_ID = 'VX'\n" +
					"\tAND post.POST_NAME = dic.DIC_CODE\n" +
					") postFin ON t.id = postFin.PERSON_ID\n" +
					"ORDER BY\n" +
					"\tt.seq\n" +
					"\t) t where \n" +
					dataSql;
		}else{
			sql = "SELECT DISTINCT\n" +
					"\t*\n" +
					"FROM\n" +
					"\t(\n" +
					"\t\tSELECT\n" +
					"\t\t\tt.ID,\n" +
					"\t\t\tt.PERSON_TYPE,\n" +
					"\t\t\tt.seq,\n" +
					"\t\t\tt.AGE age,\n" +
					"\t\t\tt.NAME name,\n" +
					"\t\t\tdept.DEPT_NAME dept,\n" +
					"\t\t\t(\n" +
					"\t\t\t\tCASE\n" +
					"\t\t\t\tWHEN t.SEX = '1' THEN\n" +
					"\t\t\t\t\t'男'\n" +
					"\t\t\t\tWHEN t.SEX = '2' THEN\n" +
					"\t\t\t\t\t'女'\n" +
					"\t\t\t\tEND\n" +
					"\t\t\t) AS sex,\n" +
					"\t\t\tpostFin.POST_NAME postName,\n" +
					"\t\t\tpolFin.pol_sta_name mm,\n" +
					"\t\t\tsubstr(t.UNIT_NAME, 1, "+len+") AS UNIT_NAME,\n" +
					"\t\t\t(\n" +
					"\t\t\t\tCASE\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '1' THEN\n" +
					"\t\t\t\t\t'正研'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '2' THEN\n" +
					"\t\t\t\t\t'副研'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '3' THEN\n" +
					"\t\t\t\t\t'中级'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '5'\n" +
					"\t\t\t\tOR SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '4' THEN\n" +
					"\t\t\t\t\t'初级'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '9' THEN\n" +
					"\t\t\t\t\t'见习'\n" +
					"\t\t\t\tELSE\n" +
					"\t\t\t\t\t'无资格'\n" +
					"\t\t\t\tEND\n" +
					"\t\t\t) AS post,\n" +
					"\t\t\t(\n" +
					"\t\t\t\tCASE\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '1' THEN\n" +
					"\t\t\t\t\t'正研'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '2' THEN\n" +
					"\t\t\t\t\t'副研'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '3' THEN\n" +
					"\t\t\t\t\t'中级'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '5'\n" +
					"\t\t\t\tOR SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '4' THEN\n" +
					"\t\t\t\t\t'初级'\n" +
					"\t\t\t\tWHEN SUBSTR(\n" +
					"\t\t\t\t\tb.TEC_QUA,\n" +
					"\t\t\t\t\tLENGTH(b.TEC_QUA),\n" +
					"\t\t\t\t\t1\n" +
					"\t\t\t\t) = '9' THEN\n" +
					"\t\t\t\t\t'见习'\n" +
					"\t\t\t\tELSE\n" +
					"\t\t\t\t\t'无资格'\n" +
					"\t\t\t\tEND\n" +
					"\t\t\t) AS stech,\n" +
					"\t\t\t(\n" +
					"\t\t\t\tCASE\n" +
					"\t\t\t\tWHEN t.SEX = '1' THEN\n" +
					"\t\t\t\t\t'男'\n" +
					"\t\t\t\tWHEN t.SEX = '2' THEN\n" +
					"\t\t\t\t\t'女'\n" +
					"\t\t\t\tEND\n" +
					"\t\t\t) AS ssex,\n" +
					"\t\t\tCASE\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) <= 4 THEN\n" +
					"\t\t\t'高中及以下'\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 5\n" +
					"\t\tOR SUBSTR(eduFin.education, 1, 1) = 6 THEN\n" +
					"\t\t\t'中专'\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 7 THEN\n" +
					"\t\t\t'专科'\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 8 THEN\n" +
					"\t\t\t'本科'\n" +
					"\t\tWHEN SUBSTR(eduFin.education, 1, 1) = 9 THEN\n" +
					"\t\t\t'研究生'\n" +
					"\t\tELSE\n" +
					"\t\t\t'无学历'\n" +
					"\t\tEND AS sedu,\n" +
					"\t\tCASE\n" +
					"\tWHEN SUBSTR(eduFin.degree, 1, 1) = 2 THEN\n" +
					"\t\t'博士'\n" +
					"\tWHEN SUBSTR(eduFin.degree, 1, 1) = 3 THEN\n" +
					"\t\t'硕士'\n" +
					"\tWHEN SUBSTR(eduFin.degree, 1, 1) = 4 THEN\n" +
					"\t\t'学士'\n" +
					"\tELSE\n" +
					"\t\t'无学位'\n" +
					"\tEND AS sdegree,\n" +
					"\tCASE\n" +
					"WHEN SUBSTR(eduFin.major, 1, 4) = '0712' THEN\n" +
					"\t'信息技术类'\n" +
					"WHEN SUBSTR(eduFin.major, 1, 4) = '0707' THEN\n" +
					"\t'地球科学及其他专业'\n" +
					"WHEN SUBSTR(eduFin.major, 1, 4) = '0709' THEN\n" +
					"\t'大气科学'\n" +
					"ELSE\n" +
					"\t'其他'\n" +
					"END AS smajor,\n" +
					" CASE\n" +
					"WHEN t.AGE <= 35 THEN\n" +
					"\t'35以下'\n" +
					"WHEN t.AGE > 35\n" +
					"AND t.AGE <= 40 THEN\n" +
					"\t'36-40'\n" +
					"WHEN t.AGE > 40\n" +
					"AND t.AGE <= 45 THEN\n" +
					"\t'41-45'\n" +
					"WHEN t.AGE >= 46\n" +
					"AND t.AGE <= 50 THEN\n" +
					"\t'46-50'\n" +
					"WHEN t.AGE > 50\n" +
					"AND t.AGE <= 55 THEN\n" +
					"\t'51-55'\n" +
					"ELSE\n" +
					"\t'56及以上'\n" +
					"END AS sage,\n" +
					" CASE\n" +
					"WHEN t.NATION = '01' THEN\n" +
					"\t'汉族'\n" +
					"ELSE\n" +
					"\t'少数民族'\n" +
					"END AS snation\n" +
					"FROM\n" +
					"(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\t*\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tsubstr(UNIT_NAME,1,"+len+") = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tdept.id,\n" +
					"\t\tdept.DEPT_NAME\n" +
					"\tFROM\n" +
					"\t\ttb_dic_organization org\n" +
					"\tINNER JOIN tb_dic_dept dept ON org.id = dept.p_id\n" +
					"\tWHERE\n" +
					"\t\torg.ID = '"+code+"'\n" +
					") dept ON t.DEPARTMENT = dept.ID\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tbi.PERSON_ID,\n" +
					"\t\tbi.TEC_QUA\n" +
					"\tFROM\n" +
					"\t\ttb_set_prof_tech_post bi\n" +
					"\tINNER JOIN (\n" +
					"\t\tSELECT\n" +
					"\t\t\tb.PERSON_ID,\n" +
					"\t\t\tMAX(b.ENTRY_NUM) AS num\n" +
					"\t\tFROM\n" +
					"\t\t\ttb_set_prof_tech_post b,(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\tid,\n" +
					"\t\t\t\t\tNAME\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tsubstr(UNIT_NAME,1,"+len+") = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t  WHERE\n" +
					"\t\t\t\t\tt.id = b.person_id \n" +
					"\t\tGROUP BY\n" +
					"\t\t\tb.PERSON_ID\n" +
					"\t) bt ON bt.num = bi.ENTRY_NUM\n" +
					"\tAND bi.PERSON_ID = bt.PERSON_ID\n" +
					") b ON t.id = b.PERSON_ID\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tpol.PERSON_ID,\n" +
					"\t\tdic.CODE_NAME pol_sta_name\n" +
					"\tFROM\n" +
					"\t\ttb_set_pol_sta pol\n" +
					"\tINNER JOIN (\n" +
					"\t\tSELECT\n" +
					"\t\t\tpola.PERSON_ID,\n" +
					"\t\t\tMAX(pola.ENTRY_NUM) AS num\n" +
					"\t\tFROM\n" +
					"\t\t\ttb_set_pol_sta pola,(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\tid,\n" +
					"\t\t\t\t\tNAME\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tsubstr(UNIT_NAME,1,"+len+") = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t WHERE\n" +
					"\t\t\t\t\tt.id = pola.person_id \n" +
					"\t\tGROUP BY\n" +
					"\t\t\tpola.PERSON_ID\n" +
					"\t) polMax ON polMax.num = pol.ENTRY_NUM\n" +
					"\tAND pol.PERSON_ID = polMax.PERSON_ID\n" +
					"\tINNER JOIN tb_dic_code_def dic ON dic.DIC_ID = 'BU'\n" +
					"\tAND pol.pol_sta_name = dic.DIC_CODE\n" +
					") polFin ON t.id = polFin.PERSON_ID\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tedu.PERSON_ID,\n" +
					"\t\tedu.education,\n" +
					"\t\tedu.degree,\n" +
					"\t\tedu.major\n" +
					"\tFROM\n" +
					"\t\ttb_set_edu_deg edu\n" +
					"\tINNER JOIN (\n" +
					"\t\tSELECT\n" +
					"\t\t\tedua.PERSON_ID,\n" +
					"\t\t\tMAX(edua.ENTRY_NUM) AS num\n" +
					"\t\tFROM\n" +
					"\t\t\ttb_set_edu_deg edua,(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\tid,\n" +
					"\t\t\t\t\tNAME\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tsubstr(UNIT_NAME,1,"+len+") = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t WHERE\n" +
					"\t\t\t\t\tt.id = edua.person_id \n" +
					"\t\tGROUP BY\n" +
					"\t\t\tedua.PERSON_ID\n" +
					"\t) deuMax ON deuMax.num = edu.ENTRY_NUM\n" +
					"\tWHERE\n" +
					"\t\tedu.del_flag = '0'\n" +
					"\tAND edu.PERSON_ID = deuMax.PERSON_ID\n" +
					") eduFin ON t.id = eduFin.PERSON_ID\n" +
					"LEFT JOIN (\n" +
					"\tSELECT\n" +
					"\t\tpost.PERSON_ID,\n" +
					"\t\tdic.CODE_NAME POST_NAME\n" +
					"\tFROM\n" +
					"\t\ttb_set_adm_post post\n" +
					"\tINNER JOIN (\n" +
					"\t\tSELECT\n" +
					"\t\t\tposta.PERSON_ID,\n" +
					"\t\t\tMAX(posta.ENTRY_NUM) AS num\n" +
					"\t\tFROM\n" +
					"\t\t\ttb_set_adm_post posta,(\n" +
					"\t\t\t\tSELECT\n" +
					"\t\t\t\t\tid,\n" +
					"\t\t\t\t\tNAME\n" +
					"\t\t\t\tFROM\n" +
					"\t\t\t\t\ttb_set_person_info\n" +
					"\t\t\t\tWHERE\n" +
					"\t\t\t\t\tsubstr(UNIT_NAME,1,"+len+") = '"+code+"'\n" +
					"\t\t\t\tAND PERSON_TYPE = '"+personType+"'\n" +
					"\t\t\t) t\n" +
					"\t\tWHERE\n" +
					"\t\t\tt.id = posta.person_id\n" +
					"\t\tGROUP BY\n" +
					"\t\t\tposta.PERSON_ID\n" +
					"\t) postMax ON postMax.num = post.ENTRY_NUM\n" +
					"\tAND post.PERSON_ID = postMax.PERSON_ID\n" +
					"\tINNER JOIN tb_dic_code_def dic ON dic.DIC_ID = 'VX'\n" +
					"\tAND post.POST_NAME = dic.DIC_CODE\n" +
					") postFin ON t.id = postFin.PERSON_ID\n" +
					"ORDER BY\n" +
					"\tt.seq\n" +
					"\t) t where \n" +
					dataSql;
		}

		String finalSql = sql+limit;
		return jdbcQueryForList(finalSql,new HashMap<>());
	}

}
