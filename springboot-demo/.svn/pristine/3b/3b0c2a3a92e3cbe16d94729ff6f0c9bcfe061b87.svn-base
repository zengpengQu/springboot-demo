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
 * <p>Title:FamSocRelSet.java</p>
 * <p>Description: 家庭成员子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_SET_FAM_SOC_REL")
public class FamSocRelSet extends BaseEntity<String> implements Serializable {

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


    /*成员姓名*/
    @Getter
    @Setter
    private String name;


    /*与本人关系*/
    @Getter
    @Setter
    private String relationship;


    /*出生日期*/
    @Getter
    @Setter
    private Date birthday;

    /*工作单位*/
    @Getter
    @Setter
    private String unit;

    /*政治面貌*/
    @Getter
    @Setter
    private String politica;

    /*文化程度*/
    @Getter
    @Setter
    private String education;

    /*行政职务*/
    @Getter
    @Setter
    private String post;

    /*行政级别*/
    @Getter
    @Setter
    private String postLevel;

    /*专业技术职务*/
    @Getter
    @Setter
    private String technologyLevel;

    /*备注*/
    @Getter
    @Setter
    private String notes;

    @Transient
    @Override
    public JSONObject getJsonObject() {
        return null;
    }
}
