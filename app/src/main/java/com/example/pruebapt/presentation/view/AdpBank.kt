package com.example.pruebapt.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebapt.R
import com.example.pruebapt.presentation.BankModel
import com.squareup.picasso.Picasso
import java.lang.Exception

class AdpBank(private val banks: List<BankModel>): RecyclerView.Adapter<AdpBank.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            0 -> R.layout.item_bank
            else -> throw Exception("invalid type")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return banks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(banks[position])
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(info: BankModel) {
            val tvName: TextView = itemView.findViewById(R.id.tvName)
            val tvAge: TextView = itemView.findViewById(R.id.tvAge)
            val tvDesc: TextView = itemView.findViewById(R.id.tvDescription)
            val image: ImageView = itemView.findViewById(R.id.imgBrand)
            //val tvName: TextView = itemView.findViewById(R.id.tvName)
            tvName.text = info.bankName
            tvAge.text = info.age.toString()
            tvDesc.text = info.description
            Picasso.get().load(info.url).into(image)
        }
    }
}