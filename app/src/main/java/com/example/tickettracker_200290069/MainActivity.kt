package com.example.tickettracker_200290069

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)

        button_create_project.setOnClickListener {
            val intent = Intent(this, CreateProjectActivity::class.java)
            startActivity(intent)
        }
        button_join_project.setOnClickListener {
            val intent = Intent(this, JoinProjectActivity::class.java)
            startActivity(intent)
        }
        button_view_projects.setOnClickListener {
            val intent = Intent(this, ProjectListActivity::class.java)
            startActivity(intent)
        }
        TODO()
        /*
        1. Finish Create project activity. Allow users to create a project and view it in the recycler view. *do not worry about making projects unique at this time, just let anybody view the project*
        2. Investigate FirebaseAuth error.
        3. Project View -



         */
    }
}