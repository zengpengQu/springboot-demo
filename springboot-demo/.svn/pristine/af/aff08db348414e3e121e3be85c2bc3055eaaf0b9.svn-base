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
 * <p>Title:SetSpeCon.java</p>
 * <p>Description: 专家情况子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_SPE_CON")
public class SpeConSet extends BaseEntity<String> implements Serializable {

	public SpeConSet() {
	}
	/**
	 * 专家类别
	 */
	@Getter
	@Setter
	private String specialistType;
	/**
	 * 批准单位名称
	 */
	@Getter
	@Setter
	private String approvedUnit;
	/**
	 * 批准单位级别
	 */
	@Getter
	@Setter
	private String approvedUnitLevel;
	/**
	 * 批准时间
	 */
	@Getter
	@Setter
	private Date approvedTime;
	/**
	 * 享受待遇
	 */
	@Getter
	@Setter
	private Date enjoyTreatment;
	/**
	 * 批准文号
	 */
	@Getter
	@Setter
	private Date approvalNumber;
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
