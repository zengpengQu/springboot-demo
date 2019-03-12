package com.cmahrmobile.hr.entity.hrset;

import com.alibaba.fastjson.JSONObject;
import com.cmahrmobile.hr.base.BaseEntity;
import com.cmahrmobile.hr.util.Jsonable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:SetPolSta.java</p>
 * <p>Description: 政治面貌子集</p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月17</p>
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name = "TB_SET_POL_STA")
public class PolStaSet extends BaseEntity<String> implements Jsonable,Serializable {

	public PolStaSet() {
	}

	/**
	 * 政治面貌
	 */
	@Getter
	@Setter
	private String polStaName;
	/**
	 * 参加时间
	 */
	@Getter
	@Setter
	private Date joinTime;
	/**
	 * 当时所在单位
	 */
	@Getter
	@Setter
	private String noformalJoinUnit;
	/**
	 * 介绍人1姓名
	 */
	@Getter
	@Setter
	private String introducer1;
	/**
	 * 介绍人2姓名
	 */
	@Getter
	@Setter
	private String introducer2;
	/**
	 * 转正时间
	 */
	@Getter
	@Setter
	private Date formalJoinTime;
	/**
	 * 异常类型
	 */
	@Getter
	@Setter
	private String unusualType;
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
	@Getter
	@Setter
	private String personId;

	@Transient
	@Override
	public JSONObject getJsonObject() {
		if (jsonObject == null){
			jsonObject = new JSONObject();
		}
		jsonObject.put("id",id);
		jsonObject.put("polStaName",polStaName);
		jsonObject.put("joinTime",joinTime);
		jsonObject.put("noformalJoinUnit",noformalJoinUnit);
		jsonObject.put("introducer1",introducer1);
		jsonObject.put("introducer2",introducer2);
		jsonObject.put("formalJoinTime",formalJoinTime);
		jsonObject.put("unusualType",unusualType);
		jsonObject.put("notes",notes);
		jsonObject.put("createTime",createTime);
		jsonObject.put("updateTime",updateTime);
		jsonObject.put("entryNum",entryNum);
		jsonObject.put("personId",personId);
		return jsonObject;
	}
}
