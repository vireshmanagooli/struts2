package org.example.struts2hibernate.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.struts2hibernate.listener.HibernateListener;
import org.example.struts2hibernate.model.Customer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 
public class CustomerAction extends ActionSupport 
	implements ModelDriven{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5930930347831578683L;
	Customer customer = new Customer();
	List<Customer> customerList = new ArrayList<Customer>();
	
	public String execute() throws Exception {
		return SUCCESS;
	}

	public Object getModel() {
		return customer;
	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	//save customer
	public String addCustomer() throws Exception{
		
		//get hibernate session from the servlet context
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session session=sf.openSession();
		session.beginTransaction();	

		//save it
		customer.setCreatedDate(new Date());		
		session.save(customer);
		
		//reload the customer list
		customerList = null;
		customerList = session.createQuery("from Customer").list();
				
		session.getTransaction().commit();
		session.close();
	 
		return SUCCESS;
	
	}
	
	//list all customers
	public String listCustomer() throws Exception{
		
		//get hibernate session from the servlet context
		Configuration configuration=new Configuration();
		configuration.configure();
		ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(sr);				
		Session session=sf.openSession();
		session.beginTransaction();	

		customerList = session.createQuery("from Customer").list();
		
		session.getTransaction().commit();
		session.close();
		
		return SUCCESS;
	
	}
	
}