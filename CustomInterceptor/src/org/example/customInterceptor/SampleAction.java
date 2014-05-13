/**
 * 
 */
package org.example.customInterceptor;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Viresh
 *
 */
public class SampleAction extends ActionSupport{
	 
		public String execute() throws Exception {
	 
			System.out.println("************* Inside Sample Action **************");
			return SUCCESS;
	 
		}
	}
