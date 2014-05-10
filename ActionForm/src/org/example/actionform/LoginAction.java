/**
 * 
 */
package org.example.actionform;

/**
 * @author Viresh
 *
 */
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// business logic
	public String execute() {

		return "SUCCESS";

	}

	// simple validation
	public void validate() {
		if ("viresh".equals(getUsername())) {
			addActionMessage("You are valid user!");
		} else {
			addActionError("User name or password invalid");
		}
	}
}
