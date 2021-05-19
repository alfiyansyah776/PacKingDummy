package soulever.project.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import soulever.project.R
import soulever.project.databinding.ActivityMainBinding
import soulever.project.ui.fragment.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabCamera.setOnClickListener {
            val intent = Intent(this@MainActivity,CameraActivity::class.java)
            startActivity(intent)
        }

        val homeFragment = HomeFragment()
        val pesananFragment = PesananFragment()
        val notifikasiFragment = NotifikasiFragment()
        val profilFragment = ProfilFragment()

        makeCurrentFragment(HomeFragment())

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.page_1 -> makeCurrentFragment(HomeFragment())
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
            addToBackStack(null)
            commit()
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.setting) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, PreferencesFragment())
                .replace(R.id.container, PreferencesFragment())
                .commit()
        } else if (item.itemId == android.R.id.home) {
            super.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}