package com.pikachu.wordle_2.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
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

        view.findViewById<RadioGroup>(R.id.radioGroupWordLength).setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.radioButton4Letter) {
                viewModel.saveValue(view.findViewById<RadioButton>(R.id.radioButton4Letter).text.toString())
            } else if(checkedId == R.id.radioButton5Letter) {
                viewModel.saveValue(view.findViewById<RadioButton>(R.id.radioButton5Letter).text.toString())
            }
        }
        Log.v("TEST", viewModel.getValue().toString())

    // old way

        // Initialize ViewModel
//        viewModel = ViewModelProvider(this)[SettingsViewModel::class.java]

        // Observe LiveData and update UI accordingly

//        viewModel.selectedWordLength.observe(viewLifecycleOwner, Observer { length ->
//            // Update UI with selected word length
//            Log.v("MSD", length)
//            Log.v("MSD", length.isBlank().toString())
//            if (length.isBlank()) {
//                viewModel.setSelectedWordLength("4 Letters")
//            } else {
//                if (length == "4 Letters") view.findViewById<RadioButton>(R.id.radioButton4Letter).isChecked = true
//                else if (length == "5 Letters") view.findViewById<RadioButton>(R.id.radioButton5Letter).isChecked = true
//            }
//            view.findViewById<RadioGroup>(R.id.radioGroupWordLength).setOnCheckedChangeListener { _, checkedId ->
//                val l = when (checkedId) {
//                    R.id.radioButton4Letter -> "4 Letters"
//                    R.id.radioButton5Letter -> "5 Letters"
//                    else -> "" // Default
//                }
//                viewModel.setSelectedWordLength(l)
//            }

//            if (length == "4 Letters") {
//                view.findViewById<RadioButton>(R.id.radioButton4Letter).isChecked = true
//            } else if (length == "5 Letters") {
//                view.findViewById<RadioButton>(R.id.radioButton5Letter).isChecked = true
//            } else { view.findViewById<RadioButton>(R.id.radioButton4Letter).isChecked = true
//            }
//        })


//
//        view.findViewById<RadioGroup>(R.id.radioGroupWordLength).setOnCheckedChangeListener { _, checkedId ->
//            val length = when (checkedId) {
//                R.id.radioButton4Letter -> "4 Letters"
//                R.id.radioButton5Letter -> "5 Letters"
//                else -> "" // Default
//            }
//
//            viewModel.setSelectedWordLength(length)
//        }
    }
}



//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        // Initialize ViewModel
//        viewModel = ViewModelProvider(this)[SettingsViewModel::class.java]
//                // Observe LiveData and update UI accordingly
//        viewModel.selectedWordLength.observe(viewLifecycleOwner) { length ->
//            // Update UI with selected word length
//            view.findViewById<TextView>(R.id.textViewWordLengthTitle).text = length
//        }
//
//        view.findViewById<RadioGroup>(R.id.radioGroupWordLength).setOnCheckedChangeListener { _, checkedId ->
//            Log.v("MSD", checkedId.toString())
//            val length = when (checkedId) {
//                R.id.radioButton4Letter -> "4 Letters"
//                R.id.radioButton5Letter -> "5 Letters"
//                else -> "4 Letters" // Default
//            }
//            Log.v("MSD", viewModel.selectedWordLength.toString())
//            viewModel.setSelectedWordLength(length)
//        }
//        if (savedInstanceState != null) {
//            savedInstanceState.getString("wordLength")?.let { Log.v("MSD", it) }
//        }
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("wordLength", viewModel.selectedWordLength.value)
//    }
//
//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//
//        val a = savedInstanceState?.getString("wordLength", "4 Letters")
//        if (a != null) {
//            viewModel.setSelectedWordLength(a)
//        }
//    }