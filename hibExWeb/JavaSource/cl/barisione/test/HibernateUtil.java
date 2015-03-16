
/*
 * @(#) HibernateUtil.java  1.0 06-11-2007
 *
 * Este código fuente pertenece a la Caja de Compensación de Asignación Familiar
 * La Araucana (C.C.A.F.). Su utilización y reproducción es confidencial y está
 * restringido a los sistemas de información propios de la institución.
 */


package cl.barisione.test;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static boolean init = false;
	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
			init = true;
		} catch (Throwable ex) {
			System.err.println("La creacion de la SessionFactory fallo." + ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static boolean isInit() {
		return init;
	}
}