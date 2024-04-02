package com.pikachu.wordle_2

import com.pikachu.wordle_2.ui.settings.SettingsFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pikachu.wordle_2.R.id
import androidx.fragment.app.Fragment
import com.pikachu.wordle_2.databinding.ActivityMainBinding
import com.pikachu.wordle_2.ui.about.AboutFragment
import com.pikachu.wordle_2.ui.home.HomeFragment
import com.pikachu.wordle_2.ui.score.ScoreboardFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.navView.setOnItemSelectedListener {
            when(it.itemId) {
                id.homeBtn -> replaceFragment(HomeFragment())
                id.aboutBtn -> replaceFragment(AboutFragment())
                id.scoreBtn -> replaceFragment(ScoreboardFragment())
                id.settingsBtn -> replaceFragment(SettingsFragment())
            }
            true
        }
    }

    /**
     * Switches the fragment to appear in the Main Frame, that's it
     */
//    private fun replaceFragment(fragment: Fragment) {
//        val supportFragmentManager = supportFragmentManager
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(id.nav_host_fragment_activity_main, fragment).commit()
//    }

    private fun replaceFragment(fragment: Fragment) {
        val tag = fragment.javaClass.simpleName
        val supportFragmentManager = supportFragmentManager
        val existingFragment = supportFragmentManager.findFragmentByTag(tag)

        if (existingFragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(id.nav_host_fragment_activity_main, fragment, tag)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .show(existingFragment)
                .commit()
        }
    }

}