package com.example.betulpolyuserapplication.ui.news_feed


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.betulpolyuserapplication.FullyImageViewActivity
import com.example.betulpolyuserapplication.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class NoticeAdapter : RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {

    private var context: Context
    private var noticList: ArrayList<NoticeData>

    constructor(context: Context , noticList: ArrayList<NoticeData>) : super() {
        this.context = context
        this.noticList = noticList
    }


    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): NoticeViewAdapter {
        val view: View = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout , parent , false)
        return NoticeViewAdapter(view)
    }

    override fun onBindViewHolder(holder: NoticeViewAdapter , position: Int) {

        val currentItem = noticList[position]

        holder.noticeTitle.text = currentItem.title
        holder.date.text = currentItem.date
        holder.time.text = currentItem.time

        try {
            if (currentItem.image != null) {
                Glide.with(context).load(currentItem.image).fitCenter().placeholder(R.drawable.joshuadevloper1).into(holder.noticeImage)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        holder.noticeImage.setOnClickListener{
            val intent=Intent(context!!,FullyImageViewActivity::class.java)
            intent.putExtra("image",currentItem.image)
            context.startActivities(arrayOf(intent))
        }

    }

    override fun getItemCount(): Int {
        return noticList.size
    }

    inner class NoticeViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {


        internal val noticeTitle: TextView = itemView.findViewById(R.id.noticeTitle)
        internal val noticeImage: ImageView = itemView.findViewById(R.id.noticeImage)
        internal val date: TextView = itemView.findViewById(R.id.date)
        internal val time: TextView = itemView.findViewById(R.id.time)


    }
}