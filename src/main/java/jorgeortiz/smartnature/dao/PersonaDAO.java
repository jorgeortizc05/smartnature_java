package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.Persona;
@Stateless
public class PersonaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Persona item) {
		em.persist(item);
	}
	
	public Persona read(int id){
		return em.find(Persona.class, id);
	}
	
	public void update(Persona item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<Persona> getPersonas(){
		
		String jpql = "SELECT d FROM Persona d";
		Query query = em.createQuery(jpql, Persona.class);
		List<Persona> items = query.getResultList();
		return items;
	}

}
