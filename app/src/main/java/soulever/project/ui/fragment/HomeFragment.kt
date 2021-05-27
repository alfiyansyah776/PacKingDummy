package soulever.project.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import soulever.project.adapter.CollectionAdapter
import soulever.project.databinding.FragmentHomeBinding
import soulever.project.ui.ListRumahKemasanActivity
import soulever.project.ui.ViewModel.CollectionViewModel
import soulever.project.ui.ViewModel.TutorialViewModel
import soulever.project.ui.adapter.TutorialAdapter

class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRecyclerViewTutorial()
        showRecyclerViewCollection()

        fragmentHomeBinding.rumahKemasan.setOnClickListener {
            val intent = Intent(context,ListRumahKemasanActivity::class.java)
            startActivity(intent)
        }
        

    }

    private fun showRecyclerViewTutorial()
    {
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TutorialViewModel::class.java]
        val tutorials = viewModel.getTutorials()
        val tutorialAdapter = TutorialAdapter()
        tutorialAdapter.setTutorials(tutorials)

        with(fragmentHomeBinding.rvTutorial)
        {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = tutorialAdapter
        }

    }

    private fun showRecyclerViewCollection()
    {
        val viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[CollectionViewModel::class.java]
        val collections = viewModel.getCollections()
        val collectionAdapter = CollectionAdapter()
        collectionAdapter.setCollections(collections)

        with(fragmentHomeBinding.rvCollection)
        {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = collectionAdapter
        }
    }
    
}