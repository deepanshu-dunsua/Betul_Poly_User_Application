package com.example.betulpolyuserapplication.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.betulpolyuserapplication.R
import com.google.firebase.database.*

class GalleryFragment : Fragment() {

    //rcv varible declearation

    private lateinit var convvacationDayRcv: RecyclerView
    private lateinit var independencedDayRcv: RecyclerView
    private lateinit var republicDayRcv: RecyclerView
    private lateinit var vaotingDayRcv: RecyclerView
    private lateinit var fandfDayRcv: RecyclerView
    private lateinit var ganeshUstsavDayRcv: RecyclerView
    private lateinit var swatchDayRcv: RecyclerView

    //rcv dapter varible
    private lateinit var galleryAdapter: GalleryAdapter


    //database refernce variable
    private lateinit var dbreference: DatabaseReference
    private lateinit var reference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        //rcv variable initalization
        convvacationDayRcv = view.findViewById(R.id.convacationRcv)
        independencedDayRcv = view.findViewById(R.id.independenceRcv)
        republicDayRcv = view.findViewById(R.id.republicdayRcv)
        vaotingDayRcv = view.findViewById(R.id.votingDayRcv)
        fandfDayRcv = view.findViewById(R.id.fandfRcv)
        ganeshUstsavDayRcv = view.findViewById(R.id.gdayRcv)
        swatchDayRcv = view.findViewById(R.id.sday)

        // firbase refernce
        reference = FirebaseDatabase.getInstance().getReference().child("gallery")


        //set images as recycler view->funcation
        getconvvacationDacyImage()
        getindependencedDayRcvImage()
        getrepublicDayRcvImage()
        getvaotingDayRcvImage()
        getFandFdayImage()
        getganeshUstsavDayRcvImage()
        getswatchDayRcvImage()

        return view

    }


    //  f1 .get  image  as firbase and set image as recyler view
    private fun getconvvacationDacyImage() {
        reference.child("Convecation Day")?.addValueEventListener(object : ValueEventListener {

            //list crataion
            val imageslist: ArrayList<String>? = ArrayList()

            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (Snapshot in datasnapshot.children) {
                    val data = Snapshot.getValue() as String
                    if (data != null) {
                        imageslist?.add(data)
                    }
                }
                galleryAdapter = GalleryAdapter(context!!, imageslist)
                convvacationDayRcv.layoutManager = GridLayoutManager(context!!, 3)
                convvacationDayRcv.adapter = galleryAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!!, error.message, Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

    //  f2 .get  image  as firbase and set image as recyler view
    private fun getindependencedDayRcvImage() {
        reference.child("Inadependence Day")?.addValueEventListener(object : ValueEventListener {

            //list crataion
            val imageslist: ArrayList<String>? = ArrayList()

            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (Snapshot in datasnapshot.children) {
                    val data = Snapshot.getValue() as String
                    if (data != null) {
                        imageslist?.add(data)
                    }
                }
                galleryAdapter = GalleryAdapter(context!!, imageslist)
                independencedDayRcv.layoutManager = GridLayoutManager(context!!, 3)
                independencedDayRcv.adapter = galleryAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!!, error.message, Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

    //  f3.get  image  as firbase and set image as recyler view
    private fun getrepublicDayRcvImage() {
        reference.child("Republic Day")?.addValueEventListener(object : ValueEventListener {

            //list crataion
            val imageslist: ArrayList<String>? = ArrayList()

            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (Snapshot in datasnapshot.children) {
                    val data = Snapshot.getValue() as String
                    if (data != null) {
                        imageslist?.add(data)
                    }
                }
                galleryAdapter = GalleryAdapter(context!!, imageslist)
                republicDayRcv.layoutManager = GridLayoutManager(context!!, 3)
                republicDayRcv.adapter = galleryAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!!, error.message, Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

    //  f4.get  image  as firbase and set image as recyler view
    private fun getvaotingDayRcvImage() {
        reference.child("Voting Campine")?.addValueEventListener(object : ValueEventListener {

            //list crataion
            val imageslist: ArrayList<String>? = ArrayList()

            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (Snapshot in datasnapshot.children) {
                    val data = Snapshot.getValue() as String
                    if (data != null) {
                        imageslist?.add(data)
                    }
                }
                galleryAdapter = GalleryAdapter(context!!, imageslist)
                vaotingDayRcv.layoutManager = GridLayoutManager(context!!, 3)
                vaotingDayRcv.adapter = galleryAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!!, error.message, Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

    //  f5.get  image  as firbase and set image as recyler view
    private fun getFandFdayImage() {
        reference.child("Fresher and Farwall")?.addValueEventListener(object : ValueEventListener {

            //list crataion
            val imageslist: ArrayList<String>? = ArrayList()

            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (Snapshot in datasnapshot.children) {
                    val data = Snapshot.getValue() as String
                    if (data != null) {
                        imageslist?.add(data)
                    }
                }
                galleryAdapter = GalleryAdapter(context!!, imageslist)
                fandfDayRcv.layoutManager = GridLayoutManager(context!!, 3)
                fandfDayRcv.adapter = galleryAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!!, error.message, Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

 //  f6 get  image  as firbase and set image as recyler view
    private fun getganeshUstsavDayRcvImage() {
        reference.child("Ganesh Utsav")?.addValueEventListener(object : ValueEventListener {

            //list crataion
            val imageslist: ArrayList<String>? = ArrayList()

            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (Snapshot in datasnapshot.children) {
                    val data = Snapshot.getValue() as String
                    if (data != null) {
                        imageslist?.add(data)
                    }
                }
                galleryAdapter = GalleryAdapter(context!!, imageslist)
                ganeshUstsavDayRcv.layoutManager = GridLayoutManager(context!!, 3)
                ganeshUstsavDayRcv.adapter = galleryAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!!, error.message, Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

//  f7get  image  as firbase and set image as recyler view
    private fun getswatchDayRcvImage() {
        reference.child("Swach Bharat")?.addValueEventListener(object : ValueEventListener {

            //list crataion
            val imageslist: ArrayList<String>? = ArrayList()

            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (Snapshot in datasnapshot.children) {
                    val data = Snapshot.getValue() as String
                    if (data != null) {
                        imageslist?.add(data)
                    }
                }
                galleryAdapter = GalleryAdapter(context!!, imageslist)
                swatchDayRcv.layoutManager = GridLayoutManager(context!!, 3)
                swatchDayRcv.adapter = galleryAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!!, error.message, Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }



}