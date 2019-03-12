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
 * <p>Title:EduDegSet.java</p>
 * <p>Description: 学历学位子集 </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2017</p>
 * <p>Date:2018年01月16</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Entity
@Table(name="TB_SET_EDU_DEG")
public class EduDegSet extends BaseEntity<String> implements Serializable {

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

    /*学校性质*/
    @Getter
    @Setter
    private String schoolNature;


    /*学历编码*/
    @Getter
    @Setter
    private String education;

    /*入学时间*/
    @Getter
    @Setter
    private Date enrollmentDate;

    /*毕（肄）业时间*/
    @Getter
    @Setter
    private Date graduateDate;

    /*毕(肄)业学校(院,系)*/
    @Getter
    @Setter
    private String graduateSchool;

    /*所学专业*/
    @Getter
    @Setter
    private String majo;


    /*学习形式编码*/
    @Getter
    @Setter
    private String learnForm;


    /*学历证书编号*/
    @Getter
    @Setter
    private String academicCertificate;

    /*学位*/
    @Getter
    @Setter
    private String degree;

    /*学位证书号*/
    @Getter
    @Setter
    private String degCertiNo;

    /*学位授予时间*/
    @Getter
    @Setter
    private String degAwardTime;

    /*学位授予（国家，地区）单位*/
    @Getter
    @Setter
    private String degAwardUnit;

    /*气象类最高学历*/
    @Getter
    @Setter
    private String highestEduWeather;


    /*取得气象类最高学历的学校*/
    @Getter
    @Setter
    private String highestEduWeatherSch;

    /*专业备注*/
    @Getter
    @Setter
    private String majorNotes;

    @Transient
    @Override
    public JSONObject getJsonObject() {
        return null;
    }
}
