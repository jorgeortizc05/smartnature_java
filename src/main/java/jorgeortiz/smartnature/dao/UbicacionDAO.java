package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.Ubicacion;
@Stateless
public class UbicacionDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Ubicacion item) {
		em.persist(item);
	}
	
	public Ubicacion read(int id){
		return em.find(Ubicacion.class, id);
	}
	
	public void update(Ubicacion item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<Ubicacion> getUbicacions(){
		
		String jpql = "SELECT d FROM Ubicacion d";
		Query query = em.createQuery(jpql, Ubicacion.class);
		List<Ubicacion> items = query.getResultList();
		return items;
	}

}
