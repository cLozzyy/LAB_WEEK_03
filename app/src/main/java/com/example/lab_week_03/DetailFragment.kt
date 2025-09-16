package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private val title get() = view?.findViewById<TextView>(R.id.coffee_title)
    private val desc  get() = view?.findViewById<TextView>(R.id.coffee_desc)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_detail, container, false)

    fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                title?.text = getString(R.string.affogato_title)
                desc?.text  = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                title?.text = getString(R.string.americano_title)
                desc?.text  = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                title?.text = getString(R.string.latte_title)
                desc?.text  = getString(R.string.latte_desc)
            }
        }
    }
}
