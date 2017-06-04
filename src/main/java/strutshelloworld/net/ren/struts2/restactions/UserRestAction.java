package strutshelloworld.net.ren.struts2.restactions;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import strutshelloworld.net.ren.struts2.domain.User;
import strutshelloworld.net.ren.struts2.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRestAction.
 */
public class UserRestAction extends ActionSupport implements ModelDriven{
	/** The user. */
	private User user = new User();
	
	/** The username. */
	private String username;
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/** The user service. */
	@Autowired
	private UserService userService;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public Object getModel() {
		return user;
	}
	
	/**
	 * Show.
	 *
	 * @return true, if successful
	 */
	public boolean show(){
		System.out.println("--------show-----");
		return userService.isUsernameExist(username);
	}
	
	public HttpHeaders index() {
		System.out.println("-------index-----");
		return new DefaultHttpHeaders("index").disableCaching();
	}

}
