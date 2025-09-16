package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment(), View.OnClickListener {

    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) coffeeListener = context
        else throw RuntimeException("$context must implement CoffeeListener")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOf(
            view.findViewById<TextView>(R.id.affogato),
            view.findViewById<TextView>(R.id.americano),
            view.findViewById<TextView>(R.id.latte)
        ).forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View) {
        coffeeListener.onSelected(v.id)
    }
}
