/*
 * Desarrollado por Jorge Ortiz
 * Fecha: 24/08/2020
 * 
 */

#include <DHT.h>//Libreria del sensor DHT11

int sensorAmbiental = 2; //Pin 2 Digital
int tempAmb, humedadAmb; //Variables para sensor ambiental
const int electrovalvula = 13; //Pin 13 Digital: HIGH O LOW
const int humedadSuelo = A0; //Pin A0 analogico.

DHT dht (sensorAmbiental, DHT11); //Funcion para dht11

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  dht.begin();

  pinMode(humedadSuelo, INPUT); //Valores como entrada
  pinMode(electrovalvula, OUTPUT); //Valores como salida, se abre o cierra
}

void loop() {
  // put your main code here, to run repeatedly:
  /*int lectura = analogRead(A0);
  int sensorDH = analogRead(A1);
  Serial.println("Sensor Suelo: ");
  Serial.println(lectura);
  Serial.println("Sensor Ambiental: ");
  Serial.println(sensorDH);

  int lecturaPorcentaje = map(lectura, 1023, 400, 0, 100);

  Serial.print("La humedad es del: ");
  Serial.print(lecturaPorcentaje);
  Serial.println("%");*/

  int sensorSuelo = analogRead(humedadSuelo);

  humedadAmb = dht.readHumidity(); //Obtengo la humedad ambiental
  tempAmb = dht.readTemperature(); //Temperatura ambiental

  //Serial.print("Temperatura ambiental: "); Serial.print(tempAmb);
  //Serial.print("C Humedad ambiental: "); Serial.print(humedadAmb); Serial.println("%");

  

  Serial.print(humedadSuelo);
  /*Serial.print(";");
  Serial.print(t);
  Serial.print(";");
  Serial.print(h);
  Serial.println();*/
  delay(10000); 

/*
  if(sensorSuelo >= 700) // el valor que considero seco y hay que regar es de 700
  {
   //Si la tierra está seca, comenzara a regar
   //Riega durante 1 segundo y espera a comprobar la humedad otro segundo
   digitalWrite(electrovalvula, HIGH); //se abre
   delay(2000); //Riego por 2 segundos
   digitalWrite(electrovalvula, LOW); //se cierra
   delay(1000);
  }
  */
}
