package com.example.pizzeria.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzeria.R
import com.example.pizzeria.databinding.MainFragmentBinding


class CommandeActvity : AppCompatActivity(){

    lateinit var binding : MainFragmentBinding

    val data = ArrayList<Commande>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.main_fragment)

        binding = MainFragmentBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        // fake
        data.add(Commande("Gregory", "Reine", "17:45"))
        data.add(Commande("Lucas", "hawaienne", "18:00"))
        data.add(Commande("Frédérique", "Quatres Fromages", "18:15"))
        data.add(Commande("Paul", "Peperonni", "15:45"))
        data.add(Commande("Patrick", "Saumon", "13:30"))

        binding.CommandesRv.adapter = PizzaAdapter(this, data)

        binding.CommandesRv.layoutManager = LinearLayoutManager(this)


    }
}
