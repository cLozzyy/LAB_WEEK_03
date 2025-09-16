package com.example.lab_week_03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), CoffeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListFragment())
                .commit()
        }
    }

    override fun onSelected(id: Int) {
        val detail = DetailFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detail)
            .addToBackStack(null)
            .commit()
        // panggil setelah view dibuat; aman dengan post di main thread
        window.decorView.post { detail.setCoffeeData(id) }
    }
}
