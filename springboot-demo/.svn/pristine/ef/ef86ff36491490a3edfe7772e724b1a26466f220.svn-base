package com.cmahrmobile.hr.entity.hrdic;

import com.alibaba.fastjson.JSONObject;
import com.cmahrmobile.hr.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Title:DicCodeDef.java</p>
 * <p>Description: 数据字典编码目录表 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_DIC_DEF")
public class DicDef extends BaseEntity<String> implements Serializable {

    @Id
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Getter
    @Setter
    private String dicCode;
   /*数据字典名称*/
   @Getter
   @Setter
   private String dicName;

   /*字典长度*/
   @Getter
   @Setter
   private Integer dicLen;

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


    @Setter
    private List<DicCodeDef> dicCodeDefList;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "dicCode", fetch = FetchType.LAZY, targetEntity = DicCodeDef.class)
    public List<DicCodeDef> getDicCodeDefList() {
        return dicCodeDefList;
    }

    @Transient
    @Override
    public JSONObject getJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("dicCode",dicCode);
        jsonObject.put("dicName",dicName);
        return jsonObject;
    }
}
