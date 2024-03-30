package com.pikachu.wordle_2.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
class SettingsViewModelFactory(private val sharedPreferencesHelper: SharedPreferencesHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(sharedPreferencesHelper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}