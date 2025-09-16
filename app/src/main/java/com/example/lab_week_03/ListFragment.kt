package com.example.lab_week_03

import androidx.fragment.app.activityViewModels
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class ListFragment : Fragment(), View.OnClickListener {

    private val vm: CoffeeViewModel by activityViewModels()

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

    override fun onClick(v: View) { vm.select(v.id) }
}
