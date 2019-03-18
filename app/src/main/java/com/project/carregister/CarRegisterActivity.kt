package com.project.carregister

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import com.project.carregister.dto.CarRegister

class CarRegisterActivity : Activity() {

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_register)
    }

    fun registerCar(view: View) {

        val brand = findViewById<EditText>(R.id.etUser).text.toString()
        val year = findViewById<EditText>(R.id.etYear).text.toString()
        val name = findViewById<EditText>(R.id.etName).text.toString()
        val note = findViewById<EditText>(R.id.etNote).text.toString()
        ListCarActivity.registerCard(CarRegister( R.drawable.car, brand, year.toInt(), name, note))


        val listCarActivity = Intent(this, ListCarActivity::class.java)
        startActivity(listCarActivity)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        val user = savedInstanceState?.getCharSequence("user")
        val year = savedInstanceState?.getCharSequence("year")
        val name = savedInstanceState?.getCharSequence("name")
        val note = savedInstanceState?.getCharSequence("note")

        findViewById<EditText>(R.id.etUser).setText(user.toString())
        findViewById<EditText>(R.id.etYear).setText(year.toString())
        findViewById<EditText>(R.id.etName).setText(name.toString())
        findViewById<EditText>(R.id.etNote).setText(note.toString())
    }

    override fun onSaveInstanceState(outState: Bundle?) {


        val user = findViewById<EditText>(R.id.etUser).text.toString()
        outState?.putCharSequence("user", user)

        val year = findViewById<EditText>(R.id.etYear).text.toString()
        outState?.putCharSequence("year", year)

        val name = findViewById<EditText>(R.id.etName).text.toString()
        outState?.putCharSequence("name", name)

        val note = findViewById<EditText>(R.id.etNote).text.toString()
        outState?.putCharSequence("note", note)
        super.onSaveInstanceState(outState)
    }
}
