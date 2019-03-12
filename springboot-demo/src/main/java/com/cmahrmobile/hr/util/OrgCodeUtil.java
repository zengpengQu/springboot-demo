package com.cmahrmobile.hr.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: OrgCodeUtil
 * @Description: orgCode加工
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date: 2019年01月17
 * @author: 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version: 1.0
 */
@Component
public class OrgCodeUtil {

    private int orgGunStatic = 155;


    public Map<String, String> dealWithOrgData(String orgCode) {
        Map<String, String> res = new HashMap<>();
        if (orgCode.indexOf(",") != -1) {
            String[] orgArr = orgCode.split(",");
            String orgCodes = "";
            String deptCodes = "";
            if (orgArr.length == 2) {
                orgCodes = orgArr[0];
                deptCodes = orgArr[1];
            } else {
                if (orgGunStatic >= Integer.parseInt(orgArr[0].substring(1))) {
                    orgCodes = orgArr[0];
                    deptCodes = orgArr[1];
                } else {
                    orgCodes = orgArr[1];
                    deptCodes = orgArr[2];
                }
            }
            String deptDefault = "R00" + orgCodes.substring(1);
            if (deptCodes.equals(deptDefault)) {
                res.put("type", "1");
                res.put("code", orgCodes);
            } else {
                res.put("type", "2");
                res.put("code", deptCodes);
            }
        } else {
            res.put("type", "1");
            res.put("code", orgCode);
        }
        return res;
    }
}
