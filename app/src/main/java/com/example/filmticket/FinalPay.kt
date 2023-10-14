package com.example.filmticket

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalPay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_pay)

        // Ambil data dari Intent
        val selectedSeat = intent.getStringExtra("selected_seat")
        val paymentMethod = intent.getStringExtra("payment_method")
        val total = intent.getStringExtra("total")

        // Temukan TextView di layout
        val selectedSeatTextView: TextView = findViewById(R.id.ssseatval)
        val paymentMethodTextView: TextView = findViewById(R.id.ppaymentval)
        val totalTextView: TextView = findViewById(R.id.totalval)

        // Atur nilai TextView
        selectedSeatTextView.text = "Selected Seat: $selectedSeat"
        paymentMethodTextView.text = "Payment Method: $paymentMethod"
        totalTextView.text = "Total: $total"
    }

    // Fungsi untuk menangani tombol kembali
    fun backToHomepage(view: View) {
        // Tambahkan tindakan yang diinginkan saat tombol kembali ditekan
        finish() // Ini akan menutup aktivitas saat tombol kembali ditekan
    }
}
