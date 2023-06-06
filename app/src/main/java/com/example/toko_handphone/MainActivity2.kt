package com.example.praktikummodul5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toko_handphone.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class MainActivity2 : AppCompatActivity() {
    // deklarasi request code untuk startActivityForResult
    val request_code = 1

    // deklarasi fungsi onActivityResult untuk menerima data dari ActivityEdit dan menampilkannya
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == request_code && resultCode == RESULT_OK) {
            val nama = findViewById<MaterialTextView>(R.id.tvNamaValue)
            val tanggal = findViewById<MaterialTextView>(R.id.tvDateValue)
            val kelas = findViewById<MaterialTextView>(R.id.tvKelasValue)
            val prodi = findViewById<MaterialTextView>(R.id.tvprodiValues)

            nama.text = data?.getStringExtra("nama")
            tanggal.text = data?.getStringExtra("tanggal")
            kelas.text = data?.getStringExtra("kelas")
            prodi.text = data?.getStringExtra("Prodi")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        // deklarasi view berdasarkan id
        val btnEdit = findViewById<MaterialButton>(R.id.editButton)
        val nama = findViewById<MaterialTextView>(R.id.tvNamaValue)
        val tanggal = findViewById<MaterialTextView>(R.id.tvDateValue)
        val kelas = findViewById<MaterialTextView>(R.id.tvKelasValue)
        val prodi = findViewById<MaterialTextView>(R.id.tvprodiValues)

        // ketika tombol edit diklik, maka akan berpindah ke ActivityEdit
        btnEdit.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            // mengirimkan data ke ActivityEdit
            intent.putExtra("nama", nama.text.toString())
            intent.putExtra("tanggal", tanggal.text.toString())
            intent.putExtra("kelas", kelas.text.toString())
            intent.putExtra("Prodi", prodi.text.toString())

            // memulai ActivityEdit dengan startActivityForResult
            startActivityForResult(intent, request_code)
        }
    }
}