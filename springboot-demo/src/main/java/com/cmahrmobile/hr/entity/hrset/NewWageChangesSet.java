package com.cmahrmobile.hr.entity.hrset;

import com.alibaba.fastjson.JSONObject;
import com.cmahrmobile.hr.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:SetNewWageChanges.java</p>
 * <p>Description: 新工资变动子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_NEW_WAGE_CHANGES")
public class NewWageChangesSet extends BaseEntity<String> implements Serializable {


	/**
	 * 工资序列标识
	 */
	@Getter
	@Setter
	private String wageSequenceFlag;
	/**
	 * 公务员工资职务
	 */
	@Getter
	@Setter
	private String civilServantsWageDuty;
	/**
	 * 公务员工资职务属性（1-领导职务；2-非领导职务）
	 */
	@Getter
	@Setter
	private String civilServantsWageDutyNatur;
	/**
	 * 职务工资
	 */
	@Getter
	@Setter
	private String dutyWage;
	/**
	 * 职务工资级别
	 */
	@Getter
	@Setter
	private String dutyWageLevel;
	/**
	 * 职务级别工资
	 */
	@Getter
	@Setter
	private String dutyLevelWage;
	/**
	 * 职务工资档次
	 */
	@Getter
	@Setter
	private String dutyWageGrade;
	/**
	 * 职员岗位
	 */
	@Getter
	@Setter
	private String officeClerkPosition;
	/**
	 * 职员薪级
	 */
	@Getter
	@Setter
	private String officeClerkWageLevel;
	/**
	 * 职员薪级工资
	 */
	@Getter
	@Setter
	private String officeClerkWageLevelWage;
	/**
	 * 职员岗位工资
	 */
	@Getter
	@Setter
	private String officeClerkPositionWage;
	/**
	 * 专业技术人员岗位
	 */
	@Getter
	@Setter
	private String tecPersonPosition;
	/**
	 * 专业技术人员岗位工资
	 */
	@Getter
	@Setter
	private String tecPersonPositionWage;
	/**
	 * 专业技术人员薪级
	 */
	@Getter
	@Setter
	private String tecPersonWageLevel;
	/**
	 * 专业技术人员薪级工资
	 */
	@Getter
	@Setter
	private String tecPersonWageLevelWage;
	/**
	 * 工人岗位（技术工一至五级，普通工）
	 */
	@Getter
	@Setter
	private String workerPosition;
	/**
	 * 工人岗位工资（技术工一至五级，普通工）
	 */
	@Getter
	@Setter
	private String workerPositionWage;
	/**
	 * 工人薪级
	 */
	@Getter
	@Setter
	private String workerWageLevel;
	/**
	 * 工人薪级工资
	 */
	@Getter
	@Setter
	private String workerWageLevelWage;

	/**
	 * 基本工资
	 */
	@Getter
	@Setter
	private String baseWage;
	/**
	 * 工资职务任职时间
	 */
	@Getter
	@Setter
	private Date wagePostDutyTime;
	/**
	 * 工资职务任职年限
	 */
	@Getter
	@Setter
	private Integer wagePostDutyYearLimit;
	/**
	 * 起薪时间
	 */
	@Getter
	@Setter
	private Date wageStartTime;
	/**
	 * 全年职务工资（岗位工资）
	 */
	@Getter
	@Setter
	private String fullYearPostWage;
	/**
	 * 全年级别工资（薪级工资）
	 */
	@Getter
	@Setter
	private String fullYearLevelWage;
	/**
	 * 全年国家统一津补贴
	 */
	@Getter
	@Setter
	private String fullYearNationalSubsidies;
	/**
	 * 全年规范津补贴（绩效工资）
	 */
	@Getter
	@Setter
	private String fullYearFormalSubsidies;
	/**
	 * 全年改革性补贴
	 */
	@Getter
	@Setter
	private String fullYearReformSubsidies;
	/**
	 * 全年奖励及其它
	 */
	@Getter
	@Setter
	private String fullYearAwardOther;
	/**
	 * 年度一次性奖金
	 */
	@Getter
	@Setter
	private String fullYearOneAward;
	/**
	 * 发放月次
	 */
	@Getter
	@Setter
	private Integer payMonth;
	/**
	 * 月平均工资
	 */
	@Getter
	@Setter
	private String averageMonthlyWage;
	/**
	 * 全年工资总额
	 */
	@Getter
	@Setter
	private String fullYearTotalWage;
	/**
	 * 企业收入
	 */
	@Getter
	@Setter
	private String enterpriseIncome;
	/**
	 * 人员编号
	 */
	@Setter
	private PersonInfoSet personId;

	/*@ManyToOne(fetch = FetchType.LAZY, targetEntity = BaseSetDef.class)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
	public PersonInfoSet getPersonId() {
		return personId;
	}*/
	/**
	 * 创建时间
	 */
	@Getter
	@Setter
	private Date createTime;
	/**
	 * 更新时间
	 */
	@Getter
	@Setter
	private Date updateTime;
	/**
	 * 删除标志
	 */
	@Getter
	@Setter
	private Integer delFlag;
	/**
	 * 注释
	 */
	@Getter
	@Setter
	private String note;
	/**
	 * 分录编号
	 */
	@Getter
	@Setter
	private String entryum;

	@Transient
	@Override
	public JSONObject getJsonObject() {
		return null;
	}
}
