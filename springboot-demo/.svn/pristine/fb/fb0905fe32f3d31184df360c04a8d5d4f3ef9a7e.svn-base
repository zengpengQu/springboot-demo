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
 * <p>Title:CadreResSet.java</p>
 * <p>Description: 后备干部子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_SET_CADRE_RES")
public class CadreResSet extends BaseEntity<String> implements Serializable {

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

    /*呈报单位*/
    @Getter
    @Setter
    private String submitDepartment;

    /*呈报时间*/
    @Getter
    @Setter
    private Date submitTime;

    /*培养目标*/
    @Getter
    @Setter
    private String trainingObjective;


    /*培养级别*/
    @Getter
    @Setter
    private String trainingLevel;

    /*培养措施*/
    @Getter
    @Setter
    private String trainingMeasure;

    /*使用情况*/
    @Getter
    @Setter
    private String serviceCondition;

    /*备注*/
    @Getter
    @Setter
    private String note;

    @Transient
    @Override
    public JSONObject getJsonObject() {
        return null;
    }
}
