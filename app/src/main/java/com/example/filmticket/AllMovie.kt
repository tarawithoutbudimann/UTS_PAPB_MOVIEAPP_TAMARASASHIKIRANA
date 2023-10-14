package com.example.filmticket
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.filmticket.databinding.ActivityAllMovieBinding


class AllMovie : AppCompatActivity() {
    private lateinit var binding: ActivityAllMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //direct ke film anabelle
        val film1 = findViewById<CardView>(R.id.film1)

        film1.setOnClickListener {
            val intent = Intent(this, Film1::class.java)
            startActivity(intent)
        }

        // Mendapatkan nama pengguna dari Intent
        val username = intent.getStringExtra(Login1.EXTRA_NAME)


        // Menampilkan pesan selamat datang
        username?.let {
            val welcomeText = "Film Bioskop - Hello, $username!"
            binding.filmbioskop.text = welcomeText

        }
    }

    fun backToHomepage(view: View) {
        val intent = Intent(this, homepage::class.java)
        startActivity(intent)
    }
}
