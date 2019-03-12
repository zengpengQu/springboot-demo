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
 * <p>Title:BaseSetFieldDef.java</p>
 * <p>Description: 子集表字段属性对应表 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_BASE_SET_FIELD_DEF")
public class BaseSetFieldDef extends BaseEntity<String> implements Serializable {

    public BaseSetFieldDef(){}

    /**
     * 子集定义表
     **/
    @Getter
    @Setter
    private String setId;

    /**
     * 字段编码
     **/
    @Getter
    @Setter
    private String fieldCode;


    /**
     * 字段名称
     **/
    @Getter
    @Setter
    private String fieldName;


    /**
     * 字段描述
     **/
    @Getter
    @Setter
    private String fieldDesc;


    /**
     * 字段类型
     **/
    @Getter
    @Setter
    private String fieldType;


    /**
     * 字段长度
     **/
    @Getter
    @Setter
    private Integer fieldLen;

    /**
     * 精度
     **/
    @Getter
    @Setter
    private Integer decLen;


    /**
     * 数据字典
     **/
    @Getter
    @Setter
    private String dicId;

    /**
     * 是否为空
     **/
    @Getter
    @Setter
    private String isNull;

    /**
     * 排序
     **/
    @Getter
    @Setter
    private Integer setSeq;


    /**
     * 创建时间
     **/
    @Getter
    @Setter
    private Date createTime;

    /**
     * 更新时间
     **/
    @Getter
    @Setter
    private Date updateTime;

   /**
    * 删除标志
    **/
    @Getter
    @Setter
    private Integer delFlag;

    /**
     * 计算公式
     **/
    @Getter
    @Setter
    private String function;

    /**
     * 可重复
     */
    @Getter
    @Setter
    private String isRepeat;


//    /**
//     * 是否可排序
//     **/
//    @Getter
//    @Setter
//	private Boolean sortbale;


//    /**
//    * jqgrid的样式
//    **/
//    @Getter
//    @Setter
//    private String jqgridStyle;
    @Transient
    @Override
    public JSONObject getJsonObject() {
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name",fieldCode);
//        jsonObject.put("hearder",fieldName);
//        jsonObject.put("sortable",sortbale);
//        jsonObject.put("width",jqgridStyle);
    	return jsonObject;
    }

    @Transient
    public JSONObject getJsonObjByFieldCode(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dicId",dicId);
        jsonObject.put("fieldCode",fieldCode);
        jsonObject.put("fieldName",fieldName);
        jsonObject.put("fieldType",fieldType);
        jsonObject.put("fieldDesc",fieldDesc);
        jsonObject.put("fieldLen",fieldLen);
        jsonObject.put("decLen",decLen);
        jsonObject.put("isNull",isNull);
        jsonObject.put("function",function);
        return jsonObject;
    }
}
