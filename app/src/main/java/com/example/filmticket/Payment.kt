package com.example.filmticket

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.filmticket.databinding.ActivityPaymentBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Payment : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding
    private val dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
    private val timeFormatter = SimpleDateFormat("HH:mm", Locale.US)
    private var selectedDate: Calendar = Calendar.getInstance()
    private var selectedTime: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.PilihBioskop,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.Sbioskop.adapter = adapter

        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.PilihSeat,
            android.R.layout.simple_spinner_item
        )
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.SSeat.adapter = adapter1

        val adapter2 = ArrayAdapter.createFromResource(
            this,
            R.array.PilihPayment,
            android.R.layout.simple_spinner_item
        )
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.bank.adapter = adapter2

        val adapter3 = ArrayAdapter.createFromResource(
            this,
            R.array.pay,
            android.R.layout.simple_spinner_item
        )
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.pembayaran.adapter = adapter3

        val chooseDateButton = findViewById<Button>(R.id.DateButton)
        chooseDateButton.setOnClickListener {
            showDatePickerDialog()
        }

        val chooseTimeButton = findViewById<Button>(R.id.TimeButton)
        chooseTimeButton.setOnClickListener {
            showTimePickerDialog()
        }

        // Menangani pemilihan item di Spinner SSeat
        binding.SSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedSeat = parent?.getItemAtPosition(position).toString()
                val harga: Int = when (selectedSeat) {
                    "Regular" -> 50000
                    "SweetBox" -> 75000
                    "Premium" -> 100000
                    else -> 0 // Jika pilihan tidak dikenali
                }
                binding.SeatCapt.text = "Seat yang dipilih: $selectedSeat\nHarga:Rp $harga\nTotal:Rp $harga"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Tindakan yang dilakukan ketika tidak ada item yang dipilih (opsional)
            }
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                selectedDate.set(year, month, dayOfMonth)
                binding.DateButton.text = dateFormatter.format(selectedDate.time)
            },
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedTime.set(Calendar.MINUTE, minute)
                binding.TimeButton.text = timeFormatter.format(selectedTime.time)
            },
            selectedTime.get(Calendar.HOUR_OF_DAY),
            selectedTime.get(Calendar.MINUTE),
            true
        )

        timePickerDialog.show()
    }
}
