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
 * <p>Title:AdmPostSet.java</p>
 * <p>Description: 行政职务子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_SET_ADM_POST")
public class AdmPostSet extends BaseEntity<String> implements Serializable {

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


    /*行政职务类别*/
    @Getter
    @Setter
    private String admPostType;


    /*职务名称（树型结构）*/
    @Getter
    @Setter
    private String postName;


    /*任职时间*/
    @Getter
    @Setter
    private Date postTime;


    /*任本级时间*/
    @Getter
    @Setter
    private Date sameLevelTime;


    /*任职方式*/
    @Getter
    @Setter
    private String postWay;

    /*职务级别*/
    @Getter
    @Setter
    private String postLevel;


    /*任职文号*/
    @Getter
    @Setter
    private String postFileNum;

    /*任职单位*/
    @Getter
    @Setter
    private String postUnit;

    /*免职日期*/
    @Getter
    @Setter
    private Date removalTime;

    /*降职日期*/
    @Getter
    @Setter
    private Date demoteTime;

    /*免职原因*/
    @Getter
    @Setter
    private String removalCause;

    /*免职原因*/
    @Getter
    @Setter
    private String demoteCause;

    /*免（降）职文号*/
    @Getter
    @Setter
    private String removalFileNum;

    /*降职文号*/
    @Getter
    @Setter
    private String demoteFileNum;

    /*职务变动类型*/
    @Getter
    @Setter
    private String postChangeType;


    @Transient
    @Override
    public JSONObject getJsonObject() {
        return null;
    }
}
