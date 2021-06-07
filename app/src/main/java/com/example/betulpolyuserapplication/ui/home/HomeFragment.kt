package com.example.betulpolyuserapplication.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.betulpolyuserapplication.R
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView


class HomeFragment : Fragment() {

    //image arrayn delcleraration
    var images= intArrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.im4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
    )
    //slider view
    lateinit var sliderView: SliderView

    // google map  image view
    lateinit var map:ImageView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_home, container, false)

        // find slider
        sliderView = view.findViewById(R.id.image_slider)

        // create adapter class and some method s call
        val sliderAdapter = SliderAdapter(images)

        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        sliderView.startAutoCycle()


        // find  gmap image view
        map=view.findViewById(R.id.gmap)

        // clik image view and open google aplication and find gpc loaction code here ..
        map.setOnClickListener{
            openMap()
        }




        return view
    }

    // open map application ..
    private fun openMap() {
        val uri=Uri.parse("geo:0,0?q=Government polytechnic college sonagathi betul Madhya pradesh")
        val intent=Intent(Intent.ACTION_VIEW,uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }



}



