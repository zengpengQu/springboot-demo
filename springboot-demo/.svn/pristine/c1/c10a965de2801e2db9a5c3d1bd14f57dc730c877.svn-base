package com.cmahrmobile.hr.entity.hrset;

import com.cmahrmobile.hr.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import com.alibaba.fastjson.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:SetRetiredInf.java</p>
 * <p>Description: 离退休基本情况子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_RETIRED_INF")
public class RetiredInfSet extends BaseEntity<String> implements Serializable {

	public RetiredInfSet() {
	}

	/**
	 * 离退类别
	 */
	@Getter
	@Setter
	private String retiredCategory;
	/**
	 * 离（退）休时间
	 */
	@Getter
	@Setter
	private Date retiredTime;
	/**
	 * 离（退）休后享受级别
	 */
	@Getter
	@Setter
	private String retiredEnjoyLevel;
	/**
	 * 离（退）休费支付单位
	 */
	@Getter
	@Setter
	private String pensionPayUnit;
	/**
	 * 离（退）休后管理单位
	 */
	@Getter
	@Setter
	private String retiredManagetUnit;
	/**
	 * 异地安置标志
	 */
	@Getter
	@Setter
	private String relocatedLogo;
	/**
	 * 所在单位属性
	 */
	@Getter
	@Setter
	private String unitProperties;
	/**
	 * 全年基本离退休费
	 */
	@Getter
	@Setter
	private String basicYearPension;
	/**
	 * 全年补贴
	 */
	@Getter
	@Setter
	private String yearSubsidy;
	/**
	 * 退休费比例
	 */
	@Getter
	@Setter
	private String pensionProportion;
	/**
	 * 提高退休费比例
	 */
	@Getter
	@Setter
	private String enhancePenPro;
	/**
	 * 发放月次（离退休费）
	 */
	@Getter
	@Setter
	private Integer payTime;
	/**
	 * 月平均离退休费
	 */
	@Getter
	@Setter
	private String monthlyAvePen;
	/**
	 * 全年离退休费总额
	 */
	@Getter
	@Setter
	private String totalYearPension;
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
