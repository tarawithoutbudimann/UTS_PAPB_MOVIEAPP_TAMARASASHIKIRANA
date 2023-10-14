package com.example.filmticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.filmticket.databinding.LoginpageBinding

class Login1 : AppCompatActivity() {

    private lateinit var binding: LoginpageBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PASS = "extra_pass"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            login.setOnClickListener {
                val username = usernamelogin.text.toString()
                val password = passwordlogin.text.toString()

                // Validasi panjang username
                if (username.length > 18) {
                    Toast.makeText(this@Login1, "Username terlalu panjang (maksimal 18 karakter)", Toast.LENGTH_SHORT).show()
                } else {
                    val intentToHomepage = Intent(this@Login1, homepage::class.java)
                    intentToHomepage.putExtra(EXTRA_NAME, username)
                    intentToHomepage.putExtra(EXTRA_PASS, password)
                    startActivity(intentToHomepage)
                }
            }

            register1.setOnClickListener {
                val intentToRegister =
                    Intent(this@Login1, register::class.java)
                startActivity(intentToRegister)
            }
        }
    }
}
