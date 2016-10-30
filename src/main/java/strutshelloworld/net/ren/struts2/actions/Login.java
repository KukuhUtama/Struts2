package strutshelloworld.net.ren.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;
/**
 * The Class Login.
 */
public class Login extends ActionSupport {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The username. */
    private String username;
    
    /** The password. */
    private String password;
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {
	if( getUsername()== null || getPassword() == null){
	    return "input";
	}
	else if (this.username.equals("admin") && this.password.equals("admin123")) {
	    return "success";
	} else {
	    addActionError(getText("error.login"));
	    return "error";
	}
    }
        
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
    
    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
	return password;
    }
    
    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
	this.password = password;
    }
    
}