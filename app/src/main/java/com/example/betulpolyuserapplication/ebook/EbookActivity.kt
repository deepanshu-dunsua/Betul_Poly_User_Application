package com.example.betulpolyuserapplication.ebook

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.betulpolyuserapplication.R
import com.google.firebase.database.*

class EbookActivity : AppCompatActivity() {

    //variable decleare
    private lateinit var ebookRcv: RecyclerView
    private lateinit var prgBar: ProgressBar
    private lateinit var dbreference: DatabaseReference

    //lisit
    private lateinit var list: ArrayList<EbookData>
    private lateinit var ebookAdapter: EbookAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ebook)

        //action bar
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = "ebook"

        //find element
        ebookRcv = findViewById(R.id.ebookRcv)
        prgBar = findViewById(R.id.progressBar)


        //firbase refernce
        dbreference = FirebaseDatabase.getInstance().getReference().child("pdf")


        getData()


    }

    //fetch data from firbase
    private fun getData() {
        dbreference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list = ArrayList()
                for (snapShot in dataSnapshot.children) {
                    val data = snapShot.getValue(EbookData::class.java)
                    list.add(data!!)
                }

                ebookAdapter = EbookAdapter(this@EbookActivity, list)
                ebookRcv.layoutManager = LinearLayoutManager(this@EbookActivity)
                ebookRcv.adapter = ebookAdapter

                //hide prg
                prgBar.visibility = View.GONE


            }

            override fun onCancelled(error: DatabaseError) {
                prgBar.visibility = View.GONE
                Toast.makeText(this@EbookActivity, "${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}