package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.HistorialRiegoDAO;
import jorgeortiz.smartnature.modelo.HistorialRiego;
@Stateless
public class HistorialRiegoBuss {
	
	@Inject
	private HistorialRiegoDAO histDAO;

	public void guardarHistorialRiego(HistorialRiego item) throws Exception {
		HistorialRiego aux = histDAO.read(item.getId());

		if (aux == null)
			histDAO.insert(item);
		else
			throw new Exception("Guardar [HistorialRiego: existe]");
	}

	public HistorialRiego buscarHistorialRiego(int id) throws Exception {
		HistorialRiego aux = histDAO.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [HistorialRiego: null]");
	}

	public void updateHistorialRiego(HistorialRiego item) throws Exception {
		HistorialRiego aux = histDAO.read(item.getId());
		if (aux != null) {
			histDAO.update(item);
		} else
			throw new Exception("Update [HistorialRiego: null]");

	}

	public void deleteHistorialRiego(int id) throws Exception {
		HistorialRiego aux = histDAO.read(id);
		if (aux != null) {
			histDAO.delete(id);
		} else {
			throw new Exception("Delete[HistorialRiego: null]");
		}
	}

	public List<HistorialRiego> getHistorialRiegos() throws Exception {

		List<HistorialRiego> auxs = histDAO.getHistorialRiegos();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [HistorialRiegos: null]");
	}

}
