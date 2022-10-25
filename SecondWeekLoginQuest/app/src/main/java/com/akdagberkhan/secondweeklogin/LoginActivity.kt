package com.akdagberkhan.secondweeklogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class LoginActivity : AppCompatActivity() {

    private lateinit var imgChangeVisibility : ImageView
    private lateinit var edtPassword : EditText
    private lateinit var btnSignUp : Button
    private var isVisibilityOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtPassword = findViewById(R.id.etPass)
        imgChangeVisibility = findViewById(R.id.ivVisibility)
        btnSignUp= findViewById(R.id.btnSignUp)


        imgChangeVisibility.setOnClickListener {
            if(isVisibilityOn)
            {
                imgChangeVisibility.setImageResource(R.drawable.ic_baseline_visibility_24)
                isVisibilityOn= false
                edtPassword.inputType=InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            else{
                imgChangeVisibility.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                isVisibilityOn = true
                edtPassword.inputType=InputType.TYPE_TEXT_VARIATION_NORMAL
            }
        }

        btnSignUp.setOnClickListener {

                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
        }

    }
}