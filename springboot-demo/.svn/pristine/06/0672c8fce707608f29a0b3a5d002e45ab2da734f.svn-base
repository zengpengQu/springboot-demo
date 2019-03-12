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
 * <p>Title:SetWorkersResume.java</p>
 * <p>Description: 工作简历子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_WORKERS_RESUME")
public class WorkersResumeSet extends BaseEntity<String> implements Serializable {


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
	 * 起始时间
	 */
	@Getter
	@Setter
	private Date startTime;
	/**
	 * 终止时间
	 */
	@Getter
	@Setter
	private Date endTime;
	/**
	 * 工龄
	 */
	@Getter
	@Setter
	private Integer workAge;
	/**
	 * 所在单位
	 */
	@Getter
	@Setter
	private String workUnit;
	/**
	 * 从事工作或担任职务
	 */
	@Getter
	@Setter
	private String workContentOrPost;
	/**
	 * 证明人
	 */
	@Getter
	@Setter
	private String vouchers;
	/**
	 * 间断工龄结束日期
	 */
	@Getter
	@Setter
	private Date interruptWorkAgeEndDate;
	/**
	 * 间断工龄开始日期
	 */
	@Getter
	@Setter
	private Date interruptWorkAgeStartDate;
	/**
	 * 间断工龄标识（1-本段经历计算连续工龄；2-本段经历计算间断工龄）
	 */
	@Getter
	@Setter
	private String interruptWorkAgeFlag;
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
