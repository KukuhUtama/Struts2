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
public class UserAction extends ActionSupport implements ModelDriven, Preparable{

	/** The user service. */
	@Autowired
	private UserService userService;
	
	/** The user. */
	private User user = new User();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() throws Exception {
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public Object getModel() {
		return user;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		System.out.println("execute");
		return INPUT;
	}
	
	/**
	 * Sign up.
	 *
	 * @return the string
	 */
	public String SignUp(){
		System.out.println("SignUp");
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * Log in.
	 *
	 * @return the string
	 */
	public String LogIn(){
		System.out.println("Login");
		User logInUser = userService.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
		if( logInUser.getUsername()== null || logInUser.getPassword() == null){
		    return SUCCESS;
		} else {
		    addActionError(getText("error.login"));
		    return ERROR;
		}
	}
	
	/**
	 * Log out.
	 *
	 * @return the string
	 */
	public String LogOut(){
		
		return SUCCESS;
	}

}
