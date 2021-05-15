package soulever.project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import soulever.project.R
import soulever.project.databinding.ActivityMainBinding
import soulever.project.ui.fragment.HomeFragment
import soulever.project.ui.fragment.NotifikasiFragment
import soulever.project.ui.fragment.PesananFragment
import soulever.project.ui.fragment.ProfilFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val pesananFragment = PesananFragment()
        val notifikasiFragment = NotifikasiFragment()
        val profilFragment = ProfilFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.page_1 -> makeCurrentFragment(homeFragment)
                R.id.page_2 -> makeCurrentFragment(pesananFragment)
                R.id.page_3 -> makeCurrentFragment(notifikasiFragment)
                R.id.page_4 -> makeCurrentFragment(profilFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
}