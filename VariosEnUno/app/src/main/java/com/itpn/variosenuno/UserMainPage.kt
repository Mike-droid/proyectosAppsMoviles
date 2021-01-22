package com.itpn.variosenuno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserMainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main_page)
    }

    fun OpenTasks1(v: View){
        val intento1:Intent = Intent(this,TasksToDo::class.java)
        startActivity(intento1)
    }

}