package com.cmahrmobile.hr.base;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;
import java.util.UUID;

/**
 * @Title:BaseGeneratePK
 * @Description: 主键生成策略
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date:2018年11月16
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
public class BaseGeneratePrimaryKey implements Configurable, IdentifierGenerator {

	@Override
	public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {

	}

	@Override
	public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
		String Id = ((BaseEntity)o).getId();

		if(Id != null && !"".equals(Id.trim()))
		{
			return Id;
		}
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
