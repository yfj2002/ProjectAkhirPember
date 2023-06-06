package com.example.toko_handphone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikummodul5.MainActivity2
import com.google.android.material.button.MaterialButton

class PesananFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pesanan, container, false)

        val button = view?.findViewById<Button>(R.id.btnBeli)
        button?.setOnClickListener {
            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent)
        }

        return view
    }
}