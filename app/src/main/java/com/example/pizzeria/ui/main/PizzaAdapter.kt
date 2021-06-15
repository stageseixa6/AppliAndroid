package com.example.pizzeria.ui.main

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzeria.R

class PizzaAdapter(
    cxt: Activity,
    var data: ArrayList<Commande>
) : RecyclerView.Adapter<PizzaAdapter.VH>() {

    override fun getItemCount(): Int {
    return data.size
}

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VH {
        val view = inflater.inflate(R.layout.list_item, null)

        return VH(view)
    }

    override fun onBindViewHolder(vh: VH, i: Int) {
        vh.clientTxt.text = data[i].client
        vh.pizzaTxt.text = data[i].pizza
        vh.creneauTxt.text = data[i].creneau

    }

    private val inflater: LayoutInflater

    init {
        this.inflater = cxt.layoutInflater
    }
    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var clientTxt: TextView
        var pizzaTxt: TextView
        var creneauTxt: TextView

        init {

            clientTxt = itemView.findViewById(R.id.client)
            pizzaTxt = itemView.findViewById(R.id.pizza)
            creneauTxt = itemView.findViewById(R.id.creneau)
        }
    }
}
