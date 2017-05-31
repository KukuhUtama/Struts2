package strutshelloworld.net.ren.struts2.interceptors;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * The Class AuthInterceptor.
 */
public class AuthInterceptor implements Interceptor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	public void destroy() {
		System.out.println("destroy Auth");
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	public void init() {
		System.out.println("init Auth");
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	public String intercept(ActionInvocation invoke) throws Exception {
		SessionMap sessionMap = (SessionMap) ActionContext.getContext().getSession();
		if(sessionMap.get("user") == null){
		    return Action.LOGIN;
		} else {
			return invoke.invoke();
		}
	}
	/*
	 * https://stackoverflow.com/questions/2999829/redirect-to-another-action-in-an-interceptor-in-struts-2
	 * http://www.journaldev.com/2210/struts-2-interceptor-example
	 * http://www.vitarara.org/cms/struts_2_cookbook/creating_a_login_interceptor
	 */

}
