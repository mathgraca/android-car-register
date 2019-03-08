package com.project.carregister.dto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.project.carregister.R
import kotlinx.android.synthetic.main.car_register.view.*

data class CarRegister(
    @DrawableRes
    val imageResourceId : Int,
    val brand : String,
    val year : Int,
    var name : String,
    var note : String
)

class CarRegisterAdapter(val carRegisterList : List<CarRegister>) : RecyclerView.Adapter<CarRegisterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_register, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carRegisterList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(carRegisterList.get(position))
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(carReister : CarRegister) = with(itemView) {
            ivCar.setImageResource(carReister.imageResourceId)
            tvBrand.text = carReister.brand
            tvYear.text = carReister.year.toString()
            tvName.text = carReister.name
            tvNote.text = carReister.note

        }

    }

}