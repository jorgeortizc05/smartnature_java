package jorgeortiz.smartnature.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import jorgeortiz.smartnature.bussiness.ParametrosBuss;
import jorgeortiz.smartnature.modelo.Parametros;

@ManagedBean
@ViewScoped
public class ControlManualView {
	
	@Inject
	private ParametrosBuss paramBuss;
	
	private Parametros newParametros;
	private List<Parametros> Parametross;
	
	//Variables
	private int vIdParametros;
	private boolean vEditing;
	
	@PostConstruct
	public void init() {
		newParametros = new Parametros();
		vEditing = false;
	}
	
	public String abrirLlaves() {
		try {
			newParametros.setId(1);
			newParametros.setEstado(1);
			paramBuss.guardarParametros(newParametros);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String cerrarLlaves() {
		try {
			newParametros.setId(1);
			newParametros.setEstado(0);
			paramBuss.guardarParametros(newParametros);
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
			paramBuss.deleteParametros(id);
			loadParametross();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void loadParametros() {
		if(vIdParametros == 0) {
			return;
		}
		
		vEditing = true;
		try {
			newParametros = paramBuss.buscarParametros(vIdParametros);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadParametross() {
		try {
			Parametross = paramBuss.getParametross();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Parametros getNewParametros() {
		return newParametros;
	}

	public void setNewParametros(Parametros newParametros) {
		this.newParametros = newParametros;
	}

	public int getvIdParametros() {
		return vIdParametros;
	}

	public void setvIdParametros(int vIdParametros) {
		this.vIdParametros = vIdParametros;
	}

	public boolean isvEditing() {
		return vEditing;
	}

	public void setvEditing(boolean vEditing) {
		this.vEditing = vEditing;
	}

	public List<Parametros> getParametross() {
		return Parametross;
	}

}
