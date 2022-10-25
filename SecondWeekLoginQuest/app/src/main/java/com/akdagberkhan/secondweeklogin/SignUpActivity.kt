package com.akdagberkhan.secondweeklogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class SignUpActivity : AppCompatActivity() {

    private lateinit var ivBack : ImageView
    private lateinit var btnRegister : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        ivBack = findViewById(R.id.ivBack)
        btnRegister = findViewById(R.id.btnSignUp)
        ivBack.setOnClickListener {

            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        btnRegister.setOnClickListener {

            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}