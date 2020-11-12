package com.example.tickettracker_200290069

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //LOG IN
        button_login_login.setOnClickListener {
            val email = edittext_email_login.text.toString()
            val password = edittext_password_login.text.toString()
        }
        //go to signup page
        textview_signup_login.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}