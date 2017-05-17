package strutshelloworld.net.ren.struts2.repository;

import strutshelloworld.net.ren.struts2.domain.User;

/**
 * The Interface UserRepository.
 */
public interface UserRepository extends BaseRepository<User> {

	
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
