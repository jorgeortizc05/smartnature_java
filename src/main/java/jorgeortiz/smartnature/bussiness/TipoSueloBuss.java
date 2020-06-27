package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.TipoSueloDAO;
import jorgeortiz.smartnature.modelo.TipoSuelo;
@Stateless
public class TipoSueloBuss {

	@Inject
	private TipoSueloDAO tipSueDAO;

	public void guardarTipoSuelo(TipoSuelo item) throws Exception {
		TipoSuelo aux = tipSueDAO.read(item.getId());

		if (aux == null)
			tipSueDAO.insert(item);
		else
			throw new Exception("Guardar [TipoSuelo: existe]");
	}

	public TipoSuelo buscarTipoSuelo(int id) throws Exception {
		TipoSuelo aux = tipSueDAO.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [TipoSuelo: null]");
	}

	public void updateTipoSuelo(TipoSuelo item) throws Exception {
		TipoSuelo aux = tipSueDAO.read(item.getId());
		if (aux != null) {
			tipSueDAO.update(item);
		} else
			throw new Exception("Update [TipoSuelo: null]");

	}

	public void deleteTipoSuelo(int id) throws Exception {
		TipoSuelo aux = tipSueDAO.read(id);
		if (aux != null) {
			tipSueDAO.delete(id);
		} else {
			throw new Exception("Delete[TipoSuelo: null]");
		}
	}

	public List<TipoSuelo> getTipoSuelos() throws Exception {

		List<TipoSuelo> auxs = tipSueDAO.getTipoSuelos();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [TipoSuelos: null]");
	}
}
