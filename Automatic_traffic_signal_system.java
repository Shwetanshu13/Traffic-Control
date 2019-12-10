#define g1 2
#define g2 3
#define g3 4
#define g4 5
#define r1 6
#define r2 7
#define r3 8
#define r4 13
int trigPin1 = 11;// Trigger
int echoPin1 = 12;    // Echo
int echoPin2 = 10;
int trigPin2 = 9;
long duration1, cm1, duration2, cm2, duration3, cm3, duration4, cm4;
long t=1,cc1=0,cc2=0,c=0;
void regular();
void check();
void bluetooth();
void setup() {
   pinMode(g1,OUTPUT);
   pinMode(g2,OUTPUT);
   pinMode(g3,OUTPUT);
   pinMode(g4,OUTPUT);  
   pinMode(r1,OUTPUT);
   pinMode(r2,OUTPUT);
   pinMode(r3,OUTPUT);
   pinMode(r4,OUTPUT);
   pinMode(trigPin1, OUTPUT);
   pinMode(echoPin1, INPUT);
   pinMode(trigPin2, OUTPUT);
   pinMode(echoPin2, INPUT);
   ///////////////sensor
   Serial.begin(9600);// put your setup code here, to run once:

              }

void loop() {
  cc1=0;
  cc2=0;
  check();//bluetooth(); // put your main code here, to run repeatedly:
  regular();
}

void check()
{

  //S1
  digitalWrite(trigPin1, LOW);
  delayMicroseconds(5);
  digitalWrite(trigPin1, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin1, LOW);
 
  // Read the signal from the sensor: a HIGH pulse whose
  // duration is the time (in microseconds) from the sending
  // of the ping to the reception of its echo off of an object.
  pinMode(echoPin1, INPUT);
  duration1 = pulseIn(echoPin1, HIGH);
 
  // Convert the time into a distance
  cm1 = (duration1/2) / 29.1;     // Divide by 29.1 or multiply by 0.0343
  //inches = (duration/2) / 74;   // Divide by 74 or multiply by 0.0135
  
 //Serial.print(inches);
 //Serial.print("in, ");
  Serial.print(cm1);
  Serial.println("cm1");
  //Serial.println();
  if(cm1<20)
  {
    cc1++;
    delay(1000);
  digitalWrite(trigPin1, LOW);
  delayMicroseconds(5);
  digitalWrite(trigPin1, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin1, LOW);
 
  // Read the signal from the sensor: a HIGH pulse whose
  // duration is the time (in microseconds) from the sending
  // of the ping to the reception of its echo off of an object.
  pinMode(echoPin1, INPUT);
  duration1 = pulseIn(echoPin1, HIGH);
 
  // Convert the time into a distance
  cm1 = (duration1/2) / 29.1;
  if(cm1<20)
  {
    cc1++;  
  }
  }

  //S2
  digitalWrite(trigPin2, LOW);
  delayMicroseconds(5);
  digitalWrite(trigPin2, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin2, LOW);
 
  // Read the signal from the sensor: a HIGH pulse whose
  // duration is the time (in microseconds) from the sending
  // of the ping to the reception of its echo off of an object.
  pinMode(echoPin2, INPUT);
  duration2 = pulseIn(echoPin2, HIGH);
 
  // Convert the time into a distance
  cm2 = (duration2/2) / 29.1;     // Divide by 29.1 or multiply by 0.0343
  //inches = (duration/2) / 74;   // Divide by 74 or multiply by 0.0135
  
 //Serial.print(inches);
 //Serial.print("in, ");
  Serial.print(cm2);
  Serial.println("cm2");
  //Serial.println();
  if(cm2<20)
  {
    cc2++;
    delay(1000);
  digitalWrite(trigPin2, LOW);
  delayMicroseconds(5);
  digitalWrite(trigPin2, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin2, LOW);
 
  // Read the signal from the sensor: a HIGH pulse whose
  // duration is the time (in microseconds) from the sending
  // of the ping to the reception of its echo off of an object.
  pinMode(echoPin2, INPUT);
  duration2 = pulseIn(echoPin2, HIGH);
 
  // Convert the time into a distance
  cm2 = (duration2/2) / 29.1;
  if(cm2<20)
  {
    cc2++;  
  }
  }

  
  if(cc1>cc2)
  {
      digitalWrite(g1, 0);
      digitalWrite(r1, 1);
      digitalWrite(g2, 1);
      digitalWrite(r2, 0);
      digitalWrite(g3, 0);
      digitalWrite(r3, 1);
      digitalWrite(g4, 0);
      digitalWrite(r4, 1);
      delay(10000);
  }
  else if(cc1<cc2)
  {
      digitalWrite(g1, 0);
      digitalWrite(r1, 1);
      digitalWrite(g2, 0);
      digitalWrite(r2, 1);
      digitalWrite(g3, 0);
      digitalWrite(r3, 1);
      digitalWrite(g4, 1);
      digitalWrite(r4, 0);
      delay(10000);
  }
  delay(250); 
}

