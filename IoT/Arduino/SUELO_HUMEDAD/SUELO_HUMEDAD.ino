#include <DHT.h>//Libreria del sensor DHT11

int sensorAmbiental = 2;
int tempAmb, humedadAmb;
const int electrovalvula = 13;
const int humedadSuelo = A0;

DHT dht (sensorAmbiental, DHT11);

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  dht.begin();

  pinMode(humedadSuelo, INPUT);
  pinMode(electrovalvula, OUTPUT);
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

  humedadAmb = dht.readHumidity();
  tempAmb = dht.readTemperature();

  Serial.print("Temperatura ambiental: "); Serial.print(tempAmb);
  Serial.print("C Humedad ambiental: "); Serial.print(humedadAmb); Serial.println("%");

  Serial.print("Humedad Suelo: "); Serial.print(sensorSuelo);
  delay(3000);

  if(sensorSuelo >= 700) // el valor que considero seco y hay que regar es de 700
  {
   // Si la tierra está seca, comenzara a regar
   // Riega durante 1 segundo y espera a comprobar la humedad otro segundo
   Serial.println("La tierra está seca, comienza el riego");
   digitalWrite(electrovalvula, HIGH);
   delay(2000);
   digitalWrite(electrovalvula, LOW);
   delay(1000);
  }
  
  delay(1000);
}
