package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment(), View.OnClickListener {

    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) coffeeListener = context
        else throw RuntimeException("$context must implement CoffeeListener")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coffeeList = listOf(
            view.findViewById<TextView>(R.id.affogato),
            view.findViewById<TextView>(R.id.americano),
            view.findViewById<TextView>(R.id.latte)
        )
        coffeeList.forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View?) {
        v?.let { coffeeListener.onSelected(it.id) }
    }
}
