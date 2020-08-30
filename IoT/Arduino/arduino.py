import serial
import time
import requests
import json

arduino = serial.Serial("/dev/ttyACM0", 9600)
"""address = 'http://192.168.0.2:8080/jorgeortiz.smartnature/srv/tipo-planta/eliminarid?id=3'"""
address = 'http://localhost:8080/smartnature/srv/sensor/insertar'

headers = {"Content-type": "application/json"}
while True:
    val = arduino.readline()
    humedadSuelo = val.decode().split(";")[0]
    print(humedadSuelo)
    
    try:
        datos = {"id":0,"tempAmbiente":0,"humedadAmbiente":0,"humedadSuelo":float(humedadSuelo),"fechaCaptura":0}
        print(datos)
        et = requests.post(address, data = json.dumps(datos), headers = headers)
        print(et.text)
        
        
    except:
        print("sin conexion")
        
arduino.close()