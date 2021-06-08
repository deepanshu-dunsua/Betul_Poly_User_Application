package com.example.betulpolyuserapplication.ui.faculity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.betulpolyadminapplication.ui.faculity.TeacherAdapter
import com.example.betulpolyuserapplication.R
import com.google.firebase.database.*

class FaculityFragment : Fragment() {

    // variable declearation
    private lateinit var csDepartment: RecyclerView
    private lateinit var eeDepartment: RecyclerView
    private lateinit var etDepartment: RecyclerView
    private lateinit var mechDepartment: RecyclerView

    // no dta layout
    private lateinit var csNoData: LinearLayout
    private lateinit var eeNoData: LinearLayout
    private lateinit var etNoData: LinearLayout
    private lateinit var mechNoData: LinearLayout
    private lateinit var principalData: LinearLayout


    //    lisit create
    private lateinit var list1: ArrayList<TeacherData>
    private lateinit var list2: ArrayList<TeacherData>
    private lateinit var list3: ArrayList<TeacherData>
    private lateinit var list4: ArrayList<TeacherData>

    //database refernce variable
    private lateinit var dbreference: DatabaseReference
    private lateinit var reference: DatabaseReference


    override fun onCreateView(
            inflater: LayoutInflater , container: ViewGroup? ,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_faculity , container , false)


        //find recv elemtn by department
        csDepartment = view.findViewById(R.id.csDepartment)
        eeDepartment = view.findViewById(R.id.eeDepartment)
        etDepartment = view.findViewById(R.id.etDepartment)
        mechDepartment = view.findViewById(R.id.mechDepartment)

        // find no data layout
        csNoData = view.findViewById(R.id.csNoData)
        eeNoData = view.findViewById(R.id.eeNoData)
        etNoData = view.findViewById(R.id.etNoData)
        mechNoData = view.findViewById(R.id.mechNoData)
        principalData = view.findViewById(R.id.principalData)


//        firbase refernce
        reference = FirebaseDatabase.getInstance().getReference().child("teacher")


        // recyler view  funcation calling

        loadPrincipalData()
        csDepartment()
        eeDepartment()
        etDepartment()
        mechDepartment()

        return view
    }

    //load principal data fun
    private fun loadPrincipalData() {
        principalData.visibility=View.VISIBLE
    }


    //     csDepartment Recyler function
    fun csDepartment() {
        dbreference = reference?.child("Computer Science")
        dbreference?.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                list1 = ArrayList()
                if (!snapshot.exists()) {
                    csNoData.visibility = View.VISIBLE
                    csDepartment.visibility = View.GONE
                } else {

                    csNoData.visibility = View.GONE
                    csDepartment.visibility = View.VISIBLE
                    for (teacherSnapshot in snapshot.children) {
                        val teacherData = teacherSnapshot.getValue(TeacherData::class.java)
                        if (teacherData != null) {
                            list1.add(teacherData)
                        }
                    }
                    csDepartment.setHasFixedSize(true)
                    csDepartment.layoutManager = LinearLayoutManager(context)
                    val csAdapter = TeacherAdapter(list1 , context!!)
                    csDepartment.adapter = csAdapter


                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!! , error.message , Toast.LENGTH_SHORT)
                        .show()
            }

        })
    }

    //     eeDepartment Recyler function
    fun eeDepartment() {
        dbreference = reference?.child("Electrical Enginering")
        dbreference?.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                list2 = ArrayList()
                if (!snapshot.exists()) {
                    eeNoData.visibility = View.VISIBLE
                    eeDepartment.visibility = View.GONE
                } else {

                    eeNoData.visibility = View.GONE
                    eeDepartment.visibility = View.VISIBLE
                    for (teacherSnapshot in snapshot.children) {
                        val teacherData = teacherSnapshot.getValue(TeacherData::class.java)
                        if (teacherData != null) {
                            list2.add(teacherData)
                        }
                    }
                    eeDepartment.setHasFixedSize(true)
                    eeDepartment.layoutManager = LinearLayoutManager(context!!)
                    val eeAdapter = TeacherAdapter(list2 , context!!)
                    eeDepartment.adapter = eeAdapter


                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context , error.message , Toast.LENGTH_SHORT)
                        .show()
            }

        })
    }

    //     etDepartment Recyler function
    fun etDepartment() {
        dbreference = reference?.child("ET Enginering")
        dbreference?.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                list3 = ArrayList()
                if (!snapshot.exists()) {
                    etNoData.visibility = View.VISIBLE
                    etDepartment.visibility = View.GONE
                } else {

                    etNoData.visibility = View.GONE
                    etDepartment.visibility = View.VISIBLE
                    for (teacherSnapshot in snapshot.children) {
                        val teacherData = teacherSnapshot.getValue(TeacherData::class.java)
                        if (teacherData != null) {
                            list3.add(teacherData)
                        }
                    }
                    etDepartment.setHasFixedSize(true)
                    etDepartment.layoutManager = LinearLayoutManager(context!!)
                    val etAdapter = TeacherAdapter(list3 , context!!)
                    etDepartment.adapter = etAdapter

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!! , error.message , Toast.LENGTH_SHORT)
                        .show()
            }

        })
    }

    //     mechDepartment Recyler function
    fun mechDepartment() {
        dbreference = reference?.child("Mechanical Enginering")
        dbreference?.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                list4 = ArrayList()
                if (!snapshot.exists()) {
                    mechNoData.visibility = View.VISIBLE
                    mechDepartment.visibility = View.GONE
                } else {

                    mechNoData.visibility = View.GONE
                    mechDepartment.visibility = View.VISIBLE
                    for (teacherSnapshot in snapshot.children) {
                        val teacherData = teacherSnapshot.getValue(TeacherData::class.java)
                        if (teacherData != null) {
                            list4.add(teacherData)
                        }
                    }
                    mechDepartment.setHasFixedSize(true)
                    mechDepartment.layoutManager = LinearLayoutManager(context!!)
                    val mechAdapter = TeacherAdapter(list4 , context!!)
                    mechDepartment.adapter = mechAdapter

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context!! , error.message , Toast.LENGTH_SHORT)
                        .show()
            }
        })
    }


}
