package com.example.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)

        val bundle = intent.extras
        if (bundle !=null) {
            edtEmail.setText(bundle.getString("email"))
            edtPassword.setText(bundle.getString("password"))
        }

        val btnLogin:Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLogin -> {
                val user = User(edtEmail.text.toString(), edtPassword.text.toString())
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
        }
    }
}