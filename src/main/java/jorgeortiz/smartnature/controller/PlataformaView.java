package jorgeortiz.smartnature.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import jorgeortiz.smartnature.bussiness.PlantaBuss;
import jorgeortiz.smartnature.bussiness.PlataformaBuss;
import jorgeortiz.smartnature.bussiness.TipoSueloBuss;
import jorgeortiz.smartnature.modelo.Planta;
import jorgeortiz.smartnature.modelo.Plataforma;
import jorgeortiz.smartnature.modelo.TipoSuelo;

@ManagedBean
@ViewScoped
public class PlataformaView {

	@Inject
	private PlataformaBuss platBuss;
	
	@Inject
	private PlantaBuss planBuss;
	
	@Inject
	private TipoSueloBuss tipSuelBuss;
	
	private Plataforma newPlataforma;
	private List<Plataforma> plataformas;
	
	private List<Planta> plantas;
	
	private List<TipoSuelo> tipSuelos;
	
	//Variables
	private int vIdPlataforma;
	private boolean vEditing;
	private int vIdPlanta;
	
	@PostConstruct
	public void init() {
		newPlataforma = new Plataforma();
		vEditing = false;
	}
	
	public String guardarPlataforma() {
		try {
			if(vEditing) {
				platBuss.updatePlataforma(newPlataforma);
				return "list_plataforma?faces-redirect=true";
			}else {
				platBuss.guardarPlataforma(newPlataforma);
				return "list_plataforma?faces-redirect=true";
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String goActualizar(int id) {
		
		return "editar_plataforma?faces-redirect=true&id="+id;
	}
	
	public String eliminar(int id) {
		try {
			platBuss.deletePlataforma(id);
			loadPlataformas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void loadPlataforma() {
		if(vIdPlataforma == 0) {
			return;
		}
		
		vEditing = true;
		try {
			newPlataforma = platBuss.buscarPlataforma(vIdPlataforma);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loadPlataformas() {
		try {
			plataformas = platBuss.getPlataformas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadPlantas() {
		try {
			plantas = planBuss.getPlantas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadTipoSuelos() {
		try {
			tipSuelos = tipSuelBuss.getTipoSuelos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Plataforma getNewPlataforma() {
		return newPlataforma;
	}

	public void setNewPlataforma(Plataforma newPlataforma) {
		this.newPlataforma = newPlataforma;
	}

	public int getvIdPlataforma() {
		return vIdPlataforma;
	}

	public void setvIdPlataforma(int vIdPlataforma) {
		this.vIdPlataforma = vIdPlataforma;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public List<Plataforma> getPlataformas() {
		return plataformas;
	}

	public int getvIdPlanta() {
		return vIdPlanta;
	}

	public void setvIdPlanta(int vIdPlanta) {
		this.vIdPlanta = vIdPlanta;
	}

	public List<Planta> getPlantas() {
		return plantas;
	}

	public List<TipoSuelo> getTipSuelos() {
		return tipSuelos;
	}

	public void setTipSuelos(List<TipoSuelo> tipSuelos) {
		this.tipSuelos = tipSuelos;
	}

}
