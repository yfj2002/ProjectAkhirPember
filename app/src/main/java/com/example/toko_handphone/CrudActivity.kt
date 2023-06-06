package com.example.toko_handphone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class CrudActivity : AppCompatActivity() {
    // deklarasi format tanggal
    private val dateFormat = "dd/MM/yyyy"

    // deklarasi view berdasarkan tipenya
    private var inputNama: TextInputLayout? = null
    private var inputNamaValue: TextInputEditText? = null
    private var inputTanggal: TextInputLayout? = null
    private var inputTanggalValue: TextInputEditText? = null
    private var inputKelas: TextInputLayout? = null
    private var inputKelasValue: MaterialAutoCompleteTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        // deklarasi view berdasarkan id
        inputNama = findViewById(R.id.inputNama)
        inputNamaValue = findViewById(R.id.inputNamaValue)
        inputTanggal = findViewById(R.id.inputTanggal)
        inputTanggalValue = findViewById(R.id.inputTanggalValue)
        inputKelas = findViewById(R.id.inputkelas)
        inputKelasValue = findViewById(R.id.inputkelasValue)

        // Mendapatkan nilai default dari Intent
        val nama = intent.getStringExtra("nama")
        val tanggal = intent.getStringExtra("tanggal")
        val kelas = intent.getStringExtra("kelas")

        // Menampilkan nilai default di inputan
        inputNamaValue?.setText(nama)
        inputTanggalValue?.setText(tanggal)
        inputKelasValue?.setText(kelas)


        // Menangani aksi ketika tombol submit diklik
        val btnSave = findViewById<MaterialButton>(R.id.submitButton)
        btnSave.setOnClickListener {
            // Mengambil nilai saat ini dari inputan
            val nama = inputNamaValue?.text.toString()
            val tanggal = inputTanggalValue?.text.toString()
            val kelas = inputKelasValue?.text.toString()

            // Membuat intent untuk mengirimkan nilai kembali ke MainActivity
            intent.putExtra("nama", nama)
            intent.putExtra("tanggal", tanggal)
            intent.putExtra("kelas", kelas)

            // Mengirimkan nilai kembali ke MainActivity
            setResult(RESULT_OK, intent)
            finish()
        }
    }
    // Menangani aksi ketika tombol input tanggal diklik
    fun inputTanggal(view: View) {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Pilih Tanggal Lahir")
                .build()
        datePicker.show(supportFragmentManager, "DatePicker")

        datePicker.addOnPositiveButtonClickListener {
            val date = Date(it)
            val dateText = SimpleDateFormat(dateFormat, Locale.getDefault()).format(date).toString()
            inputTanggalValue?.setText(dateText)
        }
    }

}