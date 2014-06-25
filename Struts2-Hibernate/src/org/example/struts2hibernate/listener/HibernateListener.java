package org.example.struts2hibernate.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
 
public class HibernateListener implements ServletContextListener{
 
	private AnnotationConfiguration config;
    private SessionFactory factory;
    private String path = "/hibernate.cfg.xml";
    private static Class<HibernateListener> clazz = HibernateListener.class;
 
   public static final String KEY_NAME = clazz.getName();

   /**
    * Default Costructor
    */
   public HibernateListener(){
	   
   }
	   
	public void contextDestroyed(ServletContextEvent event) {
		//
	}
 
	public void contextInitialized(ServletContextEvent event) {
 
		try {
			 
	         URL url = HibernateListener.class.getResource(path);
	         config = new AnnotationConfiguration().configure(url);
	         factory = config.buildSessionFactory();
	         
	         //save the Hibernate session factory into serlvet context
	         event.getServletContext().setAttribute(KEY_NAME, factory);
	 
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }

	}
}