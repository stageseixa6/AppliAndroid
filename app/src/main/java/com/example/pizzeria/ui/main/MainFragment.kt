package com.example.pizzeria.ui.main

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzeria.MainActivity
import com.example.pizzeria.R
import com.example.pizzeria.databinding.MainFragmentBinding

class MainFragment : Fragment(), PizzaAdapter.OnItemClickListener {

    lateinit var binding : MainFragmentBinding
    val data = ArrayList<Commande>()
    private val adapter = PizzaAdapter(requireActivity(), data, this)

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(layoutInflater)

        val view = binding.root

        // return inflater.inflate(R.layout.main_fragment, container, false)
        return view
    }

    override fun OnItemClick(position: Int) {
        data.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)



        // fake
        data.add(Commande("Gregory", "Reine", "17:45"))
        data.add(Commande("Lucas", "hawaienne", "18:00"))
        data.add(Commande("Frédérique", "Quatres Fromages", "18:15"))
        data.add(Commande("Paul", "Peperonni", "15:45"))
        data.add(Commande("Patrick", "Saumon", "11:30"))

        binding.CommandesRv.adapter = PizzaAdapter(requireActivity(), data, this)

        binding.CommandesRv.layoutManager = LinearLayoutManager(requireActivity())

        /*val btn_button= getView()?.findViewById<Button>(R.id.supprimerData)
        btn_button?.setOnClickListener{

    }*/

    }

}