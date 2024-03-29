package com.pikachu.wordle_2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _attempts: MutableLiveData<List<List<Char>>> = MutableLiveData()
    val attempts: LiveData<List<List<Char>>> get() = _attempts;


}