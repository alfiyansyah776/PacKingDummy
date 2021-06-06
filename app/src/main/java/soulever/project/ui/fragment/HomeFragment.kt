package soulever.project.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import soulever.project.adapter.TopCollectionAdapter
import soulever.project.databinding.FragmentHomeBinding
import soulever.project.db.TopCollectionHelper
import soulever.project.entity.Recommended
import soulever.project.ui.ListCollectionActivity
import soulever.project.ui.ListRumahKemasanActivity
import soulever.project.ui.SelfDesignActivity
import soulever.project.ui.ViewModel.TutorialViewModel
import soulever.project.ui.adapter.TutorialAdapter
import soulever.project.utils.MappingHelper


class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var topCollectionAdapter: TopCollectionAdapter
    private var allowRefresh = false

    companion object {
        private const val EXTRA_STATE = "EXTRA_STATE"
    }

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

        fragmentHomeBinding.rumahKemasan.setOnClickListener {
            val intent = Intent(context, ListRumahKemasanActivity::class.java)
            startActivity(intent)
        }

        fragmentHomeBinding.selfDesign.setOnClickListener {
            startActivity(Intent(context, SelfDesignActivity::class.java))
        }

        fragmentHomeBinding.rvCollection.layoutManager = LinearLayoutManager(context)
        fragmentHomeBinding.rvCollection.setHasFixedSize(true)
        topCollectionAdapter = TopCollectionAdapter()
        fragmentHomeBinding.rvCollection.adapter = topCollectionAdapter
        if (savedInstanceState == null) {
            // proses ambil data
            loadNotesAsync()
        } else {
            val list = savedInstanceState.getParcelableArrayList<Recommended>(EXTRA_STATE)
            if (list != null) {
                topCollectionAdapter.setCollections(list)
            }
        }

    }

    private fun loadNotesAsync() {
        GlobalScope.launch(Dispatchers.Main) {
            val noteHelper = context?.let { TopCollectionHelper.getInstance(it) }
            if (noteHelper != null) {
                noteHelper.open()
                val deferredNotes = async(Dispatchers.IO) {
                    val cursor = noteHelper.queryAll()
                    MappingHelper.mapCursorToArrayList(cursor)
                }
                val notes = deferredNotes.await()
                allowRefresh = true
                if (notes.size > 0) {
                    topCollectionAdapter.setCollections(notes)

                } else {
                    topCollectionAdapter.setCollections(ArrayList())
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        if (allowRefresh) {
            allowRefresh = false;
            getFragmentManager()?.beginTransaction()?.detach(this)?.attach(this)?.commit()
        }
        fragmentHomeBinding.designCollection.setOnClickListener {
            val intent = Intent(context, ListCollectionActivity::class.java)
            startActivity(intent)
        }


    }

    private fun showRecyclerViewTutorial() {
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[TutorialViewModel::class.java]
        val tutorials = viewModel.getTutorials()
        val tutorialAdapter = TutorialAdapter()
        tutorialAdapter.setTutorials(tutorials)

        with(fragmentHomeBinding.rvTutorial)
        {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = tutorialAdapter
        }

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(fragmentHomeBinding.rvTutorial)
/*        (fragmentHomeBinding.indicator as CircleIndicator2).attachToRecyclerView(fragmentHomeBinding.rvTutorial, pagerSnapHelper)
        tutorialAdapter.registerAdapterDataObserver((fragmentHomeBinding.indicator as CircleIndicator2).adapterDataObserver)*/

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_STATE, topCollectionAdapter.listCollections)
    }

    private fun showRecyclerViewCollection() {
/*        val viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[CollectionViewModel::class.java]
        val collections = viewModel.getCollections()*/
/*        val collectionAdapter = CollectionAdapter()
        collectionAdapter.setCollections(collections)

        with(fragmentHomeBinding.rvCollection)
        {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = collectionAdapter
        }

 */
    }

}