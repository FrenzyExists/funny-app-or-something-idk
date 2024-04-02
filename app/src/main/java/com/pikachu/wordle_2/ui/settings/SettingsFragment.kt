package com.pikachu.wordle_2.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pikachu.wordle_2.R

class SettingsFragment : Fragment() {
//    private lateinit var viewModel: SettingsViewModel

    private val viewModel: SettingsViewModel by lazy {
        val sharedPreferencesHelper by lazy { SharedPreferencesHelper(requireContext()) }
        val factory = SettingsViewModelFactory(sharedPreferencesHelper)
        ViewModelProvider(this, factory)[SettingsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.wordLength.observe(viewLifecycleOwner) { wordLength ->
            val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupWordLength)

            // Clear the checked state of all RadioButtons first
            radioGroup.clearCheck()

            // Find the RadioButton based on the wordLength and check it
            val radioButtonId = when (wordLength) {
                "Short" -> R.id.radioButton4Letter
                "Medium" -> R.id.radioButton5Letter
                else -> -1  // Default case, handle accordingly
            }

            if (radioButtonId != -1) {
                radioGroup.check(radioButtonId)
            }
        }


        viewModel.difficulty.observe(viewLifecycleOwner) { difficulty ->
            val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupDifficulty)

            // Clear the checked state of all RadioButtons first
            radioGroup.clearCheck()

            // Find the RadioButton based on the wordLength and check it
            val radioButtonId = when (difficulty) {
                "Easy" -> R.id.radioButtonEasy
                "Normal" -> R.id.radioButtonNormal
                "Hard" -> R.id.radioButtonHard
                else -> -1  // Default case, handle accordingly
            }

            if (radioButtonId != -1) {
                radioGroup.check(radioButtonId)
            }
        }

        viewModel.soundEnabled.observe(viewLifecycleOwner) { soundEnabled ->
            view.findViewById<SwitchCompat>(R.id.switchSoundEffects).isChecked = soundEnabled
        }

        viewModel.hintEnabled.observe(viewLifecycleOwner) { hintEnabled ->
            view.findViewById<SwitchCompat>(R.id.switchHints).isChecked = hintEnabled
        }

//        viewModel.timerEnabled.observe(viewLifecycleOwner) {timerEnabled ->
//            view.findViewById<SwitchCompat>(R.id.switchTimer).isChecked = timerEnabled
//        }


        view.findViewById<RadioGroup>(R.id.radioGroupWordLength).setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.radioButton4Letter) {
                viewModel.saveWordLength("Short")
            } else if(checkedId == R.id.radioButton5Letter) {
                viewModel.saveWordLength("Medium")
            }
        }

        view.findViewById<RadioGroup>(R.id.radioGroupDifficulty).setOnCheckedChangeListener { _, checkedId ->
            val selectedDifficulty = view.findViewById<RadioButton>(checkedId).run {
                when (this) {
                    view.findViewById<RadioButton>(R.id.radioButtonEasy) -> "Easy"
                    view.findViewById<RadioButton>(R.id.radioButtonNormal) -> "Normal"
                    view.findViewById<RadioButton>(R.id.radioButtonHard) -> "Hard"
                    else -> "Unknown"
                }
            }
            viewModel.saveDifficulty(selectedDifficulty)
        }

        view.findViewById<SwitchCompat>(R.id.switchSoundEffects).setOnCheckedChangeListener {_, checkedId ->
            viewModel.saveSound(checkedId)
            view.findViewById<SwitchCompat>(R.id.switchSoundEffects).isChecked = viewModel.getSound()!!
        }

        view.findViewById<SwitchCompat>(R.id.switchHints).setOnCheckedChangeListener {_, checkedId ->
            viewModel.saveHint(checkedId)
            view.findViewById<SwitchCompat>(R.id.switchHints).isChecked = viewModel.getWordHint()!!
        }

        viewModel.getSound()
        viewModel.getWordHint()
        viewModel.getWordlength()
        viewModel.getDifficulty()
    }
}

