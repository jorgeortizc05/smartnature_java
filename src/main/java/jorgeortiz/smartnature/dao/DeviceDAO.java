package jorgeortiz.smartnature.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import jorgeortiz.smartnature.modelo.Device;

@Stateless
public class DeviceDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Device item) {
		em.persist(item);
	}
	
	public Device read(int id){
		return em.find(Device.class, id);
	}
	
	public void update(Device item) {
		em.merge(item);
	}
	
	public void delete(int id) {
		em.remove(read(id));
	}
	
	public List<Device> getDevices(){
		
		String jpql = "SELECT d FROM Device d";
		Query query = em.createQuery(jpql, Device.class);
		List<Device> items = query.getResultList();
		return items;
	}
}
