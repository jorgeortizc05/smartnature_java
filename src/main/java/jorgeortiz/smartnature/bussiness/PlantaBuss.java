package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.PlantaDAO;
import jorgeortiz.smartnature.modelo.Planta;
@Stateless
public class PlantaBuss {
	
	@Inject
	private PlantaDAO planDAO;

	public void guardarPlanta(Planta item) throws Exception {
		Planta aux = planDAO.read(item.getId());

		if (aux == null)
			planDAO.insert(item);
		else
			throw new Exception("Guardar [Planta: existe]");
	}

	public Planta buscarPlanta(int id) throws Exception {
		Planta aux = planDAO.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [Planta: null]");
	}

	public void updatePlanta(Planta item) throws Exception {
		Planta aux = planDAO.read(item.getId());
		if (aux != null) {
			planDAO.update(item);
		} else
			throw new Exception("Update [Planta: null]");

	}

	public void deletePlanta(int id) throws Exception {
		Planta aux = planDAO.read(id);
		if (aux != null) {
			planDAO.delete(id);
		} else {
			throw new Exception("Delete[Planta: null]");
		}
	}

	public List<Planta> getPlantas() throws Exception {

		List<Planta> auxs = planDAO.getPlantas();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [Plantas: null]");
	}

}
