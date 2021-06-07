package com.example.betulpolyuserapplication.developer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.betulpolyuserapplication.R
import kotlinx.android.synthetic.main.activity_developer.*

class DeveloperActivity : AppCompatActivity() {

    //variabel decleration
    internal var number: String? = "9424479272"
    private lateinit var contactBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)

        //action bar code
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = "Developer"

        //find element
        contactBtn = button_contact_us

//     contactBtn setOnClickListener event
        contactBtn.setOnClickListener {

            //dialer intent
            val intent = Intent(Intent.ACTION_DIAL , Uri.parse("tel:${Uri.encode(number)}}"))
            startActivity(intent)

        }

    }
}