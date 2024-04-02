package com.pikachu.wordle_2.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SettingsViewModel(private val sharedPreferencesHelper: SharedPreferencesHelper) : ViewModel() {
    private val _wordLength = MutableLiveData<String>()
    private val _difficulty = MutableLiveData<String>()
    private var _soundEnabled = MutableLiveData<Boolean>()
    private val _hintEnabled = MutableLiveData<Boolean>()
    private val _timerEnabled = MutableLiveData<Boolean>()

    // Expose LiveData for soundEnabled

    val wordLength: LiveData<String>
        get() = _wordLength

    val difficulty: LiveData<String>
        get() = _difficulty

    val soundEnabled: LiveData<Boolean>
        get() = _soundEnabled

    val hintEnabled: LiveData<Boolean>
        get() = _hintEnabled

    val timerEnabled: LiveData<Boolean>
        get() = _timerEnabled

    fun saveDifficulty(value: String) {
        viewModelScope.launch {
            sharedPreferencesHelper.saveSettings(value, SharedPreferencesHelper.SettingKeys.DIFFICULTY)
        }
    }
    fun saveWordLength(value: String) {
        viewModelScope.launch {
            sharedPreferencesHelper.saveSettings(value, SharedPreferencesHelper.SettingKeys.WORD_LENGTH)
        }
    }
    fun saveSound(value: Boolean) {
        viewModelScope.launch {
            sharedPreferencesHelper.saveSettings(value, SharedPreferencesHelper.SettingKeys.SOUND_EFFECTS)
        }
    }

    fun saveHint(value: Boolean) {
        viewModelScope.launch {
            sharedPreferencesHelper.saveSettings(value, SharedPreferencesHelper.SettingKeys.HINTS)
        }
    }

    fun saveTimer(value: Boolean) {
        viewModelScope.launch {
            sharedPreferencesHelper.saveSettings(value, SharedPreferencesHelper.SettingKeys.TIMER)
        }
    }
    // ---------------------------------------------------------------------------------------------

    fun getDifficulty(): String? {
        val value = sharedPreferencesHelper.getSettings(SharedPreferencesHelper.SettingKeys.DIFFICULTY)
        return if (value is String) {
            _difficulty.value = value!!
            value
        } else {
            null
        }
    }
    fun getWordlength(): String? {
        val value = sharedPreferencesHelper.getSettings(SharedPreferencesHelper.SettingKeys.WORD_LENGTH)
        return if (value is String) {
            _wordLength.value = value!!
            value
        } else {
            null
        }
    }
    fun getSound(): Boolean? {
        val value = sharedPreferencesHelper.getSettings(SharedPreferencesHelper.SettingKeys.SOUND_EFFECTS)
        return if (value is Boolean) {
            _soundEnabled.value = value!!
            value
        } else {
            null
        }
    }
    fun getWordHint(): Boolean? {
        val value = sharedPreferencesHelper.getSettings(SharedPreferencesHelper.SettingKeys.HINTS)
        return if (value is Boolean) {
            _hintEnabled.value = value!!
            value
        } else {
            null
        }
    }
    fun getTimer(): Boolean? {
        val value = sharedPreferencesHelper.getSettings(SharedPreferencesHelper.SettingKeys.TIMER)
        return if (value is Boolean) {
            _timerEnabled.value = value!!
            value
        } else {
            null
        }
    }
}

// old stuff
//private val _selectedWordLength = MutableLiveData<String>()
//val selectedWordLength: LiveData<String>
//    get() = _selectedWordLength
//
//private val _selectedDifficulty = MutableLiveData<String>()
//val selectedDifficulty: LiveData<String>
//    get() = _selectedDifficulty
//
//private val _isSoundEffectsEnabled = MutableLiveData<Boolean>()
//val isSoundEffectsEnabled: LiveData<Boolean>
//    get() = _isSoundEffectsEnabled
//
//private val _areHintsEnabled = MutableLiveData<Boolean>()
//val areHintsEnabled: LiveData<Boolean>
//    get() = _areHintsEnabled
//
//private val _isTimerEnabled = MutableLiveData<Boolean>()
//val isTimerEnabled: LiveData<Boolean>
//    get() = _isTimerEnabled
//
//init {
//    // Initialize default values
//    _selectedWordLength.value = ""
//    _selectedDifficulty.value = "Easy - 7 Chances"
//    _isSoundEffectsEnabled.value = true
//    _areHintsEnabled.value = true
//    _isTimerEnabled.value = true
//}
//
//fun setSelectedWordLength(length: String) {
//    _selectedWordLength.value = length
//}
//
//fun setSelectedDifficulty(difficulty: String) {
//    _selectedDifficulty.value = difficulty
//}
//
//fun setSoundEffectsEnabled(enabled: Boolean) {
//    _isSoundEffectsEnabled.value = enabled
//}
//
//fun setHintsEnabled(enabled: Boolean) {
//    _areHintsEnabled.value = enabled
//}
//
//fun setTimerEnabled(enabled: Boolean) {
//    _isTimerEnabled.value = enabled
//}
