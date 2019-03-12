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
 * <p>Title:AssessSet.java</p>
 * <p>Description: 考察考核子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_SET_ASSESS")
public class AssessSet extends BaseEntity<String> implements Serializable {

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

    /*考核类别*/
    @Getter
    @Setter
    private String category;

    /*考核时间*/
    @Getter
    @Setter
    private Date assessTime;

    /*考核结果*/
    @Getter
    @Setter
    private String assessmentResult;

    /*连续优秀次数*/
    @Getter
    @Setter
    private Integer goodTimes;

    /*连续称职（含）以上次数*/
    @Getter
    @Setter
    private Integer competentTimes;

    /*考核情况*/
    @Getter
    @Setter
    private String assessmentSituation;

    /*
   （ 0，当年未增加；1，当年已增加）
    */
    @Getter
    @Setter
    private String dutyPayIncrease;

    /*
    （0，当年未增加；1，当年已增加）
    */
    @Getter
    @Setter
    private String levelPayIncrease;

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
