package soulever.project.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import soulever.project.R
import soulever.project.adapter.RecommendedAdapter
import soulever.project.databinding.ActivityRecommendedBinding
import soulever.project.ui.ViewModel.RekomendasiViewModel

class RecommendedActivity : AppCompatActivity() {
    private lateinit var recommendedActvityViewModel : RekomendasiViewModel
    lateinit var context: Context
    private lateinit var binding : ActivityRecommendedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecommendedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RecommendedAdapter()
        adapter.notifyDataSetChanged()
        binding.rvRecommended.layoutManager = LinearLayoutManager(this)
        binding.rvRecommended.adapter = adapter
        recommendedActvityViewModel = ViewModelProvider(this).get(RekomendasiViewModel::class.java)
        recommendedActvityViewModel.getUser()?.observe(this, Observer {
            Log.d("tag", "isi $it")
            adapter.setRecommendedList(it)
        })


    }
}