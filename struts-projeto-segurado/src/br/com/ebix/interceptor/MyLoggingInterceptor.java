package br.com.ebix.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyLoggingInterceptor implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("Destroying MyLoggingInterceptor...");

	}

	@Override
	public void init() {
		System.out.println("Initializing MyLoggingInterceptor...");

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		String className = invocation.getAction().getClass().getName();
		long startTime = System.currentTimeMillis();
		System.out.println("Before calling action: " + className);

		String result = invocation.invoke();

		long endTime = System.currentTimeMillis();
		System.out.println("After calling action: " + className + " Time taken: " + (endTime - startTime) + " ms");

		return result;
	}

}
