/*
 * Creado el 06-03-2008
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package cl.barisione.test;

import java.io.Serializable;

/**
 * @author USIST28
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
public class Author  implements Serializable{
	private Long id;
	private String alias;
	private Person person;
	
	
	/**
	 * @return
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param string
	 */
	public void setAlias(String string) {
		alias = string;
	}

	/**
	 * @param long1
	 */
	public void setId(Long long1) {
		id = long1;
	}

	/**
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

}
