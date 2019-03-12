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
 * <p>Title:SetTrainWay.java</p>
 * <p>Description: 教育培训子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_TRAIN_WAY")
public class TrainWaySet extends BaseEntity<String> implements Serializable {

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
	 * 培训名称
	 */
	@Getter
	@Setter
	private String trainingName;
	/**
	 * 培训内容
	 */
	@Getter
	@Setter
	private String trainingContent;
	/**
	 * 培训方式
	 */
	@Getter
	@Setter
	private String trainingWay;
	/**
	 * 教育培训类别
	 */
	@Getter
	@Setter
	private String trainingType;

	/**
	 * 培训开始时间
	 */
	@Getter
	@Setter
	private Date trainingStartTime;
	/**
	 * 培训终止时间
	 */
	@Getter
	@Setter
	private Date trainingEndTime;
	/**
	 * 培训期限
	 */
	@Getter
	@Setter
	private String trainingLimit;
	/**
	 * 培训结果
	 */
	@Getter
	@Setter
	private String trainingResult;
	/**
	 * 在学单位
	 */
	@Getter
	@Setter
	private String trainingUnit;
	/**
	 * 组织者标识
	 */
	@Getter
	@Setter
	private String trainingUnitFlag;
	/**
	 * 出国出境培训标识（1-是，0-否）
	 */
	@Getter
	@Setter
	private String goAbroadTrainingFlag;

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
	/**
	 * 备注
	 */
	@Getter
	@Setter
	private String notes;

	@Transient
	@Override
	public JSONObject getJsonObject() {
		return null;
	}
}
