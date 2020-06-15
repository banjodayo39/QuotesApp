package com.example.quotesapp.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.quotesapp.R
import com.example.quotesapp.databinding.FragmentHomeBinding


class GenerateQuoteFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()
    }

    private fun initViews(){
        eventSection()
        birthdaySection()

    }

    private fun eventSection(){

    }

    private fun birthdaySection(){
    }

    private fun moodSection(){

    }

    private fun funnySection(){

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

}