/*void force()
{
  int x=0;
  while(x!=10)
  {
    x++;
     if(c==1)
    {
      digitalWrite(g1, 1);
      digitalWrite(r1, 0);
      digitalWrite(g2, 0);
      digitalWrite(r2, 1);
      digitalWrite(g3, 0);
      digitalWrite(r3, 1);
      digitalWrite(g4, 0);
      digitalWrite(r4, 1);
      delay(1000);
      t=(t+1)%40;
    }
    else if(c==11)
    {
      digitalWrite(g1, 0);
      digitalWrite(r1, 1);
      digitalWrite(g2, 1);
      digitalWrite(r2, 0);
      digitalWrite(g3, 0);
      digitalWrite(r3, 1);
      digitalWrite(g4, 0);
      digitalWrite(r4, 1);
      delay(1000);
      t=(t+1)%40;
    }
    else if(c==21)
    {
      digitalWrite(g1, 0);
      digitalWrite(r1, 1);
      digitalWrite(g2, 0);
      digitalWrite(r2, 1);
      digitalWrite(g3, 1);
      digitalWrite(r3, 0);
      digitalWrite(g4, 0);
      digitalWrite(r4, 1);
      delay(1000);
      t=(t+1)%40;
    }
    else if(c==31)
    {
      digitalWrite(g1, 0);
      digitalWrite(r1, 1);
      digitalWrite(g2, 0);
      digitalWrite(r2, 1);
      digitalWrite(g3, 0);
      digitalWrite(r3, 1);
      digitalWrite(g4, 1);
      digitalWrite(r4, 0);
      delay(1000);
      t=(t+1)%40;
    
  }
}
check();
}*/

/*void bluetooth()
{
  if(Serial.read()==true)
  {
    char data=Serial.read();
    switch(data)
    {
      case '1':
        if(x==0)
          c=t;
        t=100;
        x=1;
        break;
       case '2':
        if(x==0)
          c=t;
        t=111;
        x=1;
        break;
       case '3':
        if(x==0)
          c=t;
        t=0;
        x=1;
        break;
       case '4':
        if(x==0)
          c=t;
        t=11;
        x=1;
        break;
       case '5':
        if(x==0)
          c=t;
        t=21;
        x=1;
        break;
       case '6':
        if(x==0)
          c=t;
        t=31;
        x=1;
        break;
       case 'z':
          
    }
  }
}*/

void regular()
{
 // if(x=0)
 // {
    //t=c;
 // }
    if(t<=10)
    {
      digitalWrite(g1, 1);
      digitalWrite(r1, 0);
      digitalWrite(g2, 0);
      digitalWrite(r2, 1);
      digitalWrite(g3, 0);
      digitalWrite(r3, 1);
      digitalWrite(g4, 0);
      digitalWrite(r4, 1);
      delay(1000);
      t=(t+1)%40;
    }
    else if(t<=20)
    {
      digitalWrite(g1, 0);
      digitalWrite(r1, 1);
      digitalWrite(g2, 1);
      digitalWrite(r2, 0);
      digitalWrite(g3, 0);
      digitalWrite(r3, 1);
      digitalWrite(g4, 0);
      digitalWrite(r4, 1);
      delay(1000);
      t=(t+1)%40;
    }
    else if(t<=30)
    {
      digitalWrite(g1, 0);
      digitalWrite(r1, 1);
      digitalWrite(g2, 0);
      digitalWrite(r2, 1);
      digitalWrite(g3, 1);
      digitalWrite(r3, 0);
      digitalWrite(g4, 0);
      digitalWrite(r4, 1);
      delay(1000);
      t=(t+1)%40;
    }
    else if(t<=40)
    {
      digitalWrite(g1, 0);
      digitalWrite(r1, 1);
      digitalWrite(g2, 0);
      digitalWrite(r2, 1);
      digitalWrite(g3, 0);
      digitalWrite(r3, 1);
      digitalWrite(g4, 1);
      digitalWrite(r4, 0);
      delay(1000);
      t=(t+1)%40;
  }
}