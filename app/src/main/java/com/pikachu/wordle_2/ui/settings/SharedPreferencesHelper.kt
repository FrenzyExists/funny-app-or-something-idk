package com.pikachu.wordle_2.ui.settings

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    enum class SettingKeys(val displayName: String) {
        WORD_LENGTH("Word Length"),
        DIFFICULTY("Difficulty"),
        SOUND_EFFECTS("Sound Effects"),
        HINTS("Hints"),
        TIMER("Timer"),
        VIBRATION("VibrationEnable");

        companion object {
            fun fromDisplayName(name: String): SettingKeys? {
                return entries.find { it.displayName == name }
            }
        }
    }

    private fun settingsToString(key: SettingKeys): String {
        return key.displayName
    }

    fun saveSettings(value: Any, key: SettingKeys) {
        sharedPreferences.edit {
            when (value) {
                is Boolean -> putBoolean(settingsToString(key), value)
                is String -> putString(settingsToString(key), value)
                else -> throw IllegalArgumentException("Unsupported setting type")
            }
        }
    }

    fun getSettings(key: SettingKeys): Any? {
        return if(key == SettingKeys.SOUND_EFFECTS || key == SettingKeys.HINTS) {
            sharedPreferences.getBoolean(settingsToString(key), false)
        } else {
            sharedPreferences.getString(settingsToString(key), null)
        }
    }
}
