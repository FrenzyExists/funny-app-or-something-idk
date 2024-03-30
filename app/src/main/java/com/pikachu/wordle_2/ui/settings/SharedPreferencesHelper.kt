package com.pikachu.wordle_2.ui.settings

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    private enum class SettingKeys {
        WORD_LENGTH,
        DIFFICULTY,
        SOUND_EFFECTS,
        HINTS,
        TIMER,
        VIBRATION,
        IDFK
    }

    fun saveValue(value: String) {
        sharedPreferences.edit {
            putString(KEY_VALUE, value)
        }
    }


    fun getValue(): String? {
        return sharedPreferences.getString(KEY_VALUE, null)
    }

    companion object {
        private const val KEY_VALUE = "key_test"
    }
}
