package com.example.filmticket
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmticket.databinding.ActivityRegisterBinding
import com.example.filmticket.Login1.Companion.EXTRA_NAME
import com.example.filmticket.Login1.Companion.EXTRA_PASS


@Suppress("DEPRECATION")
class register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var textView: TextView

    companion object{
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            registerbutton.setOnClickListener{
                val intentToLogin =
                    Intent(this@register, Login1::class.java)
                startActivity(intentToLogin)
            }
            login10.setOnClickListener{
                val intentToLogin =
                    Intent(this@register, Login1::class.java)
                startActivity(intentToLogin)
            }
        }
    }
}