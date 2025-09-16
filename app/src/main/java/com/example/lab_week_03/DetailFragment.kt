
package com.example.lab_week_03

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class DetailFragment : Fragment() {

    private lateinit var vm: CoffeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(requireActivity())[CoffeeViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val title = view.findViewById<TextView>(R.id.coffee_title)
        val desc  = view.findViewById<TextView>(R.id.coffee_desc)
        val back  = view.findViewById<Button>(R.id.btn_back)

        vm.selectedId.observe(viewLifecycleOwner) { id ->
            when (id) {
                R.id.affogato   -> { title.text = getString(R.string.affogato_title);   desc.text = getString(R.string.affogato_desc) }
                R.id.americano  -> { title.text = getString(R.string.americano_title);  desc.text = getString(R.string.americano_desc) }
                R.id.latte      -> { title.text = getString(R.string.latte_title);      desc.text = getString(R.string.latte_desc) }
                R.id.capp       -> { title.text = getString(R.string.capp_title);       desc.text = getString(R.string.capp_desc) }
                R.id.mocha      -> { title.text = getString(R.string.mocha_title);      desc.text = getString(R.string.mocha_desc) }
                R.id.mac        -> { title.text = getString(R.string.mac_title);        desc.text = getString(R.string.mac_desc) }
                R.id.flatwhite  -> { title.text = getString(R.string.flatwhite_title);  desc.text = getString(R.string.flatwhite_desc) }
                R.id.ristretto  -> { title.text = getString(R.string.ristretto_title);  desc.text = getString(R.string.ristretto_desc) }
            }
        }

        back.setOnClickListener {
            vm.clear()
            parentFragmentManager.popBackStack()
        }
    }
}
