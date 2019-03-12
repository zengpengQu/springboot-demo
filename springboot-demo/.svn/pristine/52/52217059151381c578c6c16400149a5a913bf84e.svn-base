package com.cmahrmobile.hr.base;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Title:BaseDao
 * @Description: 基础Dao接口类
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date:2018年11月16
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
public interface BaseDao <T extends BaseEntity<ID>,ID extends Serializable> {

	Query jpaCreateQuery(String jpql);

	List<T> jpaFindAll();

	List<T> jpaFind(String jpql);

	List<T> jpaFind(String jpql, Map<String, Object> params);

	void jdbcSave(T entity, String tableName);

	Long jdbcSaveReturnId(T entity, String tableName);

	Long jdbcSaveReturnId(T entity, String tableName, String keyName);

	void jdbcSave(final String sql, final Map<String, Object> params);

	Long jdbcSaveReturnId(final String sql, final Map<String, Object> params);

	Long jdbcSaveReturnId(final String sql, final Map<String, Object> params, String keyName);

	int jdbcUpdate(final String sql, T entity);

	int jdbcUpdate(final String sql, final Map<String, Object> params);

	int jdbcDelete(final String sql, final Map<String, Object> params);

	int jdbcDeleteById(String tableName, Serializable id);

	T jdbcGet(final String sql, final Map<String, Object> params);

	Integer jdbcExecute(final String sql);

	Integer jdbcExecute(final String sql, final Map<String, Object> params);

	<X> X jdbcFindUnique(Class<X> xEntityClass, final String sql, final Map<String, Object> params);

	Long jdbcCount(final String sql, final Map<String, Object> params);

	<X> List<X> jdbcFindAll(Class<X> xEntityClass, String tableName);

	Long jdbcFindIdFromSeq(final String seqName);

	T jdbcFindById(String tableName, Serializable id);

	T jdbcFindById(String tableName, String idName, Serializable id);

	T jdbcFindOne(Class xEntityClass,String sql,final Map<String, Object> params);
	List<Map<String,Object>>   jdbcQueryForList(String sql,Map<String, Object> params);
}
