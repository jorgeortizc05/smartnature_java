package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.Parametros;
import jorgeortiz.smartnature.modelo.Sensor;
@Stateless
public class ParametrosDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Parametros item) {
		em.persist(item);
	}
	
	public Parametros read(int id){
		return em.find(Parametros.class, id);
	}
	
	public void update(Parametros item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<Parametros> getParametross(){
		
		String jpql = "SELECT d FROM Parametros d";
		Query query = em.createQuery(jpql, Parametros.class);
		List<Parametros> items = query.getResultList();
		return items;
	}
	
	public List<Parametros> findOrderedByParametrosId(){
		
		String jpql = "SELECT p FROM Parametros p ORDER BY p.id desc";
		Query query = em.createQuery(jpql, Parametros.class);
		query.setMaxResults(1);
		List<Parametros> items = query.getResultList();
		return items;
	}

}
