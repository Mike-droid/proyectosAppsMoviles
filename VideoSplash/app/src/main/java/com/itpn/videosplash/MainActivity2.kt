package com.itpn.videosplash

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val videoView:VideoView = findViewById(R.id.videoView)

        val ruta:Uri = Uri.parse("android.resource://${packageName}/${R.raw.video}")

        val mediaController = MediaController(this)

        videoView.setMediaController(mediaController)

        videoView.setVideoURI(ruta)

        videoView.start()
    }
}