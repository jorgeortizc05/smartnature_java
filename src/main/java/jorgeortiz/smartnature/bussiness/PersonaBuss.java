package jorgeortiz.smartnature.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.smartnature.dao.PersonaDAO;
import jorgeortiz.smartnature.modelo.Persona;
@Stateless
public class PersonaBuss {
	
	@Inject
	private PersonaDAO perDAO;

	public void guardarPersona(Persona item) throws Exception {
		Persona aux = perDAO.read(item.getId());

		if (aux == null) {
			item.setNombre(item.getNombre().toUpperCase());
			item.setApellido(item.getApellido().toUpperCase());
			item.setTelefono(item.getTelefono().replace(" ", ""));//me permite eliminar espacios
			perDAO.insert(item);
		}else
			throw new Exception("Guardar [Persona: existe]");
	}

	public Persona buscarPersona(int id) throws Exception {
		Persona aux = perDAO.read(id);

		if (aux != null) {
			return aux;
		} else
			throw new Exception("Buscar [Persona: null]");
	}

	public void updatePersona(Persona item) throws Exception {
		Persona aux = perDAO.read(item.getId());
		if (aux != null) {
			item.setNombre(item.getNombre().toUpperCase());
			item.setApellido(item.getApellido().toUpperCase());
			item.setTelefono(item.getTelefono().replace(" ", ""));
			perDAO.update(item);
		} else
			throw new Exception("Update [Persona: null]");

	}

	public void deletePersona(int id) throws Exception {
		Persona aux = perDAO.read(id);
		if (aux != null) {
			perDAO.delete(id);
		} else {
			throw new Exception("Delete[Persona: null]");
		}
	}

	public List<Persona> getPersonas() throws Exception {

		List<Persona> auxs = perDAO.getPersonas();

		if (auxs != null) {
			return auxs;
		} else
			throw new Exception("List [Personas: null]");
	}

}
