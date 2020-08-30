package jorgeortiz.smartnature.service;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;

import jorgeortiz.smartnature.dao.SensorDAO;
import jorgeortiz.smartnature.modelo.Sensor;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Arduino {
	
	private PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	private String humedadSuelo;
	
	@Inject
	private SensorDAO senDAO;
	
	public final SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable()) {
                    //Se imprime el mensaje recibido en la consola
                    
                    String humedadSuelo = ino.printMessage();
                    Sensor sensor = new Sensor();
                    sensor.setHumedadSuelo(Double.valueOf(humedadSuelo));
                    senDAO.insert(sensor);
                    System.out.println(humedadSuelo);
                }
            } catch (SerialPortException | ArduinoException ex) {
               
            }

        }
    };
    
    public void init() {
    	try {
			ino.arduinoRX("/dev/ttyACM0", 9600, listener);
		} catch (ArduinoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

}
