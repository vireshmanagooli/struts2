/**
 * 
 */
package org.example.customInterceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author Viresh
 * 
 */
public class CustomInterceptor implements Interceptor {

	// Called while destroy
	public void destroy() {
		System.out.println("********************** CustomInterceptor destroy() *************************");
	}

	// called while initialization
	public void init() {
		System.out.println("********************** CustomInterceptor init() ****************************");
	}

	// Intercepter constructor
	public String intercept(ActionInvocation invocation) throws Exception {

		System.out.println("********************** before invocation.invoke() ***************************");

		String result = invocation.invoke();

		System.out.println("********************** after invocation.invoke() ***************************");

		return result;
	}

}