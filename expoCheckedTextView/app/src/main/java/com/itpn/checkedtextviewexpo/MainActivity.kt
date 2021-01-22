package com.itpn.checkedtextviewexpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckedTextView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvt1:CheckedTextView = findViewById(R.id.ctv1)
        cvt1.setOnClickListener { cvt1.toggle() }

        val cvt2:CheckedTextView = findViewById(R.id.ctv2)
        cvt2.setOnClickListener { cvt2.toggle() }

        val cvt3:CheckedTextView = findViewById(R.id.ctv3)
        cvt3.setOnClickListener { cvt3.toggle() }
    }
}