package com.example.betulpolyuserapplication.ui.news_feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.betulpolyuserapplication.R
import com.google.firebase.database.*


class NewsFeedFragment : Fragment() {

    //variable declearation
    private lateinit var noticeRcv: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var noticeList: ArrayList<NoticeData>
    private lateinit var adapter: NoticeAdapter
    private lateinit var reference: DatabaseReference

    override fun onCreateView(
            inflater: LayoutInflater , container: ViewGroup? ,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news_feed , container , false)


        //find element or varibale initalization
        noticeRcv = view.findViewById(R.id.notice_recv)
        progressBar = view.findViewById(R.id.progressBar)

        //firbase database ref
        reference = FirebaseDatabase.getInstance().getReference().child("Notice")

        noticeRcv.layoutManager = LinearLayoutManager(context)
        noticeRcv.setHasFixedSize(true)

        //calling a fun
        getNotice()

        return view
    }


    //get notice value  and fetch notice  posoition and remove caerd
    private fun getNotice() {

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                //initalizataion lisit
                noticeList = ArrayList()

                // get lisit data
                for (noticeSnapshot in snapshot.children) {
                    val data = noticeSnapshot.getValue(NoticeData::class.java)
                    if (data != null) {
                        noticeList?.add(0,data)// o th index to  add new data -> top of the my lisit 
                    }
                }
                //set adapter
                adapter = NoticeAdapter(context!! , noticeList)
                adapter.notifyDataSetChanged()

                //prgressbar visibility
                progressBar?.visibility = View.GONE

                noticeRcv.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                //prgressbar visibility
                progressBar?.visibility = View.GONE
                Toast.makeText(context , "${error.message}" , Toast.LENGTH_SHORT).show()
            }
        })
    }
}


