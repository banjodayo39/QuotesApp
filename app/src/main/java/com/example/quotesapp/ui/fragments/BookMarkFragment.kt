package com.example.quotesapp.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.quotesapp.R
import com.example.quotesapp.databinding.FragmentQuoteListBinding

class BookMarkFragment : Fragment() {

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
        return binding.root
    }

    companion object {
       @JvmStatic
        fun newInstance() =
            BookMarkFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
