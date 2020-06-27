package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.Planta;
@Stateless
public class PlantaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Planta item) {
		em.persist(item);
	}
	
	public Planta read(int id){
		return em.find(Planta.class, id);
	}
	
	public void update(Planta item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<Planta> getPlantas(){
		
		String jpql = "SELECT d FROM Planta d";
		Query query = em.createQuery(jpql, Planta.class);
		List<Planta> items = query.getResultList();
		return items;
	}

}
