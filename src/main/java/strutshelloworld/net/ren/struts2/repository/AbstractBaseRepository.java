package strutshelloworld.net.ren.struts2.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractBaseRepository<T> implements BaseRepository<T> {
	
	private Class<T> entityClass;
	
	//@Autowired
	private SessionFactory sessionFactory;
    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public  void add(T entity){
		getCurrentSession().save(entity);
	}

	public void deleteById(int id){
		entityClass = getCurrentSession().load(entityClass.getClass(), id);
		if (entityClass != null) {
			getCurrentSession().delete(entityClass);
		}
	}

	public  T getById(int id){
		return (T) getCurrentSession().load(entityClass.getClass(), id);
	}
		

	public  List<T> getAll(){
		return getCurrentSession().createCriteria(entityClass.getClass()).list();
	}
}
