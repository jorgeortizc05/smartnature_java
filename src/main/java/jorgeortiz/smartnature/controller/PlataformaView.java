package jorgeortiz.smartnature.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import jorgeortiz.smartnature.bussiness.DeviceBuss;
import jorgeortiz.smartnature.bussiness.PlantaBuss;
import jorgeortiz.smartnature.bussiness.PlataformaBuss;
import jorgeortiz.smartnature.bussiness.TipoSueloBuss;
import jorgeortiz.smartnature.modelo.Device;
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
	
	@Inject
	private DeviceBuss devBuss;
	
	private Plataforma newPlataforma;
	private List<Plataforma> plataformas;
	
	private List<Planta> plantas;
	private Planta newPlanta;
	
	private List<TipoSuelo> tipSuelos;
	private TipoSuelo newTipoSuelo;
	
	private List<Device> devices;
	private Device newDevice;
	
	//Variables
	private int vIdPlataforma;
	private boolean vEditing;
	private int vIdPlanta;
	private int vIdDevice;
	private int vIdTipoSuelo;
	
	@PostConstruct
	public void init() {
		newPlataforma = new Plataforma();
		newPlanta = new Planta();
		newTipoSuelo = new TipoSuelo();
		newDevice = new Device();
		vEditing = false;
	}
	
	public String guardarPlataforma() {
		try {
			if(vEditing) {
				platBuss.updatePlataforma(newPlataforma);
				return "list_plataforma?faces-redirect=true";
			}else {
				platBuss.guardarPlataforma(newPlataforma);
				newPlanta = planBuss.buscarPlanta(vIdPlanta);
				newPlanta.setPlataforma(newPlataforma);
				planBuss.updatePlanta(newPlanta);
				
				
				newTipoSuelo = tipSuelBuss.buscarTipoSuelo(vIdTipoSuelo);
				newPlataforma.setTipoSuelo(newTipoSuelo);
				tipSuelBuss.updateTipoSuelo(newTipoSuelo);
				
				newDevice = devBuss.buscarDevice(vIdDevice);
				newDevice.setPlataforma(newPlataforma);
				devBuss.updateDevice(newDevice);
				
				return "list_plataforma?faces-redirect=true";
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String goActualizar(int idPlataforma, int idPlanta, int idTipoSuelo, int idDevice) {
		
		return "editar_plataforma?faces-redirect=true&idPlataforma="+idPlataforma+"&idPlanta="+idPlanta+"&idTipoSuelo"+idTipoSuelo+"&idDevice"+idDevice;
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
	
	public void loadDevices() {
		try {
			devices = devBuss.getDevices();
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

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public int getvIdDevice() {
		return vIdDevice;
	}

	public void setvIdDevice(int vIdDevice) {
		this.vIdDevice = vIdDevice;
	}

	public int getvIdTipoSuelo() {
		return vIdTipoSuelo;
	}

	public void setvIdTipoSuelo(int vIdTipoSuelo) {
		this.vIdTipoSuelo = vIdTipoSuelo;
	}
	
}
