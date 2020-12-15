package com.example.tickettracker_200290069

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //LOG IN
        button_login_login.setOnClickListener {
            val t = Toast.makeText(
                applicationContext,
                "Logging you in - this may take a few seconds.",
                Toast.LENGTH_LONG
            )
            t.show()
            val email = edittext_email_login.text.toString()
            val password = edittext_password_login.text.toString()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) {
                        val t = Toast.makeText(
                            applicationContext,
                            "There was a problem logging you in",
                            Toast.LENGTH_LONG
                        )
                        t.show()
                        return@addOnCompleteListener

                    }else if(it.isSuccessful) {
                        val t = Toast.makeText(
                            applicationContext,
                            "Welcome ${email}!",
                            Toast.LENGTH_LONG
                        )
                        t.show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        return@addOnCompleteListener
                    }
                }
        }
        //go to signup page
        textview_signup_login.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}