package com.itpn.layoutmusical

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val verificado = findViewById<ImageButton>(R.id.verificado)
            .setOnClickListener { val audio1 = MediaPlayer.create(this,R.raw.verificado).start() }

        val balonSoccer = findViewById<ImageButton>(R.id.balonSoccer)
            .setOnClickListener { val audio2 = MediaPlayer.create(this,R.raw.gol).start() }

        val camara = findViewById<ImageButton>(R.id.camara)
            .setOnClickListener{ val audio3 = MediaPlayer.create(this,R.raw.photo).start() }

        val campana = findViewById<ImageButton>(R.id.campana)
            .setOnClickListener { val audio4 = MediaPlayer.create(this,R.raw.bell).start() }

        val avion = findViewById<ImageButton>(R.id.avion)
            .setOnClickListener{ val audio5 = MediaPlayer.create(this,R.raw.airplane).start() }

        val block = findViewById<ImageButton>(R.id.block)
            .setOnClickListener { val audio6 = MediaPlayer.create(this,R.raw.block).start() }

        val dinero = findViewById<ImageButton>(R.id.dinero)
            .setOnClickListener { val audio7 = MediaPlayer.create(this,R.raw.cash).start() }

        val corazon = findViewById<ImageButton>(R.id.corazon)
            .setOnClickListener { val audio8 = MediaPlayer.create(this,R.raw.heart).start() }

        val star = findViewById<ImageButton>(R.id.star)
            .setOnClickListener { val audio9 = MediaPlayer.create(this,R.raw.star).start() }
    }

}