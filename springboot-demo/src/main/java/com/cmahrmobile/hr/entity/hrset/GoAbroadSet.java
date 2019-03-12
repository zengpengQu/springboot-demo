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
 * <p>Title:GoAbroadSet.java</p>
 * <p>Description: 出国出境子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_SET_GO_ABROAD")
public class GoAbroadSet extends BaseEntity<String> implements Serializable {

    @Getter
    @Setter
    private String personId;


    /*分录编码*/
    @Getter
    @Setter
    private String entryNum;


    /*创建时间*/
    @Getter
    @Setter
    private Date createTime;

    /*更新时间*/
    @Getter
    @Setter
    private Date updateTime;

    /*删除标志*/
    @Getter
    @Setter
    private Integer delFlag;

    /*出国（出境）时间*/
    @Getter
    @Setter
    private Date goAbroadTime;

    /*出国（出境）目的*/
    @Getter
    @Setter
    private String goAbroadGoal;


    /*所去（国家）地区*/
    @Getter
    @Setter
    private String goAbroadNation;


    /*所去单位*/
    @Getter
    @Setter
    private String goAbroadDepartment;

    /*团组名称*/
    @Getter
    @Setter
    private String teamName;

    /*经费来源*/
    @Getter
    @Setter
    private String fundSources;


    /*审批单位*/
    @Getter
    @Setter
    private String approvalUnit;

    /*审批文号*/
    @Getter
    @Setter
    private String approvalNumber;

    /*异常情况*/
    @Getter
    @Setter
    private String abnormalCondition;


    @Transient
    @Override
    public JSONObject getJsonObject() {
        return null;
    }
}
