package com.example.betulpolyadminapplication.ui.faculity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.betulpolyuserapplication.R
import com.example.betulpolyuserapplication.ui.faculity.TeacherData

class TeacherAdapter : RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {

    private lateinit var teacherData: ArrayList<TeacherData>
    private lateinit var context: Context


    constructor(teacherData: ArrayList<TeacherData> , context: Context) : super() {
        this.teacherData = teacherData
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): TeacherViewAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.faculity_item_layout , parent , false)
        return TeacherViewAdapter(view)
    }

    override fun onBindViewHolder(holder: TeacherViewAdapter , position: Int) {
        val currentItem = teacherData[position]

        holder.name.text = currentItem.name
        holder.email.text = currentItem.email
        holder.post.text = currentItem.post
        try {
            if (currentItem.image != null) {
                Glide.with(context)
                        .load(currentItem.image)
                        .fitCenter()
                        .placeholder(R.drawable.avatarteacher)
                        .into(holder.teacherImage)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    override fun getItemCount(): Int {
        return teacherData.size
    }

    inner class TeacherViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val name: TextView = itemView?.findViewById(R.id.teacherName)
        internal val email: TextView = itemView?.findViewById(R.id.teacherEmail)
        internal val post: TextView = itemView?.findViewById(R.id.teacherPost)
        internal val teacherImage: ImageView = itemView?.findViewById(R.id.faculity_item_teacher_imageview)


    }


}




