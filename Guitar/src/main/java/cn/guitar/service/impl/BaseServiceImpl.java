package cn.guitar.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.guitar.dao.BaseDao;
import cn.guitar.dao.GuitarDao;
import cn.guitar.dao.GuitarSpecDao;
import cn.guitar.service.BaseService;


/**
* 技改项目业务代表实现类.实现新增项目,删除项目等方法，<br>
* 提供对表现层的接口.
* @author  马辉
* @since   JDK1.8
* @history 2016年11月21日下午3:07:12 马辉 新建
*/
@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
	@SuppressWarnings("rawtypes")
	private Class clazz; //
	@SuppressWarnings("rawtypes")
	public BaseServiceImpl() {
		
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	@SuppressWarnings("rawtypes")
	protected BaseDao baseDao; 
	
	@PostConstruct   
	public void init() throws Exception{
		
		String clazzName=clazz.getSimpleName();
		String clazzDaoName=clazzName.substring(0,1).toLowerCase() + clazzName.substring(1) + "Dao";
		Field clazzField=this.getClass().getSuperclass().getDeclaredField(clazzDaoName);
		
		Field baseField=this.getClass().getSuperclass().getDeclaredField("baseDao");
		
		baseField.set(this,clazzField.get(this));
	}
	//注入dao
	@Resource(name="guitarDao")
	protected GuitarDao guitarDao;
	@Resource(name="guitarSpecDao")
	protected GuitarSpecDao guitarSpecDao;
	
	
	@Override
	public T get(int id) {
		return (T) baseDao.get(id);
	}

	
	@Override
	public void save(T entity) {
		baseDao.save(entity);
	}

	
	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	
	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	
	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}
	

	@Override
	public List<T> queryAll() {
		return baseDao.queryAll();
	}

	
	@Override
	public List<T> queryByPage(String hql, int pageNo, int pageSize) {
		return baseDao.queryByPage(hql, pageNo, pageSize);
	}

	
	@Override
	public long countAll() {
		return baseDao.countAll();
	}

	
	@Override
	public long countByHql(String hql) {
		return baseDao.countByHql(hql);
	}
}
