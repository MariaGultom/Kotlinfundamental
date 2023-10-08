package com.example.latihan

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.latihan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragmentA.setOnClickListener { replaceFragment(FragmentA()) }
        binding.btnFragmentB.setOnClickListener { replaceFragment(FragmentB()) }

        textView = findViewById(R.id.textView5)

        val user = intent.getParcelableExtra<User>("user")

        textView.text = "$user"
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}