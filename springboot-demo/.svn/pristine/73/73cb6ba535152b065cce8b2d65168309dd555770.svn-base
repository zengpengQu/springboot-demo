package com.cmahrmobile.hr.dao;

import com.cmahrmobile.hr.base.impl.BaseDaoImpl;
import com.cmahrmobile.hr.entity.hrset.PersonInfoSet;
import com.cmahrmobile.hr.util.OrgCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonInfoDao extends BaseDaoImpl<PersonInfoSet, String> {

    @Autowired
    OrgCodeUtil orgCodeUtil;

    private int orgGunStatic = 155;

    /**
     * 机构标志位
     */
    private String orgType = "1";

    public List<PersonInfoSet> findAllByDept(String dept) {
        Map<String, Object> params = new HashMap<>();
        String sql = "from PersonInfoSet t where t.department = :department";
        params.put("department", dept);
        return jpaFind(sql, params);
    }


    /**
     * 通过机构或部门类型编码加载花名册数据
     *
     * @param orgOrDeptId
     * @return List
     */
    public List<Map<String, Object>> loadRosterPerson(String orgOrDeptId, String personType, String page) {
        Map<String, String> res = orgCodeUtil.dealWithOrgData(orgOrDeptId);
        String code = res.get("code");
        StringBuffer sqlBuffer = new StringBuffer();
        Map<String, Object> map = new HashMap<>(2);
        int pageSize = 20;
        int startSize = 0;
        if (!StringUtils.isEmpty(page)) {
            int pages = Integer.parseInt(page);
            startSize = pageSize * pages;
        }
        int orgCodeLen = code.length();
        map.put("orgOrDeptId", code);
        map.put("personType", personType);
        map.put("page", startSize);
        map.put("pageSize", pageSize);
        if ("2".equals(res.get("type")) && orgGunStatic >= Integer.parseInt(code.substring(1, 5))) {
            sqlBuffer.append("SELECT DISTINCT\n" +
                    "\tt.ID,\n" +
                    "\tt.AGE age,\n" +
                    "\tt.SEQ,\n" +
                    "\tt.NAME name,\n" +
                    "\tt.UNIT_NAME,\n" +
                    "\tdept.DEPT_NAME dept,\n" +
                    "\tt.DEPARTMENT,\n" +
                    "\t(\n" +
                    "\tCASE\n" +
                    "\t\t\t\n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '1' THEN\n" +
                    "\t\t\t'正研' \n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '2' THEN\n" +
                    "\t\t\t'副研' \n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '3' THEN\n" +
                    "\t\t\t\t'中级' \n" +
                    "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '5' \n" +
                    "\t\t\t\tOR SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '4' THEN\n" +
                    "\t\t\t\t'初级' \n" +
                    "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '9' THEN\n" +
                    "\t\t\t\t'见习' ELSE '无资格' \n" +
                    "\t\t\tEND \n" +
                    "\t\t\t) AS post,\n" +
                    "\t\t\t( CASE WHEN t.SEX = '1' THEN '男' WHEN t.SEX = '2' THEN '女' END ) AS sex,\n" +
                    "\t\t\tpolFin.pol_sta_name mm,\n" +
                    "\t\t\tpostFin.POST_NAME postName \n" +
                    "\t\tFROM\n" +
                    "\t\t\t( SELECT * FROM tb_set_person_info WHERE DEPARTMENT = :orgOrDeptId AND PERSON_TYPE = :personType ) t\n" +
                    "\t\t\tLEFT JOIN ( SELECT dept.id, dept.DEPT_NAME FROM tb_dic_organization org INNER JOIN tb_dic_dept dept ON org.id = dept.p_id ) dept ON t.DEPARTMENT = dept.ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tbi.PERSON_ID,\n" +
                    "\t\t\t\tbi.TEC_QUA \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tb.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( b.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_prof_tech_post b,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = b.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tb.PERSON_ID \n" +
                    "\t\t\t\t) postPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_prof_tech_post bi ON bi.PERSON_ID = postPerson.PERSON_ID \n" +
                    "\t\t\t\tAND postPerson.num = bi.ENTRY_NUM \n" +
                    "\t\t\t) b ON t.id = b.PERSON_ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tpol.PERSON_ID,\n" +
                    "\t\t\t\tdic.CODE_NAME pol_sta_name \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tpola.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( pola.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_pol_sta pola,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = pola.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tpola.PERSON_ID \n" +
                    "\t\t\t\t) polaPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_pol_sta pol ON pol.PERSON_ID = polaPerson.PERSON_ID \n" +
                    "\t\t\t\tAND polaPerson.num = pol.ENTRY_NUM\n" +
                    "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'BU' \n" +
                    "\t\t\t\tAND pol.pol_sta_name = dic.DIC_CODE \n" +
                    "\t\t\t) polFin ON t.id = polFin.PERSON_ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tpost.PERSON_ID,\n" +
                    "\t\t\t\tdic.CODE_NAME POST_NAME \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tposta.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( posta.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_adm_post posta,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = posta.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tposta.PERSON_ID \n" +
                    "\t\t\t\t) postaPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_adm_post post ON post.PERSON_ID = postaPerson.PERSON_ID \n" +
                    "\t\t\t\tAND postaPerson.num = post.ENTRY_NUM\n" +
                    "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'VX' \n" +
                    "\t\t\t\tAND post.POST_NAME = dic.DIC_CODE \n" +
                    "\t\t\t) postFin ON t.id = postFin.PERSON_ID \n" +
                    "\t\tORDER BY\n" +
                    "\t\tt.DEPARTMENT,\n" +
                    "\tt.SEQ\n" +
                    "LIMIT :page, :pageSize");
        } else {
            sqlBuffer.append("SELECT DISTINCT\n" +
                    "\tt.ID,\n" +
                    "\tt.AGE age,\n" +
                    "\tt.SEQ,\n" +
                    "\tt.NAME name,\n" +
                    "\tt.UNIT_NAME,\n" +
                    "\tdept.DEPT_NAME dept,\n" +
                    "\tt.DEPARTMENT,\n" +
                    "\t(\n" +
                    "\tCASE\n" +
                    "\t\t\t\n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '1' THEN\n" +
                    "\t\t\t'正研' \n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '2' THEN\n" +
                    "\t\t\t'副研' \n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '3' THEN\n" +
                    "\t\t\t\t'中级' \n" +
                    "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '5' \n" +
                    "\t\t\t\tOR SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '4' THEN\n" +
                    "\t\t\t\t'初级' \n" +
                    "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '9' THEN\n" +
                    "\t\t\t\t'见习' ELSE '无资格' \n" +
                    "\t\t\tEND \n" +
                    "\t\t\t) AS post,\n" +
                    "\t\t\t( CASE WHEN t.SEX = '1' THEN '男' WHEN t.SEX = '2' THEN '女' END ) AS sex,\n" +
                    "\t\t\tpolFin.pol_sta_name mm,\n" +
                    "\t\t\tpostFin.POST_NAME postName \n" +
                    "\t\tFROM\n" +
                    "\t\t\t( SELECT * FROM tb_set_person_info WHERE substr(UNIT_NAME,1," + orgCodeLen + ") = :orgOrDeptId AND PERSON_TYPE = :personType ) t\n" +
                    "\t\t\tLEFT JOIN ( SELECT dept.id, dept.DEPT_NAME FROM tb_dic_organization org INNER JOIN tb_dic_dept dept ON org.id = dept.p_id ) dept ON t.DEPARTMENT = dept.ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tbi.PERSON_ID,\n" +
                    "\t\t\t\tbi.TEC_QUA \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tb.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( b.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_prof_tech_post b,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1," + orgCodeLen + ") = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = b.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tb.PERSON_ID \n" +
                    "\t\t\t\t) postPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_prof_tech_post bi ON bi.PERSON_ID = postPerson.PERSON_ID \n" +
                    "\t\t\t\tAND postPerson.num = bi.ENTRY_NUM \n" +
                    "\t\t\t) b ON t.id = b.PERSON_ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tpol.PERSON_ID,\n" +
                    "\t\t\t\tdic.CODE_NAME pol_sta_name \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tpola.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( pola.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_pol_sta pola,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1," + orgCodeLen + ") = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = pola.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tpola.PERSON_ID \n" +
                    "\t\t\t\t) polaPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_pol_sta pol ON pol.PERSON_ID = polaPerson.PERSON_ID \n" +
                    "\t\t\t\tAND polaPerson.num = pol.ENTRY_NUM\n" +
                    "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'BU' \n" +
                    "\t\t\t\tAND pol.pol_sta_name = dic.DIC_CODE \n" +
                    "\t\t\t) polFin ON t.id = polFin.PERSON_ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tpost.PERSON_ID,\n" +
                    "\t\t\t\tdic.CODE_NAME POST_NAME \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tposta.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( posta.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_adm_post posta,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1," + orgCodeLen + ") = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = posta.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tposta.PERSON_ID \n" +
                    "\t\t\t\t) postaPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_adm_post post ON post.PERSON_ID = postaPerson.PERSON_ID \n" +
                    "\t\t\t\tAND postaPerson.num = post.ENTRY_NUM\n" +
                    "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'VX' \n" +
                    "\t\t\t\tAND post.POST_NAME = dic.DIC_CODE \n" +
                    "\t\t\t) postFin ON t.id = postFin.PERSON_ID \n" +
                    "\t\tORDER BY\n" +
                    "\t\tt.DEPARTMENT,\n" +
                    "\tt.SEQ\n" +
                    "LIMIT :page, :pageSize");
        }
        return jdbcQueryForList(sqlBuffer.toString(), map);
    }

    /**
     * 加载花名册人员详细信息通过personId
     *
     * @param personId
     * @return list
     */
    public List<Map<String, Object>> loadPersonDataWithPersonId(String personId) {

        Map<String, Object> map = new HashMap<>(2);
        map.put("personID", personId);
        StringBuffer buffer = new StringBuffer("SELECT\n" +
                "\tperson.id personId,\n" +
                "\tperson.NAME personName,\n" +
                "\torg.ORG_NAME orgName,\n" +
                "\tdept.DEPT_NAME deptName,\n" +
                "\t( CASE WHEN person.SEX = '1' THEN '男' WHEN person.SEX = '2' THEN '女' END ) AS sex,\n" +
                "\tperson.AGE,\n" +
                "\tdic.CODE_NAME nationName,\n" +
                "\tdistrist.DISTRICT_NAME districtName,\n" +
                "\teduFin.graduate_school graduateSchool,\n" +
                "\teduFin.education,\n" +
                "\teduFin.degree,\n" +
                "\teduFin.major,\n" +
                "\t(\n" +
                "\tCASE\n" +
                "\t\t\t\n" +
                "\t\t\tWHEN SUBSTR( tec.TEC_QUA, LENGTH( tec.TEC_QUA ), 1 ) = '1' THEN\n" +
                "\t\t\t'正研' \n" +
                "\t\t\tWHEN SUBSTR( tec.TEC_QUA, LENGTH( tec.TEC_QUA ), 1 ) = '2' THEN\n" +
                "\t\t\t'副研' \n" +
                "\t\t\tWHEN SUBSTR( tec.TEC_QUA, LENGTH( tec.TEC_QUA ), 1 ) = '3' THEN\n" +
                "\t\t\t'中级' \n" +
                "\t\t\tWHEN SUBSTR( tec.TEC_QUA, LENGTH( tec.TEC_QUA ), 1 ) = '5' \n" +
                "\t\t\tOR SUBSTR( tec.TEC_QUA, LENGTH( tec.TEC_QUA ), 1 ) = '4' THEN\n" +
                "\t\t\t\t'初级' \n" +
                "\t\t\t\tWHEN SUBSTR( tec.TEC_QUA, LENGTH( tec.TEC_QUA ), 1 ) = '9' THEN\n" +
                "\t\t\t\t'见习' ELSE '无资格' \n" +
                "\t\t\tEND \n" +
                "\t\t\t) AS post,\n" +
                "\t\t\tpolFin.polName \n" +
                "\t\tFROM\n" +
                "\t\t\ttb_set_person_info person\n" +
                "\t\t\tLEFT JOIN tb_dic_organization org ON person.UNIT_NAME = org.ID\n" +
                "\t\t\tLEFT JOIN tb_dic_dept dept ON person.DEPARTMENT = dept.ID\n" +
                "\t\t\tLEFT JOIN tb_dic_district distrist ON person.NATIVE_PLACE = distrist.ID\n" +
                "\t\t\tLEFT JOIN (\n" +
                "\t\t\tSELECT\n" +
                "\t\t\t\tedu.PERSON_ID,\n" +
                "\t\t\t\tedu.graduate_school,\n" +
                "\t\t\t\tdic.CODE_NAME education,\n" +
                "\t\t\t\tdica.CODE_NAME degree,\n" +
                "\t\t\t\tdicb.CODE_NAME major \n" +
                "\t\t\tFROM\n" +
                "\t\t\t\t(\n" +
                "\t\t\t\tSELECT\n" +
                "\t\t\t\t\tedua.PERSON_ID,\n" +
                "\t\t\t\t\tMAX( edua.ENTRY_NUM ) AS num \n" +
                "\t\t\t\tFROM\n" +
                "\t\t\t\t\ttb_set_edu_deg edua,\n" +
                "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE id =:personID ) t \n" +
                "\t\t\t\tWHERE\n" +
                "\t\t\t\t\tt.id = edua.person_id \n" +
                "\t\t\t\tGROUP BY\n" +
                "\t\t\t\t\tedua.PERSON_ID \n" +
                "\t\t\t\t) eduaPerson\n" +
                "\t\t\t\tLEFT JOIN tb_set_edu_deg edu ON edu.PERSON_ID = eduaPerson.PERSON_ID \n" +
                "\t\t\t\tAND edu.del_flag = '0' \n" +
                "\t\t\t\tAND eduaPerson.num = edu.ENTRY_NUM\n" +
                "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'WL' \n" +
                "\t\t\t\tAND edu.education = dic.DIC_CODE\n" +
                "\t\t\t\tLEFT JOIN tb_dic_code_def dica ON dica.DIC_ID = 'AN' \n" +
                "\t\t\t\tAND edu.degree = dica.DIC_CODE\n" +
                "\t\t\t\tLEFT JOIN tb_dic_code_def dicb ON dicb.DIC_ID = 'AI' \n" +
                "\t\t\t\tAND edu.major = dicb.DIC_CODE \n" +
                "\t\t\t) eduFin ON person.id = eduFin.PERSON_ID\n" +
                "\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'AE' \n" +
                "\t\t\tAND person.NATION = dic.dic_code\n" +
                "\t\t\tLEFT JOIN (\n" +
                "\t\t\tSELECT\n" +
                "\t\t\t\tbi.ENTRY_NUM,\n" +
                "\t\t\t\tbi.PERSON_ID,\n" +
                "\t\t\t\tbi.TEC_QUA \n" +
                "\t\t\tFROM\n" +
                "\t\t\t\t(\n" +
                "\t\t\t\tSELECT\n" +
                "\t\t\t\t\tb.PERSON_ID,\n" +
                "\t\t\t\t\tMAX( b.ENTRY_NUM ) AS num \n" +
                "\t\t\t\tFROM\n" +
                "\t\t\t\t\ttb_set_prof_tech_post b,\n" +
                "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE id =:personID ) t \n" +
                "\t\t\t\tWHERE\n" +
                "\t\t\t\t\tt.id = b.person_id \n" +
                "\t\t\t\tGROUP BY\n" +
                "\t\t\t\t\tb.PERSON_ID \n" +
                "\t\t\t\t) postPerson\n" +
                "\t\t\t\tLEFT JOIN tb_set_prof_tech_post bi ON bi.PERSON_ID = postPerson.PERSON_ID \n" +
                "\t\t\t\tAND bi.del_flag = '0' \n" +
                "\t\t\t\tAND postPerson.num = bi.ENTRY_NUM \n" +
                "\t\t\t) tec ON person.id = tec.PERSON_ID\n" +
                "\t\t\tLEFT JOIN (\n" +
                "\t\t\tSELECT\n" +
                "\t\t\t\tpol.PERSON_ID,\n" +
                "\t\t\t\tdic.CODE_NAME polName \n" +
                "\t\t\tFROM\n" +
                "\t\t\t\t(\n" +
                "\t\t\t\tSELECT\n" +
                "\t\t\t\t\tpola.PERSON_ID,\n" +
                "\t\t\t\t\tMAX( pola.ENTRY_NUM ) AS num \n" +
                "\t\t\t\tFROM\n" +
                "\t\t\t\t\ttb_set_pol_sta pola,\n" +
                "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE id =:personID ) t \n" +
                "\t\t\t\tWHERE\n" +
                "\t\t\t\t\tt.id = pola.person_id \n" +
                "\t\t\t\tGROUP BY\n" +
                "\t\t\t\t\tpola.PERSON_ID \n" +
                "\t\t\t\t) polaPerson\n" +
                "\t\t\t\tLEFT JOIN tb_set_pol_sta pol ON pol.PERSON_ID = polaPerson.PERSON_ID \n" +
                "\t\t\t\tAND pol.del_flag = '0' \n" +
                "\t\t\t\tAND polaPerson.num = pol.ENTRY_NUM\n" +
                "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'BU' \n" +
                "\t\t\t\tAND pol.pol_sta_name = dic.DIC_CODE \n" +
                "\t\t\t) polFin ON person.id = polFin.PERSON_ID \n" +
                "\t\tWHERE\n" +
                "\t\tperson.DEL_FLAG = '0' \n" +
                "\tAND person.ID =:personID");
        return jdbcQueryForList(buffer.toString(), map);
    }

    /**
     * 模糊搜索人员数据
     *
     * @param personName
     * @return List
     */
    public List<Map<String, Object>> loadPersonDataWithName(String personName, String orgId, String personType, String page) {
        Map<String, String> res = orgCodeUtil.dealWithOrgData(orgId);
        String code = res.get("code");
        Map<String, Object> map = new HashMap<>(2);
        int pageSize = 20;
        int startSize = 0;
        if (!StringUtils.isEmpty(page)) {
            int pages = Integer.parseInt(page);
            startSize = pageSize * pages;
        }
        int orgIdLen = code.length();
        map.put("orgOrDeptId", code);
        map.put("personType", personType);
        map.put("page", startSize);
        map.put("pageSize", pageSize);
        map.put("likeName", "%" + personName + "%");
        StringBuffer buffer = new StringBuffer();
        if ("2".equals(res.get("type")) && orgGunStatic >= Integer.parseInt(code.substring(1, 5))) {
            buffer.append("SELECT DISTINCT\n" +
                    "\tt.ID,\n" +
                    "\tt.AGE age,\n" +
                    "\tt.SEQ,\n" +
                    "\tt.NAME name,\n" +
                    "\tt.UNIT_NAME,\n" +
                    "\tdept.DEPT_NAME dept,\n" +
                    "\tt.DEPARTMENT,\n" +
                    "\t(\n" +
                    "\tCASE\n" +
                    "\t\t\t\n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '1' THEN\n" +
                    "\t\t\t'正研' \n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '2' THEN\n" +
                    "\t\t\t'副研' \n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '3' THEN\n" +
                    "\t\t\t\t'中级' \n" +
                    "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '5' \n" +
                    "\t\t\t\tOR SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '4' THEN\n" +
                    "\t\t\t\t'初级' \n" +
                    "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '9' THEN\n" +
                    "\t\t\t\t'见习' ELSE '无资格' \n" +
                    "\t\t\tEND \n" +
                    "\t\t\t) AS post,\n" +
                    "\t\t\t( CASE WHEN t.SEX = '1' THEN '男' WHEN t.SEX = '2' THEN '女' END ) AS sex,\n" +
                    "\t\t\tpolFin.pol_sta_name mm,\n" +
                    "\t\t\tpostFin.POST_NAME postName \n" +
                    "\t\tFROM\n" +
                    "\t\t\t( SELECT * FROM tb_set_person_info WHERE DEPARTMENT = :orgOrDeptId AND PERSON_TYPE = :personType ) t\n" +
                    "\t\t\tLEFT JOIN ( SELECT dept.id, dept.DEPT_NAME FROM tb_dic_organization org INNER JOIN tb_dic_dept dept ON org.id = dept.p_id ) dept ON t.DEPARTMENT = dept.ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tbi.PERSON_ID,\n" +
                    "\t\t\t\tbi.TEC_QUA \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tb.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( b.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_prof_tech_post b,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = b.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tb.PERSON_ID \n" +
                    "\t\t\t\t) postPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_prof_tech_post bi ON bi.PERSON_ID = postPerson.PERSON_ID \n" +
                    "\t\t\t\tAND postPerson.num = bi.ENTRY_NUM \n" +
                    "\t\t\t) b ON t.id = b.PERSON_ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tpol.PERSON_ID,\n" +
                    "\t\t\t\tdic.CODE_NAME pol_sta_name \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tpola.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( pola.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_pol_sta pola,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = pola.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tpola.PERSON_ID \n" +
                    "\t\t\t\t) polaPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_pol_sta pol ON pol.PERSON_ID = polaPerson.PERSON_ID \n" +
                    "\t\t\t\tAND polaPerson.num = pol.ENTRY_NUM\n" +
                    "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'BU' \n" +
                    "\t\t\t\tAND pol.pol_sta_name = dic.DIC_CODE \n" +
                    "\t\t\t) polFin ON t.id = polFin.PERSON_ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tpost.PERSON_ID,\n" +
                    "\t\t\t\tdic.CODE_NAME POST_NAME \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tposta.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( posta.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_adm_post posta,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE DEPARTMENT = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = posta.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tposta.PERSON_ID \n" +
                    "\t\t\t\t) postaPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_adm_post post ON post.PERSON_ID = postaPerson.PERSON_ID \n" +
                    "\t\t\t\tAND postaPerson.num = post.ENTRY_NUM\n" +
                    "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'VX' \n" +
                    "\t\t\t\tAND post.POST_NAME = dic.DIC_CODE \n" +
                    "\t\t\t) postFin ON t.id = postFin.PERSON_ID \n" +
                    " WHERE t.NAME LIKE :likeName \t\tORDER BY\n" +
                    "\t\tt.DEPARTMENT,\n" +
                    "\tt.SEQ\n" +
                    "LIMIT :page, :pageSize");
        } else {
            buffer.append("SELECT DISTINCT\n" +
                    "\tt.ID,\n" +
                    "\tt.AGE age,\n" +
                    "\tt.SEQ,\n" +
                    "\tt.NAME name,\n" +
                    "\tt.UNIT_NAME,\n" +
                    "\tdept.DEPT_NAME dept,\n" +
                    "\tt.DEPARTMENT,\n" +
                    "\t(\n" +
                    "\tCASE\n" +
                    "\t\t\t\n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '1' THEN\n" +
                    "\t\t\t'正研' \n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '2' THEN\n" +
                    "\t\t\t'副研' \n" +
                    "\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '3' THEN\n" +
                    "\t\t\t\t'中级' \n" +
                    "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '5' \n" +
                    "\t\t\t\tOR SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '4' THEN\n" +
                    "\t\t\t\t'初级' \n" +
                    "\t\t\t\tWHEN SUBSTR( b.TEC_QUA, LENGTH( b.TEC_QUA ), 1 ) = '9' THEN\n" +
                    "\t\t\t\t'见习' ELSE '无资格' \n" +
                    "\t\t\tEND \n" +
                    "\t\t\t) AS post,\n" +
                    "\t\t\t( CASE WHEN t.SEX = '1' THEN '男' WHEN t.SEX = '2' THEN '女' END ) AS sex,\n" +
                    "\t\t\tpolFin.pol_sta_name mm,\n" +
                    "\t\t\tpostFin.POST_NAME postName \n" +
                    "\t\tFROM\n" +
                    "\t\t\t( SELECT * FROM tb_set_person_info WHERE substr(UNIT_NAME,1," + orgIdLen + ") = :orgOrDeptId AND PERSON_TYPE = :personType ) t\n" +
                    "\t\t\tLEFT JOIN ( SELECT dept.id, dept.DEPT_NAME FROM tb_dic_organization org INNER JOIN tb_dic_dept dept ON org.id = dept.p_id ) dept ON t.DEPARTMENT = dept.ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tbi.PERSON_ID,\n" +
                    "\t\t\t\tbi.TEC_QUA \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tb.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( b.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_prof_tech_post b,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1," + orgIdLen + ") = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = b.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tb.PERSON_ID \n" +
                    "\t\t\t\t) postPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_prof_tech_post bi ON bi.PERSON_ID = postPerson.PERSON_ID \n" +
                    "\t\t\t\tAND postPerson.num = bi.ENTRY_NUM \n" +
                    "\t\t\t) b ON t.id = b.PERSON_ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tpol.PERSON_ID,\n" +
                    "\t\t\t\tdic.CODE_NAME pol_sta_name \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tpola.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( pola.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_pol_sta pola,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1," + orgIdLen + ") = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = pola.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tpola.PERSON_ID \n" +
                    "\t\t\t\t) polaPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_pol_sta pol ON pol.PERSON_ID = polaPerson.PERSON_ID \n" +
                    "\t\t\t\tAND polaPerson.num = pol.ENTRY_NUM\n" +
                    "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'BU' \n" +
                    "\t\t\t\tAND pol.pol_sta_name = dic.DIC_CODE \n" +
                    "\t\t\t) polFin ON t.id = polFin.PERSON_ID\n" +
                    "\t\t\tLEFT JOIN (\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tpost.PERSON_ID,\n" +
                    "\t\t\t\tdic.CODE_NAME POST_NAME \n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\t(\n" +
                    "\t\t\t\tSELECT\n" +
                    "\t\t\t\t\tposta.PERSON_ID,\n" +
                    "\t\t\t\t\tMAX( posta.ENTRY_NUM ) AS num \n" +
                    "\t\t\t\tFROM\n" +
                    "\t\t\t\t\ttb_set_adm_post posta,\n" +
                    "\t\t\t\t\t( SELECT id, NAME FROM tb_set_person_info WHERE substr(UNIT_NAME,1," + orgIdLen + ") = :orgOrDeptId AND PERSON_TYPE = :personType ) t \n" +
                    "\t\t\t\tWHERE\n" +
                    "\t\t\t\t\tt.id = posta.person_id \n" +
                    "\t\t\t\tGROUP BY\n" +
                    "\t\t\t\t\tposta.PERSON_ID \n" +
                    "\t\t\t\t) postaPerson\n" +
                    "\t\t\t\tLEFT JOIN tb_set_adm_post post ON post.PERSON_ID = postaPerson.PERSON_ID \n" +
                    "\t\t\t\tAND postaPerson.num = post.ENTRY_NUM\n" +
                    "\t\t\t\tLEFT JOIN tb_dic_code_def dic ON dic.DIC_ID = 'VX' \n" +
                    "\t\t\t\tAND post.POST_NAME = dic.DIC_CODE \n" +
                    "\t\t\t) postFin ON t.id = postFin.PERSON_ID \n" +
                    " WHERE t.NAME LIKE :likeName \t\tORDER BY\n" +
                    "\t\tt.DEPARTMENT,\n" +
                    "\tt.SEQ\n" +
                    "LIMIT :page, :pageSize");
        }
        return jdbcQueryForList(buffer.toString(), map);
    }
}
