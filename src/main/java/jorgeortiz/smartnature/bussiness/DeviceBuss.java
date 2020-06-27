package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.DeviceDAO;
import jorgeortiz.smartnature.modelo.Device;
@Stateless
public class DeviceBuss {

	@Inject
	private DeviceDAO devDAO;

	public void guardarDevice(Device item) throws Exception {
		Device aux = devDAO.read(item.getId());

		if (aux == null)
			devDAO.insert(item);
		else
			throw new Exception("Guardar [Device: existe]");
	}

	public Device buscarDevice(int id) throws Exception {
		Device aux = devDAO.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [Device: null]");
	}

	public void updateDevice(Device item) throws Exception {
		Device aux = devDAO.read(item.getId());
		if (aux != null) {
			devDAO.update(item);
		} else
			throw new Exception("Update [Device: null]");

	}

	public void deleteDevice(int id) throws Exception {
		Device aux = devDAO.read(id);
		if (aux != null) {
			devDAO.delete(id);
		} else {
			throw new Exception("Delete[Device: null]");
		}
	}

	public List<Device> getDevices() throws Exception {

		List<Device> auxs = devDAO.getDevices();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [Devices: null]");
	}

}
