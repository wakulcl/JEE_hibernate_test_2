
/*
 * @(#) EventManager.java  1.0 06-11-2007
 *
 * Este código fuente pertenece a la Caja de Compensación de Asignación Familiar
 * La Araucana (C.C.A.F.). Su utilización y reproducción es confidencial y está
 * restringido a los sistemas de información propios de la institución.
 */


package cl.barisione.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EventManager {
   
	public Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
    
    public void save(Object transientInstance) {//Object objToStore
		try {
				 getSession().save(transientInstance);
			 } catch (RuntimeException re) {
			 	re.printStackTrace();
				 throw re;
			 }
    }	
    
	public void delete(Object persistentInstance) {
		try {
			getSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}	
	public void attachDirty(Object instance) {
		try {
			getSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
    
    
    public static void main(String[] args) {
    	EventManager instance = new EventManager();
        
    	// PRIMERO INGRESAMOS ALGO A LA BD
    	String title = "evento 1";
        Date theDate = new Date();
		Event e = new Event();
		
		e.setDate(theDate);
		e.setTitle(title);
        instance.save(e);
        
        // SEGUNDO LISTAMOS DE LA BD
        List events = instance.listObjects("Event");
        for (int i = 0; i<events.size(); i++) {
	        Event theEvent = (Event) events.get(i);
	        System.out.println(
	            "Event " + theEvent.getTitle() + " Time: " + theEvent.getDate());
        }
        System.exit(0);    
    }


	/**
	 * @param string
	 * @return
	 */
	public List listObjects(String object) {
		List result = new ArrayList();
		try {
			result = getSession().createQuery("from "+object).list();
		 } catch (RuntimeException re) {
			 throw re;
		 }
		 return result;
	}
}

