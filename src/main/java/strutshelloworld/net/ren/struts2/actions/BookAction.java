package strutshelloworld.net.ren.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class BookAction.
 */
public class BookAction extends ActionSupport {

	/** The message. */
	private String message;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		message = "Inside execute method";
		return SUCCESS;
	}

	/**
	 * Adds the.
	 *
	 * @return the string
	 */
	public String add() {
		message = "Inside add method";
		return SUCCESS;
	}

	/**
	 * Update.
	 *
	 * @return the string
	 */
	public String update() {
		message = "Inside update method";
		return SUCCESS;
	}

	/**
	 * Delete.
	 *
	 * @return the string
	 */
	public String delete() {
		message = "Inside delete method";
		return SUCCESS;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
