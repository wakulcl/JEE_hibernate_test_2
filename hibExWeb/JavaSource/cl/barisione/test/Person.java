/*
 * Creado el 06-03-2008
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
package cl.barisione.test;

import java.io.Serializable;

/**
 * @author USIST28
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generaci�n de c�digo&gt;C�digo y comentarios
 */
public class Person implements Serializable {
	private Long id;
	private String name;
	
	
	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param long1
	 */
	public void setId(Long long1) {
		id = long1;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

}
