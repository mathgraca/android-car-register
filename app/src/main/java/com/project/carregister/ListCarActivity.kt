package com.project.carregister

import android.os.Bundle
import android.app.Activity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.carregister.dto.CarRegister
import com.project.carregister.dto.CarRegisterAdapter

class ListCarActivity : Activity() {
    val carRegisterList = mutableListOf<CarRegister>()
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_car)

        carRegisterList.add(CarRegister(R.drawable.car, "Ford", 2014, "Fiat", "Dandan odna dna ndnd odn nd"))
        carRegisterList.add(CarRegister(R.drawable.car, "207", 2012, "Pedgeout", "Dandan odna dna ndnd odn nd"))

        recyclerView = findViewById(R.id.rvListCar)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //val listener = OnClickListener { v ->
          //  val textView = v.findViewById(R.id.tvName)
            //Toast.makeText(this@ListCarActivity, "clicked Item: " + textView.getText(), Toast.LENGTH_LONG).show()
       // }

        recyclerView.adapter = CarRegisterAdapter(carRegisterList)


        //R.drawable.car_icon3898
    }



}
