package jorgeortiz.smartnature.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import jorgeortiz.smartnature.bussiness.SensorBuss;
import jorgeortiz.smartnature.modelo.Device;
import jorgeortiz.smartnature.modelo.Sensor;
//importante usar session escope solo para la session de usuario
@ManagedBean
@RequestScoped
public class DashboardView {

	@Inject
	private SensorBuss senBuss;
	
	private Sensor newSensor;
	private List<Device> devices;
	
	//Variables
	private int vIdSensor;
	
	@PostConstruct
	public void init() {
		newSensor = new Sensor();
	}
	
	public String loadLastDevice() {
		try {
			newSensor = senBuss.getLastSensor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public Sensor getNewSensor() {
		return newSensor;
	}

	public void setNewSensor(Sensor newSensor) {
		this.newSensor = newSensor;
	}
	
	
		
}
