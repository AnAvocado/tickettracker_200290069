package com.nivium.tickettracker_200290069

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
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
            val projectOwner = Firebase.auth.currentUser?.email.toString()
            val project = hashMapOf(
                "project_name" to projectName,
                "project_description" to projectDesc,
                "project_owner" to projectOwner
            )

            db.collection("projects")
                .add(project)
                .addOnSuccessListener { documentReference ->
                Log.d("Success", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
                .addOnFailureListener { e ->
                    Log.w("Failure", "Error adding document", e)
                }
            val intent = Intent(this, ProjectListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}