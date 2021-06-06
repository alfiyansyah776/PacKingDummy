package soulever.project.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import soulever.project.ui.fragment.HomeFragment
import soulever.project.ui.fragment.NotifikasiFragment
import soulever.project.ui.fragment.PesananFragment
import soulever.project.ui.fragment.ProfilFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> HomeFragment()
            1 -> PesananFragment()
            2 -> NotifikasiFragment()
            else -> ProfilFragment()
        }
    }
}