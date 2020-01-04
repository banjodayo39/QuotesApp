package com.example.quotesapp.ui.vmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.data.api.QuotesRepository
import com.example.quotesapp.model.KutipanQuotes
import com.example.quotesapp.model.Resource
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {

    private val _quote = MutableLiveData<Resource<KutipanQuotes>>()

    private val quote :LiveData<Resource<KutipanQuotes>> =_quote

    fun refreshQuote(stageId: Int) {


            _quote.value = Resource.loading(KutipanQuotes())
            viewModelScope.launch {
                _quote.value = quotesRepository.getAllQuote()
            }
    }

}