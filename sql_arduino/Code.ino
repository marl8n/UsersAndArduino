
#include <Servo.h>

String input;
Servo servo;

void setup() {
  pinMode(13, OUTPUT);
    servo.attach(13);
  Serial.begin(9600); 
}

void loop() {
  int valorFotorres;
 valorFotorres = analogRead(A0);
 
 if (valorFotorres<10){
  Serial.println("1");
  
 }
 
  if (Serial.available() > 0) {

    input = Serial.read();

    if (input == "1"){
      digitalWrite(13, HIGH);
      servo.write(0);
      delay(2000);
      servo.write(100);     
    }

  }
}
