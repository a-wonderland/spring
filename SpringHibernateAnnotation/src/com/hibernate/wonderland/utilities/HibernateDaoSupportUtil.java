package com.hibernate.wonderland.utilities;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * In annotation mode, no way to auto wire the session Factory bean from DAO class. 
 * Creating Custom HibernateDaoSupport, to auto wire the session factory.
 * 
 * @author Alice
 */

public abstract class HibernateDaoSupportUtil extends HibernateDaoSupport{
	
	@Autowired
	public void getSessionFactory(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}

}
