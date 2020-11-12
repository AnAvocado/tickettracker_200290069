package com.example.tickettracker_200290069

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

//        SIGN UP BUTTON
        button_signup_register.setOnClickListener {
            //Grab values
            val password = edittext_password_register.text.toString()
            val email = edittext_email_register.text.toString()

            //HANDLE EMPTY FIELDS
            if(email.isEmpty() || password.isEmpty()){
                val t = Toast.makeText(applicationContext, "Both fields are required", Toast.LENGTH_LONG)
                t.show()
                return@setOnClickListener
            }
            //HANDLE FIREBASE PASSWORD MINIMUM REQUIREMENTS
            //Default firebase exception is the password needs to be 6 or more chars
            if (password.length < 6){
                val t = Toast.makeText(applicationContext, "Password needs to be 6 or more characters", Toast.LENGTH_LONG)
                t.show()
            }else{
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                    else if (it.isSuccessful) {
                        val t = Toast.makeText(
                            applicationContext,
                            "Creation Successful!",
                            Toast.LENGTH_SHORT
                        )
                        t.show()
                        return@addOnCompleteListener
                    }
                }
        }
//        NAV TO LOGIN PAGE BUTTON
        textview_have_account.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}