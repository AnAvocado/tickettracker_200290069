package com.example.tickettracker_200290069

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_create_project.setOnClickListener {
            val intent = Intent(this, CreateProjectActivity::class.java)
            startActivity(intent)
            Log.d("Test", "Is this working?")
        }
        button_join_project.setOnClickListener {
            val intent = Intent(this, JoinProjectActivity::class.java)
            startActivity(intent)
        }
        button_view_projects.setOnClickListener {
            val intent = Intent(this, ProjectListActivity::class.java)
            startActivity(intent)
        }

    }
}