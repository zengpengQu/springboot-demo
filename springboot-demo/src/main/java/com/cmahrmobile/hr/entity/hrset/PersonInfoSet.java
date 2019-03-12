package com.cmahrmobile.hr.entity.hrset;

import com.alibaba.fastjson.JSONObject;
import com.cmahrmobile.hr.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:SetPersonInfo.java</p>
 * <p>Description: 人员基本信息主表 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_PERSON_INFO")
public class PersonInfoSet extends BaseEntity<String> implements Serializable {

	public PersonInfoSet() {
	}

	@Id
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 人员类型
	 */
	@Getter
	@Setter
	private String personType;
	/**
	 * 人员姓名
	 */
	@Getter
	@Setter
	private String name;
	/**
	 * 曾用名
	 */
	@Getter
	@Setter
	private String usedName;
	/**
	 * 性别
	 */
	@Getter
	@Setter
	private String sex;
	/**
	 * 单位名称
	 */
	@Getter
	@Setter
	private String unitName;
	/**
	 * 气象部门
	 */
	@Getter
	@Setter
	private String department;

	/**
	 * 出生日期
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	@Getter
	@Setter
	private Date   birthday;
	/**
	 * 籍贯
	 */
	@Getter
	@Setter
	private String nativePlace;
	/**
	 * 出生地
	 */
	@Getter
	@Setter
	private String birthplace;
	/**
	 * 民族代码
	 */
	@Getter
	@Setter
	private String nation;
	/**
	 * 健康情况代码
	 */
	@Getter
	@Setter
	private String healthy;
	/**
	 * 婚姻情况代码
	 */
	@Getter
	@Setter
	private String maritalStatus;
	/**
	 * 个人身份代码
	 */
	@Getter
	@Setter
	private String personalIdentity;

	/**
	 * 参加工作时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	@Getter
	@Setter
	private Date startWorkTime;

	/**
	 * 进入本系统工作时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	@Getter
	@Setter
	private Date joinSystemTime;

	/**
	 * 工龄
	 */
	@Getter
	@Setter
	private Integer workingYears;
	/**
	 * 间断工龄
	 */
	@Getter
	@Setter
	private Integer interruptWorkingYears;
	/**
	 * 户口所在地
	 */
	@Getter
	@Setter
	private String registeredResidence;
	/**
	 * 公民身份证号码
	 */
	@Getter
	@Setter
	private String idNumber;
	/**
	 * 港澳台及外籍人士
	 */
	@Getter
	@Setter
	private String nonChineseNationality;
	/**
	 * 两院院士
	 */
	@Getter
	@Setter
	private String academicians;
	/**
	 * 突贡专家
	 */
	@Getter
	@Setter
	private String oustandingContributionExpert;
	/**
	 * 特贴专家
	 */
	@Getter
	@Setter
	private String specialAllowanceStaff;
	/**
	 * 百千万人才
	 */
	@Getter
	@Setter
	private String millionsTalents;
	/**
	 * 国家科技奖项负责人
	 */
	@Getter
	@Setter
	private String prizeCharge;
	/**
	 * 四个一批人才
	 */
	@Getter
	@Setter
	private String fourOneTalents;
	/**
	 * 博士生导师
	 */
	@Getter
	@Setter
	private String doctoralSupervisor;
	/**
	 * 职业资格
	 */
	@Getter
	@Setter
	private String vocationalQualification;
	/**
	 * 用工形式代码
	 */
	@Getter
	@Setter
	private String employmentForm;
	/**
	 * 进入本系统原因
	 */
	@Getter
	@Setter
	private String joinSystemReason;
	/**
	 * 进入本单位原因
	 */
	@Getter
	@Setter
	private String joinUnitReason;


	/**
	 * 进入本单位时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	@Getter
	@Setter
	private Date   joinUnitTime;
	/**
	 * 基本养老社保号
	 */
	@Getter
	@Setter
	private String endowmentNumber;
	/**
	 * 基本医疗社保号
	 */
	@Getter
	@Setter
	private String medicalNumber;
	/**
	 * 住房公积金账号
	 */
	@Getter
	@Setter
	private String housingFundNumber;
	/**
	 * 享受医疗照顾
	 */
	@Getter
	@Setter
	private String enjoyMedicalCare;
	/**
	 * 在岗状态
	 */
	@Getter
	@Setter
	private String guardStatus;
	/**
	 * 宗教信仰
	 */
	@Getter
	@Setter
	private String faith;
	/**
	 * 备注
	 */
	@Getter
	@Setter
	private String notes;

	/**
	 * 聘干时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	@Getter
	@Setter
	private Date employTime;

	/**
	 * 状态开始时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd",
			timezone = "GMT+8"
	)
	@Getter
	@Setter
	private Date stateStartTime;

	/**
	 * 现工作岗位
	 */
	@Getter
	@Setter
	private String  post;
	/**
	 * 机构代码
	 */
	@Getter
	@Setter
	private String  cropCode;
	/**
	 * 当年人员变动情况
	 */
	@Getter
	@Setter
	private String  changeCondition;
	/**
	 * 当年人员变动情况
	 */
	@Getter
	@Setter
	private String  agricultureCensusRegister;
	/**
	 * 特殊项标识
	 */
	@Getter
	@Setter
	private String  specialFlag;
	/**
	 * 头像
	 */
	@Getter
	@Setter
	private String  avatar;
	/**
	 * 年龄
	 */
	@Getter
	@Setter
	private Integer age;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss",
			timezone = "GMT+8"
	)
	@Getter
	@Setter
	private Date    createTime;
	/**
	 * 更新时间
	 */
	@DateTimeFormat(
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	@JsonFormat(
			pattern = "yyyy-MM-dd HH:mm:ss",
			timezone = "GMT+8"
	)
	@Getter
	@Setter
	private Date    updateTime;
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
