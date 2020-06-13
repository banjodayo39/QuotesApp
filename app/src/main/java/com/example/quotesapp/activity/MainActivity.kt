package com.example.quotesapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.quotesapp.R
import com.example.quotesapp.databinding.ActivityMainBinding
import com.example.quotesapp.ui.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Unit



class MainActivity : AppCompatActivity(),
    HomeFragment.OnFragmentInteractionListener,
    AddQuoteFragment.OnFragmentInteractionListener,
    StatusFragment.OnFragmentInteractionListener,
    QuoteListFragment.OnFragmentInteractionListener{

    private lateinit var homeFragment: HomeFragment
    private lateinit var addQuoteFragment: AddQuoteFragment
    private lateinit var bookMarkFragment: BookMarkFragment
    private lateinit var statusFragment: StatusFragment
    private lateinit var quoteListFragment: QuoteListFragment

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            com.example.quotesapp.R.layout.activity_main
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadHomeFragment()
        binding.title.text = getString(com.example.quotesapp.R.string.quotes)
        binding.toolbarLayout.visibility = View.VISIBLE
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

    private fun bottomNavigation() {
        binding.bottomNav.add(
            MeowBottomNavigation.Model(
                1,
                com.example.quotesapp.R.drawable.ic_quote_blue_24dp
            )
        )
        binding.bottomNav.add(
            MeowBottomNavigation.Model(
                2,
                com.example.quotesapp.R.drawable.ic_status_blue_24dp
            )
        )
        binding.bottomNav.add(
            MeowBottomNavigation.Model(
                3,
                com.example.quotesapp.R.drawable.ic_add_quote_blue_24dp
            )
        )
        binding.bottomNav.add(
            MeowBottomNavigation.Model(
                4,
                com.example.quotesapp.R.drawable.ic_bookmark_blue_24dp
            )
        )

        binding.bottomNav.setOnClickMenuListener {
            initBottomNavCick()
        }
    }

    private fun initBottomNavCick() {
        binding.bottomNav.setOnClickMenuListener { p1 ->
            val i = p1.id
            when (i) {
                1 -> {
                    binding.fragmentContainer.setBackgroundResource(R.drawable.backgnd_quotes)
                    binding.back.visibility = View.GONE
                    binding.title.text = getString(R.string.quotes)
                    binding.toolbarLayout.visibility = View.VISIBLE
                    showHomeFragment()
                }
                2 -> {
                    binding.fragmentContainer.setBackgroundResource(R.drawable.backgnd_quotes)
                    binding.title.text = getString(R.string.status)
                    binding.toolbarLayout.visibility = View.VISIBLE
                    showStatusFragment()
                }
                3 -> {
                    binding.toolbarLayout.visibility = View.GONE
                    binding.fragmentContainer.setBackgroundResource(R.color.white)
                    showAddQuoteFragment()
                }
                4 -> {
                    binding.toolbarLayout.visibility = View.GONE
                    showBookMarkFragment()
                }
            }
            Unit
        }
    }

    private fun loadContainer(imageView: ImageView) {
        when (imageView.id) {
            com.example.quotesapp.R.drawable.ic_quote_blue_24dp -> {
                showHomeFragment()
                true
            }

            com.example.quotesapp.R.drawable.ic_status_blue_24dp -> {
                showStatusFragment()
                true
            }

            com.example.quotesapp.R.drawable.ic_add_quote_blue_24dp -> {
                showAddQuoteFragment()
                true
            }

            com.example.quotesapp.R.drawable.ic_bookmark_blue_24dp -> {
                showBookMarkFragment()
                true
            }
            else ->
                false
        }
    }

    private fun showHomeFragment() {
        binding.fragmentContainer.apply {
            homeFragment = HomeFragment.newInstance()
            loadFragment(homeFragment)
        }
    }

    private fun showAddQuoteFragment() {
        binding.fragmentContainer.apply {
            addQuoteFragment = AddQuoteFragment.newInstance()
            loadFragment(addQuoteFragment)
        }
    }

    private fun showBookMarkFragment() {
        binding.fragmentContainer.apply {
            bookMarkFragment = BookMarkFragment.newInstance()
            loadFragment(bookMarkFragment)
        }
    }

    private fun showStatusFragment() {
        binding.fragmentContainer.apply {
            statusFragment = StatusFragment()
            loadFragment(statusFragment)
        }
    }

    private fun showQuoteListFragment() {
        binding.fragmentContainer.apply {
            quoteListFragment = QuoteListFragment.newInstance()
            loadFragment(quoteListFragment)
        }
    }
}
