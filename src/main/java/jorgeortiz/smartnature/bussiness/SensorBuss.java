package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.SensorDAO;
import jorgeortiz.smartnature.modelo.Sensor;
@Stateless
public class SensorBuss {
	
	@Inject
	private SensorDAO senDAO;

	public void guardarSensor(Sensor item) throws Exception {
		Sensor aux = senDAO.read(item.getId());

		if (aux == null)
			senDAO.insert(item);
		else
			throw new Exception("Guardar [Sensor: existe]");
	}

	public Sensor buscarSensor(int id) throws Exception {
		Sensor aux = senDAO.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [Sensor: null]");
	}

	public void updateSensor(Sensor item) throws Exception {
		Sensor aux = senDAO.read(item.getId());
		if (aux != null) {
			senDAO.update(item);
		} else
			throw new Exception("Update [Sensor: null]");

	}

	public void deleteSensor(int id) throws Exception {
		Sensor aux = senDAO.read(id);
		if (aux != null) {
			senDAO.delete(id);
		} else {
			throw new Exception("Delete[Sensor: null]");
		}
	}

	public List<Sensor> getSensors() throws Exception {

		List<Sensor> auxs = senDAO.getSensors();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [Sensors: null]");
	}

}
