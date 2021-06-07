package com.example.betulpolyuserapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        splash screen action bar hideeen
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()//splash screen title bar  bar hideeen
        setContentView(R.layout.activity_splash_screen)


        // splash  screen code
        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity , MainActivity::class.java)
            startActivity(intent)
            finish()
        } , 2000)

    }
}