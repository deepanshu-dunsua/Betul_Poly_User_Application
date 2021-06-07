package com.example.betulpolyuserapplication.ui.gallery

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.betulpolyuserapplication.FullyImageViewActivity
import com.example.betulpolyuserapplication.R


class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.GalleryViewAdapter> {

    private lateinit var context: Context
    private lateinit var imageslist: ArrayList<String>

    constructor(context: Context , imageslist: ArrayList<String>?) : super() {
        this.context = context
        this.imageslist = imageslist!!
    }


    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): GalleryViewAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_image , parent , false)
        return GalleryViewAdapter(view)
    }

    override fun onBindViewHolder(holder: GalleryViewAdapter , position: Int) {
        try {
            Glide.with(context).load(imageslist.get(position)).placeholder(R.drawable.avatarteacher).into(holder.imageView)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        holder.imageView.setOnClickListener {
            val intent = Intent(context!! , FullyImageViewActivity::class.java)
            intent.putExtra("image" , imageslist.get(position))
            context.startActivities(arrayOf(intent))
        }
    }

    override fun getItemCount(): Int {
        return imageslist.size

    }

    inner class GalleryViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)

    }

}