package soulever.project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import soulever.project.adapter.PesananAdapter
import soulever.project.databinding.FragmentPesananBinding
import soulever.project.ui.ViewModel.PesananViewModel
import soulever.project.viewmodel.ViewModelFactory

class PesananFragment : Fragment() {

    private lateinit var pesananBinding: FragmentPesananBinding
    private lateinit var pesananViewModel: PesananViewModel
    private lateinit var pesananAdapter: PesananAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pesananBinding = FragmentPesananBinding.inflate(layoutInflater)
        return pesananBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        pesananAdapter = PesananAdapter()
        pesananViewModel = ViewModelProvider(this, factory)[PesananViewModel::class.java]
        pesananViewModel.getPesanan().observe(viewLifecycleOwner, {
            pesananAdapter.setRecommendedList(it)
            pesananAdapter.notifyDataSetChanged()
        })

        with(pesananBinding.rvTv) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = pesananAdapter
        }

    }

}