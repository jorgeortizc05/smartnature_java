package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.ParametrosDAO;
import jorgeortiz.smartnature.modelo.Parametros;
import jorgeortiz.smartnature.modelo.Sensor;
@Stateless
public class ParametrosBuss {

	@Inject
	private ParametrosDAO paramDao;

	public void guardarParametros(Parametros item) throws Exception {
		Parametros aux = paramDao.read(item.getId());

		if (aux == null)
			paramDao.insert(item);
		else {
			paramDao.update(item);
			throw new Exception("Se ha actualizado");
		}
	}

	public Parametros buscarParametros(int id) throws Exception {
		Parametros aux = paramDao.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [Parametros: null]");
	}

	public void updateParametros(Parametros item) throws Exception {
		Parametros aux = paramDao.read(item.getId());
		if (aux != null) {
			paramDao.update(item);
		} else
			throw new Exception("Update [Parametros: null]");

	}

	public void deleteParametros(int id) throws Exception {
		Parametros aux = paramDao.read(id);
		if (aux != null) {
			paramDao.delete(id);
		} else {
			throw new Exception("Delete[Parametros: null]");
		}
	}

	public List<Parametros> getParametross() throws Exception {

		List<Parametros> auxs = paramDao.getParametross();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [Parametross: null]");
	}
	
	//Obtengo el ultimo parametros registrado en la base de datos
	public Parametros getLastParametro() throws Exception {

		List<Parametros> auxs = paramDao.findOrderedByParametrosId();
		Parametros aux = auxs.get(0);
		if (aux != null) {
			return aux;
		} else
			throw new Exception("getLastSensor [Sensor: null]");
	}
}
