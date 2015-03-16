
/*
 * @(#) HibernateUtil.java  1.0 06-11-2007
 *
 * Este c�digo fuente pertenece a la Caja de Compensaci�n de Asignaci�n Familiar
 * La Araucana (C.C.A.F.). Su utilizaci�n y reproducci�n es confidencial y est�
 * restringido a los sistemas de informaci�n propios de la instituci�n.
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