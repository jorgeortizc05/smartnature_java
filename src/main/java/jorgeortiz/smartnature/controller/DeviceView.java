package jorgeortiz.smartnature.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import jorgeortiz.smartnature.bussiness.DeviceBuss;
import jorgeortiz.smartnature.modelo.Device;
//importante usar session escope solo para la session de usuario
@ManagedBean
@ViewScoped
public class DeviceView {

	@Inject
	private DeviceBuss devBuss;
	
	private Device newDevice;
	private List<Device> devices;
	
	//Variables
	private int vIdDevice;
	private boolean vEditing;
	
	@PostConstruct
	public void init() {
		newDevice = new Device();
		vEditing = false;
	}
	
	public String guardarDevice() {
		try {
			if(vEditing) {
				devBuss.updateDevice(newDevice);
				return "list_device?faces-redirect=true";
			}else {
				devBuss.guardarDevice(newDevice);
				return "list_device?faces-redirect=true";
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String goActualizar(int id) {
		
		return "editar_device?faces-redirect=true&id="+id;
	}
	
	public String eliminar(int id) {
		try {
			devBuss.deleteDevice(id);
			loadDevices();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void loadDevice() {
		if(vIdDevice == 0) {
			return;
		}
		
		vEditing = true;
		try {
			newDevice = devBuss.buscarDevice(vIdDevice);
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

	public Device getNewDevice() {
		return newDevice;
	}

	public void setNewDevice(Device newDevice) {
		this.newDevice = newDevice;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public int getvIdDevice() {
		return vIdDevice;
	}

	public void setvIdDevice(int vIdDevice) {
		this.vIdDevice = vIdDevice;
	}
	
	
}
