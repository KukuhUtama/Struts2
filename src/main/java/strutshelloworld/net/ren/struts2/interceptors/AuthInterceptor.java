package strutshelloworld.net.ren.struts2.interceptors;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		System.out.println("destroy Auth");
	}

	public void init() {
		System.out.println("init Auth");
	}

	public String intercept(ActionInvocation invoke) throws Exception {
		SessionMap sessionMap = (SessionMap) ActionContext.getContext().getSession();
		System.out.println("Isis Session:  "+sessionMap.get("user") );
		if(sessionMap.get("user") == null){
			return Action.LOGIN;
		} else {
			return invoke.invoke();
		}
	}

}
