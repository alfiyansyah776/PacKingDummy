package soulever.project.ui

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import soulever.project.R
import soulever.project.databinding.ActivitySelfDesignBinding
import soulever.project.utils.DummyData


class SelfDesignActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySelfDesignBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaProduk = ArrayList<String>()
        namaProduk.add("Asinan Jakarta")
        namaProduk.add("Donut")
        namaProduk.add("Fried Food")
        namaProduk.add("Gudeg")
        namaProduk.add("Surabi")
        namaProduk.add("Soup")

        val arrayAdapter = ArrayAdapter(applicationContext,R.layout.dropdown_item,namaProduk)
         binding.autoCompleteMerkProduk.setAdapter(arrayAdapter)

        val warna = ArrayList<String>()
        warna.add("Merah")
        warna.add("Biru")
        warna.add("Hijau")
        warna.add("Kuning")
        warna.add("Coklat")
        warna.add("Jingga")

        val arrayAdapterWarna = ArrayAdapter(applicationContext,R.layout.dropdown_item,warna)
        binding.autoCompleteWarnaTema.setAdapter(arrayAdapterWarna)


        val jenisKemasan = ArrayList<String>()
        jenisKemasan.add("Gusset")
        jenisKemasan.add("Dus")
        jenisKemasan.add("Box")
        jenisKemasan.add("Cup")
        jenisKemasan.add("Botol")

        val arrayAdapterKemasan = ArrayAdapter(applicationContext,R.layout.dropdown_item,jenisKemasan)
        binding.autoCompleteBahanKemasan.setAdapter(arrayAdapterKemasan)
    }
}