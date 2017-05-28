package strutshelloworld.net.ren.struts2.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LogInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		System.out.println("destroy Log");
	}

	public void init() {
		System.out.println("init Log");
	}

	public String intercept(ActionInvocation invoke) throws Exception {
		String result = invoke.invoke();
		System.out.println("result Log "+ result);
		return null;
	}

}
