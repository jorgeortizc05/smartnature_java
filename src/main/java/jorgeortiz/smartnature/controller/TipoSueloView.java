package jorgeortiz.smartnature.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import jorgeortiz.smartnature.bussiness.TipoSueloBuss;
import jorgeortiz.smartnature.modelo.TipoSuelo;

@ManagedBean
@ViewScoped
public class TipoSueloView {
	
	@Inject
	private TipoSueloBuss tipSueBuss;
	
	private TipoSuelo newTipoSuelo;
	private List<TipoSuelo> tipoSuelos;
	
	//Variables
	private int vIdTipoSuelo;
	private boolean vEditing;
	
	@PostConstruct
	public void init() {
		newTipoSuelo = new TipoSuelo();
		vEditing = false;
	}
	
	public String guardarTipoSuelo() {
		try {
			if(vEditing) {
				tipSueBuss.updateTipoSuelo(newTipoSuelo);
				return "list_tipo_suelo?faces-redirect=true";
			}else {
				tipSueBuss.guardarTipoSuelo(newTipoSuelo);
				return "list_tipo_suelo?faces-redirect=true";
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String goActualizar(int id) {
		
		return "editar_tipo_suelo?faces-redirect=true&id="+id;
	}
	
	public String eliminar(int id) {
		try {
			tipSueBuss.deleteTipoSuelo(id);
			loadTipoSuelos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void loadTipoSuelo() {
		if(vIdTipoSuelo == 0) {
			return;
		}
		
		vEditing = true;
		try {
			newTipoSuelo = tipSueBuss.buscarTipoSuelo(vIdTipoSuelo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadTipoSuelos() {
		try {
			tipoSuelos = tipSueBuss.getTipoSuelos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TipoSuelo getNewTipoSuelo() {
		return newTipoSuelo;
	}

	public void setNewTipoSuelo(TipoSuelo newTipoSuelo) {
		this.newTipoSuelo = newTipoSuelo;
	}

	public int getvIdTipoSuelo() {
		return vIdTipoSuelo;
	}

	public void setvIdTipoSuelo(int vIdTipoSuelo) {
		this.vIdTipoSuelo = vIdTipoSuelo;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public List<TipoSuelo> getTipoSuelos() {
		return tipoSuelos;
	}

}
