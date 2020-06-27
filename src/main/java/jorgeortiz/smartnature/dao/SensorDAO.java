package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.Sensor;
@Stateless
public class SensorDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Sensor item) {
		em.persist(item);
	}
	
	public Sensor read(int id){
		return em.find(Sensor.class, id);
	}
	
	public void update(Sensor item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<Sensor> getSensors(){
		
		String jpql = "SELECT d FROM Sensor d";
		Query query = em.createQuery(jpql, Sensor.class);
		List<Sensor> items = query.getResultList();
		return items;
	}
}
