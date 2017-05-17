package strutshelloworld.net.ren.struts2.service;

import strutshelloworld.net.ren.struts2.domain.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Adds the user.
	 *
	 * @param user the user
	 */
	public void addUser(User user);
	
	/**
	 * Find user by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user
	 */
	public User findUserByUsernameAndPassword(String username, String password);
	
	/**
	 * Delete user by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void deleteUserByUsernameAndPassword(String username, String password);
}
