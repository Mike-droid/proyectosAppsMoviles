package com.itpn.variosenuno

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckedTextView
import android.widget.ProgressBar

class TasksToDo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks_to_do)

        val pb: ProgressBar = findViewById(R.id.pb)
        //pb.max=5

        var contador:Int = 0

        val ctv1:CheckedTextView = findViewById(R.id.ctv1)
        ctv1.setOnClickListener {
            ctv1.toggle()
            if (ctv1.isChecked){
                contador++
                pb.progress = contador
            }else{
                contador--
                pb.progress = contador
            }
        }

        val ctv2:CheckedTextView = findViewById(R.id.ctv2)
        ctv2.setOnClickListener {
            ctv2.toggle()
            if (ctv2.isChecked){
                contador++
                pb.progress = contador
            }else{
                contador--
                pb.progress = contador
            }
        }

        val ctv3:CheckedTextView = findViewById(R.id.ctv3)
        ctv3.setOnClickListener {
            ctv3.toggle()
            if (ctv3.isChecked){
                contador++
                pb.progress = contador
            }else{
                contador--
                pb.progress = contador
            }
        }

        val ctv4:CheckedTextView = findViewById(R.id.ctv4)
        ctv4.setOnClickListener {
            ctv4.toggle()
            if (ctv4.isChecked){
                contador++
                pb.progress = contador
            }else{
                contador--
                pb.progress = contador
            }
        }

        val ctv5:CheckedTextView = findViewById(R.id.ctv5)
        ctv5.setOnClickListener {
            ctv5.toggle()
            if (ctv5.isChecked){
                contador++
                pb.progress = contador
            }else{
                contador--
                pb.progress = contador
            }
        }
    }
}