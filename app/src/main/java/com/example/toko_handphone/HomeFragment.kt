package com.example.toko_handphone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    lateinit var recycle: RecyclerView
    lateinit var recycleAdapter: Class_Adapter
    lateinit var listData: ArrayList<Isidata>

    lateinit var image : Array<Int>
    lateinit var nama : Array<String>
    lateinit var harga : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = GridLayoutManager(context, 2)
        recycle = view.findViewById(R.id.recyclerview)
        recycle.layoutManager = layoutManager
        recycle.setHasFixedSize(true)
        recycleAdapter = Class_Adapter(listData)
        recycle.adapter = recycleAdapter

    }
    private fun dataInitialize(){
        listData = arrayListOf<Isidata>()

        image = arrayOf(
            R.drawable.contoh,
            R.drawable.realme5pro,
            R.drawable.realme8,
            R.drawable.realme7,
            R.drawable.realmec35,
            R.drawable.realme9pro,
            R.drawable.realmegtneo,
            R.drawable.realmegtmasteredition,
            R.drawable.realmenarzo50a,
            R.drawable.realmex50pro5g,
//            tambah
            R.drawable.contoh,
            R.drawable.realme5pro,
            R.drawable.realme8,
            R.drawable.realme7,
            R.drawable.realmec35,
            R.drawable.realme9pro,
            R.drawable.realmegtneo,
            R.drawable.realmegtmasteredition,
            R.drawable.realmenarzo50a,
            R.drawable.realmex50pro5g,
        )
        nama = arrayOf(
            getString(R.string.nama1),
            getString(R.string.nama2),
            getString(R.string.nama3),
            getString(R.string.nama4),
            getString(R.string.nama5),
            getString(R.string.nama6),
            getString(R.string.nama7),
            getString(R.string.nama8),
            getString(R.string.nama9),
            getString(R.string.nama10),

//            tambah
            getString(R.string.nama1),
            getString(R.string.nama2),
            getString(R.string.nama3),
            getString(R.string.nama4),
            getString(R.string.nama5),
            getString(R.string.nama6),
            getString(R.string.nama7),
            getString(R.string.nama8),
            getString(R.string.nama9),
            getString(R.string.nama10),
        )
        harga = arrayOf(
            getString(R.string.Harga1),
            getString(R.string.Harga2),
            getString(R.string.Harga3),
            getString(R.string.Harga4),
            getString(R.string.Harga5),
            getString(R.string.Harga6),
            getString(R.string.Harga7),
            getString(R.string.Harga8),
            getString(R.string.Harga9),
            getString(R.string.Harga10),
//            tambah
            getString(R.string.Harga1),
            getString(R.string.Harga2),
            getString(R.string.Harga3),
            getString(R.string.Harga4),
            getString(R.string.Harga5),
            getString(R.string.Harga6),
            getString(R.string.Harga7),
            getString(R.string.Harga8),
            getString(R.string.Harga9),
            getString(R.string.Harga10),
        )
        for (i in image.indices){
            val isidata = Isidata(image[i],nama[i], harga[i])
            listData.add(isidata)
        }
    }
}