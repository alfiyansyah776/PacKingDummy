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
import soulever.project.ui.ViewModel.NotifikasiViewModel


class NotifikasiFragment : Fragment() {

    private lateinit var notifikasiBinding: FragmentNotifikasiBinding
    private lateinit var notifikasiViewModel: NotifikasiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notifikasiBinding = FragmentNotifikasiBinding.inflate(layoutInflater)

        return notifikasiBinding.root
    }


}