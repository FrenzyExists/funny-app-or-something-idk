package com.pikachu.wordle_2.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    private val _selectedWordLength = MutableLiveData<String>()
    val selectedWordLength: LiveData<String>
        get() = _selectedWordLength

    private val _selectedDifficulty = MutableLiveData<String>()
    val selectedDifficulty: LiveData<String>
        get() = _selectedDifficulty

    private val _isSoundEffectsEnabled = MutableLiveData<Boolean>()
    val isSoundEffectsEnabled: LiveData<Boolean>
        get() = _isSoundEffectsEnabled

    private val _areHintsEnabled = MutableLiveData<Boolean>()
    val areHintsEnabled: LiveData<Boolean>
        get() = _areHintsEnabled

    private val _isTimerEnabled = MutableLiveData<Boolean>()
    val isTimerEnabled: LiveData<Boolean>
        get() = _isTimerEnabled

    init {
        // Initialize default values
        _selectedWordLength.value = ""
        _selectedDifficulty.value = "Easy - 7 Chances"
        _isSoundEffectsEnabled.value = true
        _areHintsEnabled.value = true
        _isTimerEnabled.value = true
    }

    fun setSelectedWordLength(length: String) {
        _selectedWordLength.value = length
    }

    fun setSelectedDifficulty(difficulty: String) {
        _selectedDifficulty.value = difficulty
    }

    fun setSoundEffectsEnabled(enabled: Boolean) {
        _isSoundEffectsEnabled.value = enabled
    }

    fun setHintsEnabled(enabled: Boolean) {
        _areHintsEnabled.value = enabled
    }

    fun setTimerEnabled(enabled: Boolean) {
        _isTimerEnabled.value = enabled
    }
}
