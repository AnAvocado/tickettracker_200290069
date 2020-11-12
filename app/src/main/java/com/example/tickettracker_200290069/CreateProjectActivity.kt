package com.example.tickettracker_200290069

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_create_project.*

class CreateProjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_project)

        button_create_project.setOnClickListener {
            val projectName = edittext_projectname_createproject.text.toString()
            val projectDesc = edittext_projectdescription_createproject.text.toString()
            FirebaseDatabase.getInstance().getReference("projects")
        }
    }

}