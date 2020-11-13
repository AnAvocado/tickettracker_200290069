package com.example.tickettracker_200290069

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_create_project.*

class CreateProjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project)
        val db = Firebase.firestore
        button_create_project.setOnClickListener {
            val projectName = edittext_projectname_createproject.text.toString()
            val projectDesc = edittext_projectdescription_createproject.text.toString()
            val project = hashMapOf(
                "project_name" to projectName,
                "project_description" to projectDesc
            )

            db.collection("projects")
                .add(project)
                .addOnSuccessListener { documentReference ->
                Log.d("Success", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
                .addOnFailureListener { e ->
                    Log.w("Failure", "Error adding document", e)
                }
        }
    }

}