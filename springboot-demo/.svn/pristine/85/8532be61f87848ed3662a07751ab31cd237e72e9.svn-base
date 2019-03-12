package com.cmahrmobile.hr.entity.hrdic;


import com.alibaba.fastjson.JSONObject;
import com.cmahrmobile.hr.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:BaseSetDefVo.java</p>
 * <p>Description: 子集表字段属性目录表 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_BASE_SET_DEF")
public class BaseSetDef extends BaseEntity<String> implements Serializable {


    public BaseSetDef(){}

    @Id
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    /*子集名称*/
    @Getter
    @Setter
    private String setCode;

    /*子集名称*/
    @Getter
    @Setter
    private String setName;

    /*子集类别（A：人员子集 B：单位子集）*/
    @Getter
    @Setter
    private String setType;

    /*子集表名*/
    @Getter
    @Setter
    private String tableName;

    /*子集位置（M：根节点（人员主表、单位主表）S：其他字表）*/
    @Getter
    @Setter
    private String position;

    /*创建时间*/
    @Getter
    @Setter
    private Date createTime;

    /*更新时间*/
    @Getter
    @Setter
    private Date updateTime;


    /*操作人*/
    @Getter
    @Setter
    private String optUser;

    /*删除标志*/
    @Getter
    @Setter
    private Integer delFlag;

   /* @Setter
    private List<BaseSetFieldDef> baseSetFieldDefList;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "baseSetDef", fetch = FetchType.LAZY, targetEntity = BaseSetFieldDef.class)
    public List<BaseSetFieldDef> getBaseSetFieldDefList() {
        return baseSetFieldDefList;
    }*/

    @Transient
    @Override
    public JSONObject getJsonObject() {
        JSONObject job = new JSONObject();
        job.put("setCode",setCode);
        job.put("setName",setName);
        job.put("setType",setType);
        job.put("tableName",tableName);
        return job;
    }
}
