package soulever.project.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import soulever.project.R
import soulever.project.databinding.FragmentHomeBinding
import soulever.project.ui.CameraActivity
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

    }

    private fun showRecyclerViewTutorial()
    {
        val viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[TutorialViewModel::class.java]
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



}