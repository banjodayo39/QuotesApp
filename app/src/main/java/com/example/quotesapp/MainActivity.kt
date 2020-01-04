package com.example.quotesapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.quotesapp.databinding.ActivityMainBinding
import com.example.quotesapp.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
HomeFragment.OnFragmentInteractionListener{

    private lateinit var homeFragment: HomeFragment

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadHomeFragment()
        binding.toolbarLayout.title.text = getString(R.string.quotes)
        bottomNavigation()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(fragment_container.id, fragment, fragment.javaClass.simpleName)
            .commitAllowingStateLoss()
    }

    private fun loadHomeFragment() {
        binding.fragmentContainer.apply {
            homeFragment = HomeFragment.newInstance()
           loadFragment(homeFragment)
        }
    }

    private fun bottomNavigation(){
        binding.bottomNav.add(MeowBottomNavigation.Model(1,R.drawable.ic_forum_green_24dp))
        binding.bottomNav.add(MeowBottomNavigation.Model(2,R.drawable.ic_chat_green_24dp))
        binding.bottomNav.add(MeowBottomNavigation.Model(3,R.drawable.ic_note_add_green_24dp))
        binding.bottomNav.add(MeowBottomNavigation.Model(4,R.drawable.ic_bookmark_green_24dp))
    }

    private fun initBottomNav() {
        binding.bottomNav.setOnClickMenuListener {
            mOnNavigationSelectedListener
        }
        binding.bottomNav.setOnShowListener {

        }
    }


    private val mOnNavigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            /* com.example.comicfantasy.R.id.navigation_movie-> {
                showMovie()
                true
            }
            com.example.comicfantasy.R.id.navigation_comic-> {
                showComic()
                true
            }
            com.example.comicfantasy.R.id.navigation_trivia -> {
                showGames()
                true
            }

            else ->
                false
        */
        }
    }
}
