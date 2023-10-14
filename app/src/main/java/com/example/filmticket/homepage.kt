package com.example.filmticket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.filmticket.databinding.ActivityHomepageBinding
import java.util.*

class homepage : AppCompatActivity() {
    private lateinit var binding: ActivityHomepageBinding
    private lateinit var viewPager: ViewPager2
    private val images = listOf(
        R.drawable.slider1,
        R.drawable.slider2,
        R.drawable.slider3,
        R.drawable.slider4,
        R.drawable.slider5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        val imageSliderAdapter = ImageSliderAdapter(images)
        viewPager.adapter = imageSliderAdapter

        val timer = Timer()
        timer.scheduleAtFixedRate(ImageSliderTimer(images.size), 2000, 3000)

        // Mendapatkan nama pengguna dari Intent
        val username = intent.getStringExtra(Login1.EXTRA_NAME)

        // Menampilkan pesan selamat datang
        username?.let {
            binding.welcomeMessage.text = "Hello, $username!"
        }

        binding.selengkapnya.setOnClickListener {
            val intent = Intent(this, AllMovie::class.java)
            startActivity(intent)
        }
    }

    private inner class ImageSliderTimer(val numPages: Int) : TimerTask() {
        override fun run() {
            runOnUiThread {
                viewPager.currentItem = (viewPager.currentItem + 1) % numPages
            }
        }
    }
}
