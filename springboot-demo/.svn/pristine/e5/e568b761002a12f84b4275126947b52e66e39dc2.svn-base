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
 * <p>Title:InsuranceSet.java</p>
 * <p>Description: 保险子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_SET_INSURANCE")
public class InsuranceSet extends BaseEntity<String> implements Serializable {

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

    /*变动时间*/
    @Getter
    @Setter
    private Date changeTime;

    /*养老保险*/
    @Getter
    @Setter
    private String endowmentInsurance;

    /*医疗保险*/
    @Getter
    @Setter
    private String medicalInsurance;

    /*失业保险*/
    @Getter
    @Setter
    private String unemploymentInsurance;

    /*工伤保险*/
    @Getter
    @Setter
    private String employmentInjuryInsurance;

    /*生育保险*/
    @Getter
    @Setter
    private String maternityInsurance;

    /*公积金*/
    @Getter
    @Setter
    private String accumulationFund;


    /*五险合计*/
    @Getter
    @Setter
    private String amountInsurance;

    @Transient
    @Override
    public JSONObject getJsonObject() {
        return null;
    }
}
