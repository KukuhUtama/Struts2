package strutshelloworld.net.ren.struts2.restactions;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;
import strutshelloworld.net.ren.struts2.service.UserService;

/**
 * The Class UserRestAction.
 */
public class UserRestAction{

	private Gson gson = new Gson();
	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Show.
	 *
	 * @return true, if successful
	 */
	public String show(){
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("--------show-----");
		String jsonString = gson.toJson(userService.isUsernameExist("hello"));
		response.setContentType("text/json");
		try {
			response.setCharacterEncoding("UTF-8");
			response.getOutputStream().print(jsonString.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HttpHeaders index() {
		System.out.println("-------index-----");
		return new DefaultHttpHeaders("index").disableCaching();
	}

}
