/*
 * Creado el 12-03-2008
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
public class Concept  implements Serializable, Comparable{
	private long id;
	private String description;
	
	
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param l
	 */
	public void setId(long l) {
		id = l;
	}

	/* (no Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		// TODO Apéndice de método generado automáticamente
		//si compareTo retorna 0 es porque el objeto O es igual a this, por lo que no debe
		//permitir que se guarde en el treeSet
		Concept c = (Concept) o;
		
		return (int) (this.getId() - c.getId()); 

	}

}
