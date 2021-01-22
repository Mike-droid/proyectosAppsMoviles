package com.itpn.usosensor

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(),SensorEventListener {

    private lateinit var sensorManager:SensorManager
    private lateinit var acelerometro:Sensor
    private lateinit var luz:Sensor
    private lateinit var proximidad:Sensor
    private lateinit var temperatura:Sensor
    private lateinit var campoMagnetico:Sensor
    private lateinit var presion:Sensor

    lateinit var valorA: TextView
    lateinit var valorL: TextView
    lateinit var valorP: TextView
    lateinit var valorT: TextView
    lateinit var valorC: TextView
    lateinit var valorPr: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valorA = findViewById(R.id.TVaceleracion)
        valorL = findViewById(R.id.TVluz)
        valorP = findViewById(R.id.TVproximidad)
        valorT = findViewById(R.id.TVTemperatura)
        valorC = findViewById(R.id.TVCampo)
        valorPr = findViewById(R.id.TVPresion)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        //Acelerómetro
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (acelerometro==null){
            Toast.makeText(this,"Dispositivo sin acelerómetro",Toast.LENGTH_SHORT).show()
        }else{
            sensorManager.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_NORMAL)
        }

        //Luz
        luz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        if (luz == null){
            Toast.makeText(this,"Dispositivo sin luz",Toast.LENGTH_SHORT).show()
        }else{
            sensorManager.registerListener(this,luz,SensorManager.SENSOR_DELAY_NORMAL)
        }

        //Proximidad
        proximidad = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        if (proximidad == null){
            Toast.makeText(this,"Dispositivo sin proximidad",Toast.LENGTH_SHORT).show()
        }else{
            sensorManager.registerListener(this,proximidad,SensorManager.SENSOR_DELAY_NORMAL)
        }

        //Temperatura
        temperatura = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)

        if (temperatura == null){
            Toast.makeText(this,"Dispositivo sin temperatura",Toast.LENGTH_SHORT).show()
        }else{
            sensorManager.registerListener(this,temperatura,SensorManager.SENSOR_DELAY_NORMAL)
        }

        //Campo magnético
        campoMagnetico = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

        if (campoMagnetico == null){
            Toast.makeText(this,"Dispositivo sin campo magnético",Toast.LENGTH_SHORT).show()
        }else{
            sensorManager.registerListener(this,campoMagnetico,SensorManager.SENSOR_DELAY_NORMAL)
        }

        //Presión
        presion = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
        if (presion == null){
            Toast.makeText(this,"Dispositivo sin presión",Toast.LENGTH_SHORT).show()
        }else{
            sensorManager.registerListener(this,presion,SensorManager.SENSOR_DELAY_NORMAL)
        }

    }

    override fun onSensorChanged(sensorEvent: SensorEvent){
        //Acelerómetro
        if (sensorEvent.sensor.type == Sensor.TYPE_ACCELEROMETER){
            val m:FloatArray = sensorEvent.values
            valorA.setText("Posiciones en X = ${m[0]} , Y = ${m[1]} , Z = ${m[2]}")
        }

        //Luz
        if (sensorEvent.sensor.type == Sensor.TYPE_LIGHT){
            val lux:Float = sensorEvent.values[0]
            valorL.setText("Intensidad de luz ${lux}")
        }

        //Proximidad
        if (sensorEvent.sensor.type == Sensor.TYPE_PROXIMITY){
            val cm:FloatArray = sensorEvent.values
            valorP.setText("Distancia en cm ${cm[0]}")
            if (cm[0]<5f){
                window.decorView.setBackgroundColor(Color.BLUE)
            }else{
                window.decorView.setBackgroundColor(Color.CYAN)
            }
        }

        //Temperatura
        if (sensorEvent.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE){
            val m:FloatArray = sensorEvent.values
            valorT.setText("Grados centígrados : ${m[0]}°C")
        }

        //Campo magnético
        if (sensorEvent.sensor.type == Sensor.TYPE_MAGNETIC_FIELD){
            val m:FloatArray = sensorEvent.values
            valorC.setText("Presión en micro teslas X:${m[0]}, Y:${m[1]}, Z:${m[2]}")
        }

        //Presión
        if (sensorEvent.sensor.type == Sensor.TYPE_PRESSURE){
            val m:FloatArray = sensorEvent.values
            valorPr.setText("Barómetro: ${m[0]}")
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}