package com.example.lab_week_03

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels // not used here, avoid
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var vm: CoffeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[CoffeeViewModel::class.java]

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, ListFragment())
            }
        }

        // Saat item dipilih, tampilkan DetailFragment dan taruh ke back stack
        vm.selectedId.observe(this) { id ->
            if (id != null) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    setCustomAnimations(
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right,
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right
                    )
                    replace(R.id.fragment_container, DetailFragment())
                    addToBackStack("detail")
                }
            }
        }

        // Handle tombol back: kembali ke list
        onBackPressedDispatcher.addCallback(this) {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
                vm.clear()
            } else finish()
        }
    }
}
