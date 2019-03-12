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
 * <p>Title:SetWorkesTechLevel.java</p>
 * <p>Description: 工人技术等级子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_WORKES_TECH_LEVEL")
public class WorkesTechLevelSet extends BaseEntity<String> implements Serializable {

	public WorkesTechLevelSet() {
	}

	/**
	 * 工种名称
	 */
	@Getter
	@Setter
	private String workTypeName;
	/**
	 * 获得资格时间
	 */
	@Getter
	@Setter
	private Date getWorkQuaTime;
	/**
	 * 工人技术等级
	 */
	@Getter
	@Setter
	private Date workTecQuaLevel;

	/**
	 * 人员编号
	 */
	@Setter
	private PersonInfoSet personId;

/*	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BaseSetDef.class)
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
