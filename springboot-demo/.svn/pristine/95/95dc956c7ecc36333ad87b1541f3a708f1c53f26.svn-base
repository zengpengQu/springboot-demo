package com.cmahrmobile.hr.entity.hrset;

import com.cmahrmobile.hr.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import com.alibaba.fastjson.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:SetSpecialty.java</p>
 * <p>Description: 语言，计算机等特长子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_SPECIALTY")
public class SpecialtySet extends BaseEntity<String> implements Serializable {

	public SpecialtySet() {
	}
	/**
	 * 特长名称
	 */
	@Getter
	@Setter
	private String specialties;
	/**
	 * 熟练程度（了解<掌握<熟练<精通）
	 */
	@Getter
	@Setter
	private String skillLevel;
	/**
	 * 获何种证书
	 */
	@Getter
	@Setter
	private String certificateName;
	/**
	 * 颁发证书时间
	 */
	@Getter
	@Setter
	private Date certificateTime;
	/**
	 * 颁发证书单位
	 */
	@Getter
	@Setter
	private String certificateUnit;
	/**
	 * 备注
	 */
	@Getter
	@Setter
	private String notes;
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
	 * 分录编号
	 */
	@Getter
	@Setter
	private String entryNum;
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
	@Transient
	@Override
	public JSONObject getJsonObject() {
		return null;
	}
}
