package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.UbicacionDAO;
import jorgeortiz.smartnature.modelo.Ubicacion;
@Stateless
public class UbicacionBuss {
	
	@Inject
	private UbicacionDAO ubDAO;

	public void guardarUbicacion(Ubicacion item) throws Exception {
		Ubicacion aux = ubDAO.read(item.getId());

		if (aux == null)
			ubDAO.insert(item);
		else
			throw new Exception("Guardar [Ubicacion: existe]");
	}

	public Ubicacion buscarUbicacion(int id) throws Exception {
		Ubicacion aux = ubDAO.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [Ubicacion: null]");
	}

	public void updateUbicacion(Ubicacion item) throws Exception {
		Ubicacion aux = ubDAO.read(item.getId());
		if (aux != null) {
			ubDAO.update(item);
		} else
			throw new Exception("Update [Ubicacion: null]");

	}

	public void deleteUbicacion(int id) throws Exception {
		Ubicacion aux = ubDAO.read(id);
		if (aux != null) {
			ubDAO.delete(id);
		} else {
			throw new Exception("Delete[Ubicacion: null]");
		}
	}

	public List<Ubicacion> getUbicacions() throws Exception {

		List<Ubicacion> auxs = ubDAO.getUbicacions();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [Ubicacions: null]");
	}

}
