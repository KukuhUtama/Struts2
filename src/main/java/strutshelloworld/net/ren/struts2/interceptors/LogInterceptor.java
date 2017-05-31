package strutshelloworld.net.ren.struts2.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**
 * The Class LogInterceptor.
 */
public class LogInterceptor implements Interceptor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	public void destroy() {
		System.out.println("destroy Log");
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	public void init() {
		System.out.println("init Log");
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	public String intercept(ActionInvocation invoke) throws Exception {
		String className = invoke.getAction().getClass().getName();
		long startTime = System.currentTimeMillis();
		System.out.println("Before calling action: " + className);

		String result =  invoke.invoke();

		long endTime = System.currentTimeMillis();
		System.out.println("After calling action: " + className + " Time taken: " + (endTime - startTime) + " ms");
		return result;

	}

}
