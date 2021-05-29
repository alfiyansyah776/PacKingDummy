package soulever.project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import soulever.project.R
import soulever.project.adapter.DummyRecommendedAdapter
import soulever.project.adapter.RecommendedAdapter
import soulever.project.databinding.FragmentNotifikasiBinding
import soulever.project.ui.ViewModel.NotifikasiViewModel
import soulever.project.ui.ViewModel.RekomendasiViewModel


class NotifikasiFragment : Fragment() {
    private lateinit var rekomendasiViewModel: RekomendasiViewModel
    private lateinit var notifikasiBinding: FragmentNotifikasiBinding
    private lateinit var notifikasiViewModel: NotifikasiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notifikasiBinding = FragmentNotifikasiBinding.inflate(layoutInflater)

        return notifikasiBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRecyclerView()
    }

    private fun showRecyclerView()
    {
        val adapter = DummyRecommendedAdapter()
        adapter.notifyDataSetChanged()
        notifikasiBinding.rvRekomendasi.layoutManager = LinearLayoutManager(activity)
        notifikasiBinding.rvRekomendasi.setHasFixedSize(true)
        notifikasiBinding.rvRekomendasi.adapter = adapter
        notifikasiViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[NotifikasiViewModel::class.java]
        notifikasiViewModel.getUser()?.observe(viewLifecycleOwner,
            {
                adapter.setRecommendedList(it)
            })
    }

}