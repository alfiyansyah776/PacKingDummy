package soulever.project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    }
/*    private fun showRecyclerView()
    {
       val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[CollectionViewModel::class.java]
        val collections = viewModel.getCollections()
        val collectionAdapter = CollectionAdapter()
        collectionAdapter.setCollections(collections)

        with(notifikasiBinding.rvRekomendasi)
        {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = collectionAdapter
        }
    }*/

}