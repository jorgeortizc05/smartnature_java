package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.HistorialRiego;

@Stateless
public class HistorialRiegoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(HistorialRiego item) {
		em.persist(item);
	}
	
	public HistorialRiego read(int id){
		return em.find(HistorialRiego.class, id);
	}
	
	public void update(HistorialRiego item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<HistorialRiego> getHistorialRiegos(){
		
		String jpql = "SELECT d FROM HistorialRiego d";
		Query query = em.createQuery(jpql, HistorialRiego.class);
		List<HistorialRiego> items = query.getResultList();
		return items;
	}

}
