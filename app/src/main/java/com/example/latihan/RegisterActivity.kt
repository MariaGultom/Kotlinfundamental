package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)

        val btnRegister:Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnRegister -> {
                val bundle = Bundle()
                bundle.putString("email",edtEmail.text.toString())
                bundle.putString("password",edtPassword.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}