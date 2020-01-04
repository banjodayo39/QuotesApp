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


class StatusFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()
    }

    private fun initViews(){
        eventSection()
        birthdaySection()

        binding.congratulationCardView.visibility = View.INVISIBLE
        binding.friendshipCardView.visibility = View.INVISIBLE
    }

    private fun eventSection(){
        binding.motivationalIcon.setImageResource(R.drawable.ic_events_green_24dp)
        binding.motivationalTv.text = getString(R.string.event)
    }

    private fun birthdaySection(){
        binding.successIcon.setImageResource(R.drawable.ic_birthday_green_24dp)
    }

    private fun moodSection(){
        binding.poemIcon.setImageResource(R.drawable.ic_mood_green_24dp)
        binding.poemTv.text = getString(R.string.mood)
    }

    private fun funnySection(){
        binding.loveIcon.setImageResource(R.drawable.ic_funny_green_24dp)
        binding.loveTv.text = getString(R.string.funny)
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
