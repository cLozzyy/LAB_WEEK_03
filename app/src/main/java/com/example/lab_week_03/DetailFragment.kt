package com.example.lab_week_03


import androidx.fragment.app.activityViewModels

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class DetailFragment : Fragment() {

    private val vm: CoffeeViewModel by activityViewModels()
    private val title get() = view?.findViewById<TextView>(R.id.coffee_title)
    private val desc  get() = view?.findViewById<TextView>(R.id.coffee_desc)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.selectedId.observe(viewLifecycleOwner) { id ->
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
}
