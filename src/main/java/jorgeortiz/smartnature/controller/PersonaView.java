package jorgeortiz.smartnature.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import jorgeortiz.smartnature.bussiness.PersonaBuss;
import jorgeortiz.smartnature.modelo.Persona;

@ManagedBean
@ViewScoped
public class PersonaView {

	@Inject
	private PersonaBuss perBuss;
	
	private Persona newPersona;
	private List<Persona> personas;
	
	//Variables
	private int vIdPersona;
	private boolean vEditing;
	
	@PostConstruct
	public void init() {
		newPersona = new Persona();
		vEditing = false;
	}
	
	public String guardarPersona() {
		try {
			if(vEditing) {
				perBuss.updatePersona(newPersona);
				return "list_persona?faces-redirect=true";
			}else {
				perBuss.guardarPersona(newPersona);
				return "list_persona?faces-redirect=true";
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String goActualizar(int id) {
		
		return "editar_persona?faces-redirect=true&id="+id;
	}
	
	public String eliminar(int id) {
		try {
			perBuss.deletePersona(id);
			loadPersonas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void loadPersona() {
		if(vIdPersona == 0) {
			return;
		}
		
		vEditing = true;
		try {
			newPersona = perBuss.buscarPersona(vIdPersona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadPersonas() {
		try {
			personas = perBuss.getPersonas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}

	public int getvIdPersona() {
		return vIdPersona;
	}

	public void setvIdPersona(int vIdPersona) {
		this.vIdPersona = vIdPersona;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public List<Persona> getPersonas() {
		return personas;
	}
	
	
}
