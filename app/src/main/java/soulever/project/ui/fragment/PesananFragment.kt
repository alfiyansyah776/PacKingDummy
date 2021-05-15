package soulever.project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import soulever.project.R
import soulever.project.databinding.FragmentNotifikasiBinding
import soulever.project.databinding.FragmentPesananBinding
import soulever.project.ui.ViewModel.NotifikasiViewModel
import soulever.project.ui.ViewModel.PesananViewModel

class PesananFragment : Fragment() {

    private lateinit var pesananBinding : FragmentPesananBinding
    private lateinit var pesananViewModel: PesananViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pesananBinding = FragmentPesananBinding.inflate(layoutInflater)
        return pesananBinding.root
    }

}