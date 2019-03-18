package com.project.carregister

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.project.carregister.dto.CarRegister
import com.project.carregister.dto.CarRegisterAdapter

class ListCarActivity : Activity() {

    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_car)

        recyclerView = findViewById(R.id.rvListCar)
        recyclerView.layoutManager = LinearLayoutManager(this)


        //val listener = OnClickListener { v ->
          //  val textView = v.findViewById(R.id.tvName)
            //Toast.makeText(this@ListCarActivity, "clicked Item: " + textView.getText(), Toast.LENGTH_LONG).show()
       // }

        recyclerView.adapter = CarRegisterAdapter(carRegisterList)

        val fab = findViewById<FloatingActionButton>(R.id.fabRegisterCar)
        fab.setOnClickListener(View.OnClickListener { view ->
            val carRegisterActivity = Intent(this, CarRegisterActivity::class.java)
            startActivity(carRegisterActivity)
        })


        //R.drawable.car_icon3898
    }

    companion object {

        val carRegisterList = mutableListOf<CarRegister>()

        fun registerCard(carRegister: CarRegister) {
            carRegisterList.add(carRegister)
        }
    }



}
