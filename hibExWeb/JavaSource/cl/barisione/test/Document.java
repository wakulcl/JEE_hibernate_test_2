/*
 * Creado el 12-03-2008
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package cl.barisione.test;

import java.io.Serializable;
import java.util.Set;

/**
 * @author USIST28
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
public class Document implements Serializable {
	private Set concepts;
	private long id;
	private String description;
	
	 
	/**
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param l
	 */
	public void setId(long l) {
		id = l;
	}



	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}


	/**
	 * @return
	 */
	public Set getConcepts() {
		return concepts;
	}

	/**
	 * @param collection
	 */
	public void setConcepts(Set s) {
		concepts = s;
	}

}
