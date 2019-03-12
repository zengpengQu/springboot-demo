package com.cmahrmobile.hr.controller;

import com.cmahrmobile.hr.dao.OrganizationDeptDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitDataListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(InitDataListener.class);

    @Autowired
    private OrganizationDeptDao organizationDeptDao;

    public static Object orgList = new Object();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            if (event.getApplicationContext().getParent() == null) {
                orgList = organizationDeptDao.orgDataTreeView();
            }
        }catch (Exception e){
            LOG.error("处理静态资源异常");
        }
    }
}
