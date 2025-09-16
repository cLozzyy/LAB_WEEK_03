
package com.example.lab_week_03

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ListFragment : Fragment(), View.OnClickListener {

    private lateinit var vm: CoffeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(requireActivity())[CoffeeViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listOf(
            R.id.affogato, R.id.americano, R.id.latte,
            R.id.capp, R.id.mocha, R.id.mac, R.id.flatwhite, R.id.ristretto
        ).map { view.findViewById<TextView>(it) }.forEach { it.setOnClickListener(this) }
    }

    override fun onClick(v: View) { vm.select(v.id) }
}
