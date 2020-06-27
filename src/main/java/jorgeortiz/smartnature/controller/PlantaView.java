package jorgeortiz.smartnature.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import jorgeortiz.smartnature.bussiness.PlantaBuss;
import jorgeortiz.smartnature.modelo.Planta;

@ManagedBean
@ViewScoped
public class PlantaView {

	@Inject
	private PlantaBuss plantBuss;
	
	private Planta newPlanta;
	private List<Planta> Plantas;
	
	//Variables
	private int vIdPlanta;
	private boolean vEditing;
	
	@PostConstruct
	public void init() {
		newPlanta = new Planta();
		vEditing = false;
	}
	
	public String guardarPlanta() {
		try {
			if(vEditing) {
				plantBuss.updatePlanta(newPlanta);
				return "list_planta?faces-redirect=true";
			}else {
				plantBuss.guardarPlanta(newPlanta);
				return "list_planta?faces-redirect=true";
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String goActualizar(int id) {
		
		return "editar_planta?faces-redirect=true&id="+id;
	}
	
	public String eliminar(int id) {
		try {
			plantBuss.deletePlanta(id);
			loadPlantas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void loadPlanta() {
		if(vIdPlanta == 0) {
			return;
		}
		
		vEditing = true;
		try {
			newPlanta = plantBuss.buscarPlanta(vIdPlanta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadPlantas() {
		try {
			Plantas = plantBuss.getPlantas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Planta getNewPlanta() {
		return newPlanta;
	}

	public void setNewPlanta(Planta newPlanta) {
		this.newPlanta = newPlanta;
	}

	public int getvIdPlanta() {
		return vIdPlanta;
	}

	public void setvIdPlanta(int vIdPlanta) {
		this.vIdPlanta = vIdPlanta;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public List<Planta> getPlantas() {
		return Plantas;
	}
	
	
}
