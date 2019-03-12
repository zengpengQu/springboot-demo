package com.cmahrmobile.hr.entity.hrset;

import com.cmahrmobile.hr.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import com.alibaba.fastjson.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:SetTecAward.java</p>
 * <p>Description: 专业技术工作获奖子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_TEC_AWARD")
public class TecAwardSet extends BaseEntity<String> implements Serializable {
	/**
	 * 获奖时间
	 */
	@Getter
	@Setter
	private Date awardTime;
	/**
	 * 获奖项目名称
	 */
	@Getter
	@Setter
	private String awardProject;
	/**
	 * 奖励名称
	 */
	@Getter
	@Setter
	private String awardName;
	/**
	 * 获奖项目中担任角色
	 */
	@Getter
	@Setter
	private String awardProjectRole;
	/**
	 * 证书编号
	 */
	@Getter
	@Setter
	private String certificateNumber;
	/**
	 * 授奖单位
	 */
	@Getter
	@Setter
	private String prizesUnit;
	/**
	 * 授奖单位级别
	 */
	@Getter
	@Setter
	private String prizesUnitLevel;
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
