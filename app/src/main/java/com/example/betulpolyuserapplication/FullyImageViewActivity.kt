package com.example.betulpolyuserapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView

class FullyImageViewActivity : AppCompatActivity() {

    //variable decleration ...
    private lateinit var image: String
    private lateinit var fullyImageView: PhotoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fully_image_view)

        //action bar
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = "${R.string.app_name.toString()}"


        // get intent data
        image = intent.getStringExtra("image")

        //find element
        fullyImageView = findViewById(R.id.fullyImageView)


        // set image into image view
        try {
            Glide.with(this).load(image).into(fullyImageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

}