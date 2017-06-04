package strutshelloworld.net.ren.struts2.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import strutshelloworld.net.ren.struts2.domain.User;
import strutshelloworld.net.ren.struts2.repository.UserRepository;
import strutshelloworld.net.ren.struts2.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.service.UserService#addUser(strutshelloworld.net.ren.struts2.domain.User)
	 */
	public void addUser(User user) {
		userRepository.add(user);
	}

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.service.UserService#findUserByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	public User findUserByUsernameAndPassword(String username, String password) {
		return userRepository.findUserByUsernameAndPassword(username, password);
	}

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.service.UserService#deleteUserByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	public void deleteUserByUsernameAndPassword(String username, String password) {
	    userRepository.deleteUserByUsernameAndPassword(username, password);
	}

	/* (non-Javadoc)
	 * @see strutshelloworld.net.ren.struts2.service.UserService#isUsernameExist(java.lang.String)
	 */
	public boolean isUsernameExist(String username) {
		return userRepository.isUsernameExist(username);
	}

}
