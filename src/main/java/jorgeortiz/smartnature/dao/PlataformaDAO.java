package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.Plataforma;
@Stateless
public class PlataformaDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Plataforma item) {
		em.persist(item);
	}
	
	public Plataforma read(int id){
		return em.find(Plataforma.class, id);
	}
	
	public void update(Plataforma item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<Plataforma> getPlataformas(){
		
		String jpql = "SELECT d FROM Plataforma d";
		Query query = em.createQuery(jpql, Plataforma.class);
		List<Plataforma> items = query.getResultList();
		return items;
	}
}
