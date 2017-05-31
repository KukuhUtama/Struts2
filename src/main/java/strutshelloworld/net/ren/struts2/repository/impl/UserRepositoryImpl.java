package strutshelloworld.net.ren.struts2.repository.impl;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import strutshelloworld.net.ren.struts2.domain.User;
import strutshelloworld.net.ren.struts2.repository.AbstractBaseRepository;
import strutshelloworld.net.ren.struts2.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRepositoryImpl.
 */
@Repository("userRepository")
public class UserRepositoryImpl extends AbstractBaseRepository<User> implements UserRepository {
    
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	

	/** The hql. */
	private String hql;
	
	/** The is exist. */
	private boolean isExist = false;


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

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.repository.UserRepository#findUserByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	public User findUserByUsernameAndPassword(String username, String password) {
		hql = "from User where username='"+username+"' and password='"+password+"'";
		Query query = getCurrentSession().createQuery(hql);
		return (User) query.getSingleResult();
	}

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.repository.UserRepository#deleteUserByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	public void deleteUserByUsernameAndPassword(String username, String password) {
		hql = "delete User where username = :username and password= :password";
		Query q = getCurrentSession().createQuery(hql).setParameter("username", username).setParameter("password", password);
		q.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.repository.UserRepository#isUsernameExist(java.lang.String)
	 */
	public boolean isUsernameExist(String username) {
		hql = "from User where username='"+username+"'";
		Query query = getCurrentSession().createQuery(hql);
		if(query.getResultList().size()>0){
			isExist = true;
		}
		return isExist;
	}

}
