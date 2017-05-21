package strutshelloworld.net.ren.struts2.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import strutshelloworld.net.ren.struts2.domain.User;
import strutshelloworld.net.ren.struts2.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserAction.
 */
public class UserAction extends ActionSupport implements ModelDriven, Preparable {

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The is log in. */
	private boolean isLogIn = true;
	
	/** The is sign up. */
	private boolean isSignUp = false;
	
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

	/** The sign up message. */
	private String signUpMessage;

	/**
	 * Gets the sign up message.
	 *
	 * @return the sign up message
	 */
	public String getSignUpMessage() {
		return signUpMessage;
	}

	/**
	 * Sets the sign up message.
	 *
	 * @param signUpMessage the new sign up message
	 */
	public void setSignUpMessage(String signUpMessage) {
		this.signUpMessage = signUpMessage;
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
		System.out.println("execute");
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
			isLogIn = true;
	    	isSignUp = true;
			signUpMessage = "Sign Up Success";
		} catch (Exception ex) {
			isLogIn = false;
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
		System.out.println("showSignUp");
		isLogIn = false;
		return SUCCESS;
	}

	/**
	 * Log in.
	 *
	 * @return the string
	 */
	public String logIn() {
		System.out.println("Login");
		User logInUser = userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (logInUser.getUsername() == null || logInUser.getPassword() == null) {
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
		System.out.println("ShowLogIn");
		return INPUT;
	}

	/**
	 * Log out.
	 *
	 * @return the string
	 */
	public String logOut() {
		return SUCCESS;
	}

}
