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
 * <p>Title:SetProfTechPost.java</p>
 * <p>Description: 专业技术职务子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_PROF_TECH_POST")
public class ProfTechPostSet extends BaseEntity<String> implements Serializable {

	public ProfTechPostSet() {
	}
	/**
	 * 专业技术资格名称
	 */
	@Getter
	@Setter
	private String tecQua;

	/**
	 * 取得资格的途径
	 */
	@Getter
	@Setter
	private String tecQuaWay;
	/**
	 * 取得资格的时间
	 */
	@Getter
	@Setter
	private Date tecQuaTime;
	/**
	 * 专业技术职务
	 */
	@Getter
	@Setter
	private String proSkillDuty;
	/**
	 * 聘任开始时间
	 */
	@Getter
	@Setter
	private Date appointStartTime;
	/**
	 * 聘任终止时间
	 */
	@Getter
	@Setter
	private Date appointEndTime;
	/**
	 * 职务聘任文号
	 */
	@Getter
	@Setter
	private String appointFileNum;
	/**
	 * 职务解聘时间
	 */
	@Getter
	@Setter
	private Date dismissalTime;
	/**
	 * 职务解聘文号
	 */
	@Getter
	@Setter
	private String dismissalFileNum;
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
	@Getter
	private String personId;

	@Transient
	@Override
	public JSONObject getJsonObject() {
		return null;
	}
}
