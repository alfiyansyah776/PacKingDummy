package soulever.project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import soulever.project.R
import soulever.project.adapter.ListCollectionAdapter
import soulever.project.databinding.ActivityListCollectionBinding
import soulever.project.ui.ViewModel.ListCollectionViewModel
import soulever.project.viewmodel.ViewModelFactory

class ListCollectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListCollectionBinding
    private lateinit var listCollectionViewModel: ListCollectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listColletion()
    }

    private fun listColletion(){
        val listCollectionAdapter = ListCollectionAdapter()
        listCollectionViewModel = ViewModelProvider(this).get(ListCollectionViewModel::class.java)
        listCollectionViewModel.getPesanan().observe(this, {
            listCollectionAdapter.setRecommendedList(it)
            listCollectionAdapter.notifyDataSetChanged()
        })

        with(binding.rvCollection){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = listCollectionAdapter
        }
    }
}