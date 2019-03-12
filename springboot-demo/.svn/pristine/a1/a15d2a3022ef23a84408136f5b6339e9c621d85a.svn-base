package com.cmahrmobile.hr.entity.hrset;

import com.cmahrmobile.hr.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import com.alibaba.fastjson.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:SetTotalWageBill.java</p>
 * <p>Description: 工资总额子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_TOTAL_WAGE_BILL")
public class TotalWageBillSet extends BaseEntity<String> implements Serializable {

	/**
	 * 年份
	 */
	@Getter
	@Setter
	private Date year;

	/**
	 * 单位名称
	 */
	@Getter
	@Setter
	private String unitName;
	/**
	 * 单位名称
	 */
	@Getter
	@Setter
	private Integer wageMonth;
	/**
	 * 当年人员变动情况
	 */
	@Getter
	@Setter
	private String changeCondition;
	/**
	 * 本年职务工资总和(岗位工资)
	 */
	@Getter
	@Setter
	private String yearDutyWage;
	/**
	 * 本年级别工资总和（薪级工资）
	 */
	@Getter
	@Setter
	private String yearLevelWage;
	/**
	 * 本年国家统一及补贴
	 */
	@Getter
	@Setter
	private String yearCountrySubsidy;
	/**
	 * 本年规范及补贴（绩效工资）
	 */
	@Getter
	@Setter
	private String yearStandardSubsidy;
	/**
	 * 本年改革性补贴
	 */
	@Getter
	@Setter
	private String yearReformSubsidy;
	/**
	 * 本年奖励性补贴及其他
	 */
	@Getter
	@Setter
	private String yearAwardSubsidy;
	/**
	 * 本年一次性奖金
	 */
	@Getter
	@Setter
	private String yearSubsidy;
	/**
	 * 本年工资总额
	 */
	@Getter
	@Setter
	private String yearWageNum;
	/**
	 * 月平均收入（人员）
	 */
	@Getter
	@Setter
	private String aveMonthWage;
	/**
	 * 企业收入
	 */
	@Getter
	@Setter
	private String enterpriseReceipts;
	/**
	 * 人员编号
	 */
	@Setter
	private PersonInfoSet personId;
/*
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BaseSetDef.class)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
	public PersonInfoSet getPersonId() {
		return personId;
	}*/
	/**
	 * 分录编号
	 */
	@Getter
	@Setter
	private String entryNum;
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


	@Transient
	@Override
	public JSONObject getJsonObject() {
		return null;
	}
}
