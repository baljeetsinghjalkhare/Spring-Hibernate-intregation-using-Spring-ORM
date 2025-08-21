package com.bs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpEntry {

    @Autowired
    private SessionFactory sessionFactory;
	public void saveData(Emp emp)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("info.xml");
		SessionFactory sf =context.getBean("sessionFactory",SessionFactory.class);
	    Session ss=sf.openSession();
	    Transaction tr=ss.beginTransaction();
	    ss.save(emp);
	    tr.commit();
	    System.out.println("Data Inserted....");
	    ss.close();
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Emp e1=new Emp(777,"abc","cse","executive",1000000);
      EmpEntry empEntry=new EmpEntry();
      empEntry.saveData(e1);
      
	}

}
