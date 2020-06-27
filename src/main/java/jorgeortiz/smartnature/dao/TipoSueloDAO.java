package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.TipoSuelo;
@Stateless
public class TipoSueloDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(TipoSuelo item) {
		em.persist(item);
	}
	
	public TipoSuelo read(int id){
		return em.find(TipoSuelo.class, id);
	}
	
	public void update(TipoSuelo item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<TipoSuelo> getTipoSuelos(){
		
		String jpql = "SELECT d FROM TipoSuelo d";
		Query query = em.createQuery(jpql, TipoSuelo.class);
		List<TipoSuelo> items = query.getResultList();
		return items;
	}

}
