package strutshelloworld.net.ren.struts2.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import strutshelloworld.net.ren.struts2.domain.User;
import strutshelloworld.net.ren.struts2.service.UserService;

/**
 * The Class UserAction.
 */
public class UserAction extends ActionSupport implements ModelDriven, Preparable, SessionAware{

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The is log in. */
	private boolean isLogIn;
	
	/** The is sign up. */
	private boolean isSignUp;

	/** The session map. */
	private SessionMap sessionMap;

	/**
	 * Checks if is sign up.
	 *
	 * @return true, if is sign up
	 */
	public boolean isSignUp() {
		return isSignUp;
	}

	/**
	 * Sets the sign up.
	 *
	 * @param isSignUp the new sign up
	 */
	public void setSignUp(boolean isSignUp) {
		this.isSignUp = isSignUp;
	}

	/**
	 * Checks if is log in.
	 *
	 * @return true, if is log in
	 */
	public boolean isLogIn() {
		return isLogIn;
	}

	/**
	 * Sets the log in.
	 *
	 * @param isLogIn
	 *            the new log in
	 */
	public void setLogIn(boolean isLogIn) {
		this.isLogIn = isLogIn;
	}

	/** The user. */
	private User user = new User();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() throws Exception {
		isSignUp = false;
		isLogIn = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public Object getModel() {
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * Sign up.
	 *
	 * @return the string
	 */
	public String signUp() {
		System.out.println("SignUp");
		try {
			userService.addUser(user);
			isSignUp = false;
		   	isLogIn = true;
		} catch (Exception ex) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Show sign up.
	 *
	 * @return the string
	 */
	public String showSignUp() {
	   	isSignUp = true;
	   	isLogIn = false;
		return SUCCESS;
	}

	/**
	 * Log in.
	 *
	 * @return the string Pactera2017
	 */
	public String logIn() {
		User logInUser = userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		if ((logInUser.getUsername() != null || !"".equalsIgnoreCase(logInUser.getUsername())) &&(logInUser.getPassword() != null && !"".equalsIgnoreCase(logInUser.getPassword()))) {
			sessionMap.put("user", logInUser);
			return SUCCESS;
		} else {
			addActionError(getText("error.login"));
			return ERROR;
		}
	}

	/**
	 * Show log in.
	 *
	 * @return the string
	 */
	public String showLogIn() {
		isLogIn = true;
		return INPUT;
	}

	/**
	 * Log out.
	 *
	 * @return the string
	 */
	public String logOut() {
		sessionMap.clear();
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> map) {	
		this.sessionMap = (SessionMap) map;
	}

}
