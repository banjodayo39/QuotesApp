package com.example.quotesapp.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.quotesapp.R
import com.example.quotesapp.databinding.FragmentQuoteListBinding
import kotlinx.android.synthetic.main.layout_searchbar.view.*

class QuoteListFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var binding: FragmentQuoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quote_list, container, false)
        binding.layoutSearchBar.back.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_quoteListFragment_to_homeFragment)
        }
        return binding.root
    }

    private fun initViews(){

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(" must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            QuoteListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
