package cl.barisione.test.actions;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cl.barisione.test.Author;
import cl.barisione.test.Concept;
import cl.barisione.test.Document;
import cl.barisione.test.Event;
import cl.barisione.test.EventManager;
import cl.barisione.test.Person;

/**
 * @version 	1.0
 * @author
 */
public class TestAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value

		try {

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
			
			/**
			 * MANY-TO-ONE EXAMPLE
			 */
			
			Person p = new Person();
			p.setName("juan perez");
			
			Author a = new Author();
			a.setAlias("iluminati");
			a.setPerson(p);

		    instance.save(p);
		    instance.save(a);	
		    
			List listaPersonas = instance.listObjects("Person");
			Iterator iterPersonas = listaPersonas.iterator();
			
			while(iterPersonas.hasNext()){
				Person aPerson = (Person) iterPersonas.next();
				System.out.println(
									"Person id: " +aPerson.getId() + " name : " + aPerson.getName() );
			
			}			
		    /**
		     * Listamos los autores
		     */		
		    List listaAutores = instance.listObjects("Author");
		    Iterator iterAutores = listaAutores.iterator();
		    
		    while(iterAutores.hasNext()){
		    	Author aAuthor = (Author) iterAutores.next();
				Person aPerson = aAuthor.getPerson();
				System.out.println(
									"Author \" " + aAuthor.getAlias()  +" \" "+ aPerson.getName());
			
		    }
		    
			/**
			 * MANY-TO-MANY EXAMPLE
			 */
			
			Concept c1 = new Concept();
			c1.setDescription("test concept 1");
			Concept c2 = new Concept();
			c2.setDescription("test concept 2");
			Concept c3 = new Concept();
			c3.setDescription("test concept 3");
			
			//debo salvar los conceptos antes de salvar la tabla many-to-many
			instance.save(c1);
			instance.save(c2);
			instance.save(c3);
			
			Document d = new Document();
			d.setDescription("test document 1");			
			Set set = new TreeSet();
			
			try{
				//TreeSet + Hibernate implica implementar la interface Comparable en Concept.java
				set.add(c3);
				set.add(c2);
		   		set.add(c1);
		    }catch(ClassCastException cEx){
				cEx.printStackTrace();
			}
			d.setConcepts(set);
			
			instance.save(d);
			
			/**
			 * Listamos 
			 */		
			List listaDocuments = instance.listObjects("Document");
			Iterator iterDocuments = listaDocuments.iterator();

			while(iterDocuments.hasNext()){
				Document aDocument = (Document) iterDocuments.next();
				Set concepts = aDocument.getConcepts();
				
				Object[] objects = concepts.toArray();
				
				System.out.println(
									"Document description: \" " + aDocument.getDescription()+ " \" lenght of Concepts : "+objects.length);
				
				Iterator i = aDocument.getConcepts().iterator();
				while(i.hasNext()){
					Concept c = (Concept) i.next();
					c.getDescription();
					
					System.out.println("Concept id :  " + c.getId()+ "  description : "+c.getDescription());
				
				}
			}
			
		} catch (Exception e) {

			// Report the error using the appropriate name and ID.
			errors.add("name", new ActionError("id"));

		}

		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.

		if (!errors.isEmpty()) {
			saveErrors(request, errors);

			// Forward control to the appropriate 'failure' URI (change name as desired)
			forward = mapping.findForward("failure");

		} else {

			// Forward control to the appropriate 'success' URI (change name as desired)
			forward = mapping.findForward("success");

		}

		// Finish with
		return (forward);

	}
}
