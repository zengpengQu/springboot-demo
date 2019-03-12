package com.cmahrmobile.hr.base.impl;

import com.cmahrmobile.hr.base.BaseDao;
import com.cmahrmobile.hr.base.BaseEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Title:BaseDaoImpl
 * @Description: 基础Dao接口实现类
 * @Copyright: 公共服务与应急管理战略本部 Copyright(c)2017
 * @Date:2018年11月16
 *
 * @author 王勇强 (wangyongq@mail.taiji.com.cn)
 * @version 1.0
 */
public class BaseDaoImpl <T extends BaseEntity<ID>,ID extends Serializable> implements BaseDao<T,ID> {

	protected DataSource dataSource;

	protected NamedParameterJdbcTemplate namedTemplate;

	private   Class<T>                   entityClass;

	@PersistenceContext
	protected EntityManager em;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public BaseDaoImpl() {
		Type type              = getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
		entityClass = (Class<T>) parameterizedType[0];
	}

	@Override
	public Query jpaCreateQuery(String jpql) {
		if (!StringUtils.isEmpty(jpql)) {
			return em.createQuery(jpql);
		}
		return null;
	}

	@Override
	public List<T> jpaFindAll() {
		return em.createQuery( "from " + entityClass.getName() ).getResultList();
	}

	@Override
	public List<T> jpaFind(String jpql) {
		Query query = jpaCreateQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<T> jpaFind(String jpql, Map<String, Object> params) {
		Query query = jpaCreateQuery(jpql);
		setParameters(query,params);
		return query.getResultList();
	}

	@Override
	public void jdbcSave(T entity, String tableName) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(entity);
		SimpleJdbcInsert simpleJdbcInsert   = new SimpleJdbcInsert(dataSource);
		simpleJdbcInsert.withTableName(tableName).execute(sqlParameterSource);
	}

	@Override
	public Long jdbcSaveReturnId(T entity, String tableName) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(entity);
		SimpleJdbcInsert   simpleJdbcInsert   = new SimpleJdbcInsert(dataSource);
		simpleJdbcInsert.setGeneratedKeyName("id");
		Number id = simpleJdbcInsert.withTableName(tableName).executeAndReturnKey(sqlParameterSource);
		return id.longValue();
	}

	@Override
	public Long jdbcSaveReturnId(T entity, String tableName, String keyName) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(entity);
		SimpleJdbcInsert   simpleJdbcInsert   = new SimpleJdbcInsert(dataSource);
		simpleJdbcInsert.setGeneratedKeyName(keyName);
		Number id = simpleJdbcInsert.withTableName(tableName).executeAndReturnKey(sqlParameterSource);
		return id.longValue();
	}

	@Override
	public void jdbcSave(String sql, Map<String, Object> params) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(params);
		namedTemplate.update(sql, sqlParameterSource);
	}

	@Override
	public Long jdbcSaveReturnId(String sql, Map<String, Object> params) {
		KeyHolder keyHolder          = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(params);
		namedTemplate.update(sql, sqlParameterSource, keyHolder, new String[]{"id"});
		return keyHolder.getKey().longValue();
	}

	@Override
	public Long jdbcSaveReturnId(String sql, Map<String, Object> params, String keyName) {
		KeyHolder          keyHolder          = new GeneratedKeyHolder();
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(params);
		namedTemplate.update(sql, sqlParameterSource, keyHolder, new String[]{keyName});
		return keyHolder.getKey().longValue();
	}

	@Override
	public int jdbcUpdate(String sql, T entity) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(entity);
		return namedTemplate.update(sql, sqlParameterSource);
	}

	@Override
	public int jdbcUpdate(String sql, Map<String, Object> params) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(params);
		return namedTemplate.update(sql, sqlParameterSource);
	}

	@Override
	public int jdbcDelete(String sql, Map<String, Object> params) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(params);
		return namedTemplate.update(sql, sqlParameterSource);
	}

	@Override
	public int jdbcDeleteById(String tableName, Serializable id) {
		String  sql  = "DELETE FROM " + tableName + " where id=:id";
		Map<String,Object> params = new HashMap<>();
		params.put("id",id);
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource(params);
		return namedTemplate.update(sql, sqlParameterSource);
	}

	@Override
	public T jdbcGet(String sql, Map<String, Object> params) {
		return namedTemplate.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(entityClass));
	}

	@Override
	public Integer jdbcExecute(String sql) {
		return this.jdbcExecute(sql, null);
	}

	@Override
	public Integer jdbcExecute(String sql, Map<String, Object> params) {
		return namedTemplate.update(sql, params);
	}


	@Override
	public <X> X jdbcFindUnique(Class<X> xEntityClass, String sql, Map<String, Object> params) {
		return namedTemplate.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(xEntityClass));
	}

	@Override
	public Long jdbcCount(final String sql, final Map<String, Object> params) {
		return namedTemplate.queryForObject(sql, params, Long.class);
	}

	@Override
	public <X> List<X> jdbcFindAll(Class<X> xEntityClass, String tableName) {
		String  sql  = "SELECT *  FROM " + tableName + " where 1 = 1 and del_flag = 0";
		List<X> list = namedTemplate.query(sql, BeanPropertyRowMapper.newInstance(xEntityClass));
		return list;
	}

	@Override
	public T jdbcFindOne(Class xEntityClass,String sql,final Map<String, Object> params){
		List<T> result = namedTemplate.query(sql, params, BeanPropertyRowMapper.newInstance(xEntityClass));
		return result==null?null:result.get(0);
	}

	@Override
	public Long jdbcFindIdFromSeq(String seqName) {
		String sql = "select " + seqName + ".nextval from dual";
		Map<String,Object> params = new HashMap<>();
		Long id = namedTemplate.queryForObject(sql, params, Long.class);
		return id;
	}

	@Override
	public T jdbcFindById(String tableName, Serializable id) {
		String  sql  = "SELECT *  FROM " + tableName + " where id=:id";
		Map<String,Object> params = new HashMap<>();
		params.put("id",id);
		return namedTemplate.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(entityClass));
	}

	@Override
	public T jdbcFindById(String tableName, String idName, Serializable id) {
		String  sql  = "SELECT *  FROM " + tableName + " where :idName=:id";
		Map<String,Object> params = new HashMap<>();
		params.put("id",id);
		params.put("idName",idName);
		return namedTemplate.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(entityClass));
	}

	@Override
	public List<Map<String,Object>>   jdbcQueryForList(String sql,Map<String, Object> params) {
		List result = namedTemplate.queryForList(sql, params);
		return result;
	}

	private void setParameters(Query query, Map<String, Object> params) {
		Set<String> keys = params.keySet();
		for (String key : keys) {
			Object obj = params.get(key);
			query.setParameter(key, obj);
		}
	}
}
