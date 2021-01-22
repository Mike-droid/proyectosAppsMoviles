package com.example.ciclovida

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"ON CREATE",Toast.LENGTH_LONG).show()
        var audio = MediaPlayer.create(this,R.raw.noti)
        audio.start() //Si no pongo esto, no se reproducirá
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"ON START",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"ON RESUME",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"ON PAUSE",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"ON STOP",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        Toast.makeText(this,"ON DESTROY",Toast.LENGTH_LONG).show()
        super.onDestroy()
    }
}