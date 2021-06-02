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

        val listRumahKemasan  = DummyData.getAllRumahKemasan()
        val namaSeluruhRumahKemasan = ArrayList<String>()

        for(element in listRumahKemasan)
        {
            namaSeluruhRumahKemasan.add(element.Nama)
        }
        Log.d("isirumahkemasan", namaSeluruhRumahKemasan.toString())
        val arrayAdapter = ArrayAdapter(applicationContext,R.layout.dropdown_item,namaSeluruhRumahKemasan)
         binding.autoCompleteMerkProduk.setAdapter(arrayAdapter)

        binding.autoCompleteMerkProduk.setOnItemClickListener { parent, view, position, rowId ->
            val selection = parent.getItemAtPosition(position) as String
            Log.d("isiyangdipilh", selection)
            //TODO Do something with the selected text
        }
    }
}