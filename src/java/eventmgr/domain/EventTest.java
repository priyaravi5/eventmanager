/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

import static java.lang.System.out;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author je393537
 */
public class EventTest 
{
 private static SessionFactory Factory =HibernateUtil.getSessionFactory();
    public static void saveEvents( ) {
		Event event = new Event( );
		event.setName("Java Days");
		event.setStartdate( new java.util.Date(108,Calendar.JULY,1) );
		
		      
                      Session session=Factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"from Location where name=:name");
		query.setParameter("name", "Kasetsart University");
		List list = query.list();
		event.setLocation( (Location)list.get(0) );
		out.println("Saving event:"+event+" Location:"+ event.getLocation() );
		session.save( event );
		tx.commit();
                session.close();
		// getCurrentSession creates a session that is bound to a
		// single
		out.println("Event saved");

    } 
    public static void testRetrieve()
    {
        out.println("Retrieving Event...");
		Session session = Factory.openSession();
		Query query = session.createQuery("from Event");
		Transaction tx = session.beginTransaction();
		List list = query.list( );		
		for( Object eve : list ) out.println( eve);
		tx.commit();
		session.close();
		out.println("Done retrieving");
    }
    public static void testUpdate(String name, Location newLoc) 
    {
        Session session=Factory.openSession();
        Transaction t=session.beginTransaction();
        Query query=session.createQuery("from Event where name=:n");
        query.setParameter("n",name);
        List l=query.list();
        if(l.size()==0)
        {
            System.out.println("Event not found");
        }
        else
        {
            Event e=(Event)l.get(0);
            e.setLocation(newLoc);
        }
        t.commit();
        session.close();
        
    }
     public static void addSpeakers(String eventName, Set<Speaker> speaker) {
        Session session = Factory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Event where name=:name");
        query.setParameter("name", eventName);
        List list = query.list();
        if (list.size() == 0) {
            System.out.println("not found");
        } else {
            Event event = (Event) list.get(0);
            for(Speaker s:speaker)
            event.addSpeaker(s);
        }
        transaction.commit();
        session.close();
    }
     public static void testRetrieve1() 
     {
	System.out.println("Retrieving events...");
	
	Session session = Factory.openSession( );
	Transaction tx = session.beginTransaction();	
	Query query = session.createQuery( "from Event" );
	List<Event> list = (List<Event>)query.list( );
	tx.commit();
       session.close();
for(Event e : list ) {
		out.println( e.toString()+ e.getStartdate() );
		out.println( e.getLocation() );
		out.println( "  Speakers:");
		for(Speaker s : e.getSpeakers() ) out.print(" "+s.getName() );
		out.println();
	}
	 
}

    public static void main(String[] args) {
		// recreate the locations because we told Hibernate
		// to recreate the schema each run.
		//LocationTest.saveLocations( );
		//saveEvents();
		//testRetrieve();
              /*Session session=Factory.openSession();
               Transaction t=session.beginTransaction();
                Query query=session.createQuery("from Location where name=:name");
                query.setParameter("name","Mahidol University");
                List list=query.list();
                t.commit();
                session.close();
                if(list.size()==0)
                {
                    System.out.println("Not Found");
                }
                else
                {
                    testUpdate("Java Days",(Location)list.get(0));
                }*/
             /*  Speaker s=new Speaker("jeeva","9578918589");
                Speaker s1=new Speaker("mani","9658741258");
                Set<Speaker> s2=new HashSet<Speaker>();
                s2.add(s);
                s2.add(s1);
                addSpeakers("Java Days",s2);*/
               testRetrieve1();
                
	}

}
