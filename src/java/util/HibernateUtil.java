/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author MA393506
 */
public class HibernateUtil 
{   
    public static SessionFactory getSessionFactory()
    {
Configuration config = new Configuration( );
	SessionFactory sessionFactory =
			config.configure().buildSessionFactory( );
        return sessionFactory;
    }
}
