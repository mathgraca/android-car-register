package com.project.carregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        val user = savedInstanceState?.getCharSequence("user")
        val pass = savedInstanceState?.getCharSequence("pass")

        findViewById<EditText>(R.id.etUser).setText(user.toString())
        findViewById<EditText>(R.id.etPassword).setText(pass.toString())
    }

    override fun onSaveInstanceState(outState: Bundle?) {


        val user = findViewById<EditText>(R.id.etUser).text.toString()
        outState?.putCharSequence("user", user)

        val pass = findViewById<EditText>(R.id.etPassword).text.toString()
        outState?.putCharSequence("pass", pass)
        super.onSaveInstanceState(outState)
    }


    fun registerUser(view: View) {
        val tvUser: EditText
        tvUser = findViewById<EditText>(R.id.etUser)
        val tvPass: EditText
        tvPass = findViewById<EditText>(R.id.etPassword)

        if (!LoginActivity.isEmailValid(tvUser.text.toString())) {
            tvUser.error = getString(R.string.error_invalid_email)
            return
        }
        if (!LoginActivity.isPasswordValid(tvPass.text.toString())) {
            tvPass.error = getString(R.string.error_invalid_password)
            return
        }

       val isRegistered = LoginActivity.registerUser(tvUser.text.toString(), tvPass.text.toString())

        if(!isRegistered) {
            Toast.makeText(this, getString(R.string.user_already_registered), Toast.LENGTH_SHORT).show()
            return
        }

        openLoginActivity(tvUser.text.toString())

    }

    private fun openLoginActivity(userName : String) {
        val loginActivity = Intent(this, LoginActivity::class.java)
        intent.putExtra("Username", userName)
        startActivity(loginActivity)
    }
}
