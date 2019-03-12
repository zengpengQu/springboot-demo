package com.cmahrmobile.hr.entity.hrdic;

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
 * <p>Title:DicCodeDef.java</p>
 * <p>Description: 数据字典编码表 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_DIC_CODE_DEF")
public class DicCodeDef extends BaseEntity<String> implements Serializable {

    @Getter
    @Setter
    private String dicId;

   /* @ManyToOne(fetch = FetchType.LAZY, targetEntity = DicDef.class)
    @JoinColumn(name = "DIC_ID", referencedColumnName = "ID")
    public DicDef getDicId() {
        return this.dicId;
    }*/

    /*数据字典编码*/
    @Getter
    @Setter
    private String dicCode;

    /*字典数据名称*/
    @Getter
    @Setter
    private String codeName;

    /*父节点编码*/
    @Getter
    @Setter
    private String parent;


    /*子节点编码*/
    @Getter
    @Setter
    private String child;

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

    @Override
    @Transient
    public JSONObject getJsonObject() {
        return null;
    }

}
