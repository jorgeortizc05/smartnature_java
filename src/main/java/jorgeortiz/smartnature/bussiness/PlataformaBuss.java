package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.PlataformaDAO;
import jorgeortiz.smartnature.modelo.Plataforma;
@Stateless
public class PlataformaBuss {
	
	@Inject
	private PlataformaDAO platDAO;

	public void guardarPlataforma(Plataforma item) throws Exception {
		Plataforma aux = platDAO.read(item.getId());

		if (aux == null)
			platDAO.insert(item);
		else
			throw new Exception("Guardar [Plataforma: existe]");
	}

	public Plataforma buscarPlataforma(int id) throws Exception {
		Plataforma aux = platDAO.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [Plataforma: null]");
	}

	public void updatePlataforma(Plataforma item) throws Exception {
		Plataforma aux = platDAO.read(item.getId());
		if (aux != null) {
			platDAO.update(item);
		} else
			throw new Exception("Update [Plataforma: null]");

	}

	public void deletePlataforma(int id) throws Exception {
		Plataforma aux = platDAO.read(id);
		if (aux != null) {
			platDAO.delete(id);
		} else {
			throw new Exception("Delete[Plataforma: null]");
		}
	}

	public List<Plataforma> getPlataformas() throws Exception {

		List<Plataforma> auxs = platDAO.getPlataformas();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [Plataformas: null]");
	}

}
