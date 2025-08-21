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
		
	    Session ss=sessionFactory.openSession();
	    Transaction tr=ss.beginTransaction();
	    ss.save(emp);
	    tr.commit();
	    System.out.println("Data Inserted....");
	    ss.close();
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context=new ClassPathXmlApplicationContext("info.xml");
        EmpEntry empEntry = context.getBean("empEntry",EmpEntry.class);
      Emp e1=new Emp(888,"abc","cse","executive",1000000);
      empEntry.saveData(e1);
      
	}

}
