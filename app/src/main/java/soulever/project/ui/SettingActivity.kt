package soulever.project.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import soulever.project.R
import soulever.project.databinding.ActivitySettingBinding
import soulever.project.ui.fragment.PreferencesFragment

class SettingActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var binding : ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        showPreferenceFragment()

    }

    private fun showPreferenceFragment()
    {
        supportFragmentManager.beginTransaction().add(R.id.activity_setting,PreferencesFragment()).commit()
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreference.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        TODO("Not yet implemented")
    }
}