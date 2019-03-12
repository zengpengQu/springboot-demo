package com.cmahrmobile.hr.entity.hrset;

import com.cmahrmobile.hr.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import com.alibaba.fastjson.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:SetRewPun.java</p>
 * <p>Description: 奖励及惩罚子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_REW_PUN")
public class RewPunSet extends BaseEntity<String> implements Serializable {

	public RewPunSet() {
	}
	/**
	 * 类别
	 */
	@Getter
	@Setter
	private String category;
	/**
	 * 奖（惩）名称
	 */
	@Getter
	@Setter
	private String rewPunName;
	/**
	 * 奖（惩）原因
	 */
	@Getter
	@Setter
	private String rewPunReason;
	/**
	 * 奖（惩）时间
	 */
	@Getter
	@Setter
	private Date rewPunTime;
	/**
	 * 奖（惩）批准单位
	 */
	@Getter
	@Setter
	private String approveDepartment;
	/**
	 * 奖（惩）取消情况
	 */
	@Getter
	@Setter
	private String cancelCase;
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
