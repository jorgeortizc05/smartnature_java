package jorgeortiz.smartnature.main;

import java.util.logging.Logger;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Main {

	//Se crea una instancia de la librería PanamaHitek_Arduino
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static final SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable()) {
                    //Se imprime el mensaje recibido en la consola
                    System.out.println(ino.printMessage());
                }
            } catch (SerialPortException | ArduinoException ex) {
               
            }

        }
    };

    public static void main(String[] args) {
        try {
            ino.arduinoRX("/dev/ttyACM0", 9600, listener);
        } catch (ArduinoException | SerialPortException ex) {
            
        }
    }

}
