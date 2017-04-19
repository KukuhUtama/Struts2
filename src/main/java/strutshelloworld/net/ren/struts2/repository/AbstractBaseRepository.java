package strutshelloworld.net.ren.struts2.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class AbstractBaseRepository.
 *
 * @param <T> the generic type
 */
public abstract class AbstractBaseRepository<T> implements BaseRepository<T> {

	/** The entity class. */
	private Class<T> entityClass;

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

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
	 * @param sessionFactory the new session factory
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
		getCurrentSession().saveOrUpdate(entity); //.save(entity);
	}

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.repository.BaseRepository#deleteById(int)
	 */
	public void deleteById(int id) {
		entityClass = getCurrentSession().load(entityClass.getClass(), id);
		if (entityClass != null) {
			getCurrentSession().delete(entityClass);
		}
	}

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.repository.BaseRepository#getById(int)
	 */
	public T getById(int id) {
		return (T) getCurrentSession().load(entityClass.getClass(), id);
	}

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.repository.BaseRepository#getAll()
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<T> getAll() {
		return getCurrentSession().createCriteria(entityClass.getClass()).list();
	}
}
