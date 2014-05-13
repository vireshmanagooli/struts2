/**
 * 
 */
package org.example.interceptor;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Viresh
 *
 */
public class ProcessAction extends ActionSupport{
	 
		public String execute() throws Exception {
	 
			//Wait for a while
			for(int i =0; i<1000000; i++){
				System.out.println(i);
			}
			return SUCCESS;
	 
		}
	}
