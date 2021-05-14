package soulever.project.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import soulever.project.databinding.ActivityMainBinding
import soulever.project.ui.ViewModel.TutorialViewModel
import soulever.project.ui.adapter.TutorialAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showRecyclerViewTutorial()

        binding.buttonCamera.setOnClickListener {
            val intent = Intent(this@MainActivity, CameraActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showRecyclerViewTutorial()
    {
        val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[TutorialViewModel::class.java]
        val tutorials = viewModel.getTutorials()
        val tutorialAdapter = TutorialAdapter()
        tutorialAdapter.setTutorials(tutorials)
        with(binding.rvTutorial)
        {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
            adapter = tutorialAdapter
        }

    }
}