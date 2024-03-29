package com.pikachu.wordle_2.ui.score

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pikachu.wordle_2.R

class ScoreboardFragment : Fragment() {

    companion object {
        fun newInstance() = ScoreboardFragment()
    }

    private lateinit var viewModel: ScoreboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scoreboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScoreboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}