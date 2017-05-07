package strutshelloworld.net.ren.struts2.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class AbstractBaseRepository.
 *
 * @param <T>
 *            the generic type
 */
public abstract class AbstractBaseRepository<T> implements BaseRepository<T> {

	/** The entity class. */
	private Class<T> entityClass;

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/** The hql. */
	private String hql;

	/** The entities. */
	private List<T> entities;
	/**
	 * Instantiates a new abstract base repository.
	 */
	public AbstractBaseRepository() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entityClass = (Class) pt.getActualTypeArguments()[0];
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory
	 *            the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Gets the current session.
	 *
	 * @return the current session
	 */
	protected Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * strutshelloworld.net.ren.struts2.repository.BaseRepository#add(java.lang.
	 * Object)
	 */
	public void add(T entity) {
		getCurrentSession().saveOrUpdate(entity); // .save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * strutshelloworld.net.ren.struts2.repository.BaseRepository#deleteById(
	 * int)
	 */
	@SuppressWarnings("unchecked")
	public void deleteById(int id) {
		hql = "delete " + entityClass.getName() + " where id = :id";
		Query q = getCurrentSession().createQuery(hql).setParameter("id", id);
		q.executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * strutshelloworld.net.ren.struts2.repository.BaseRepository#getById(int)
	 */
	@SuppressWarnings("unchecked")
	public T getById(int id) {
		return (T) getCurrentSession().get(entityClass.getName(), id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strutshelloworld.net.ren.struts2.repository.BaseRepository#getAll()
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<T> getAll() {
		return getCurrentSession().createCriteria(entityClass).list();
	}
	
	/**
	 * Delete all.
	 */
	public void deleteAll(){
		entities = getAll();
		for(T entity : entities){
			getCurrentSession().delete(entity);
		}
	}
	
	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public void delete(T entity){
		getCurrentSession().delete(entity);
	}
}
