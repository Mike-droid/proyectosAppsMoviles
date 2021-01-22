package com.itpn.usowebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity2 : AppCompatActivity() {

    lateinit var miWebView:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        miWebView = findViewById(R.id.webView)
        miWebView.loadUrl("file:///android_asset/prueba.html")
    }
}