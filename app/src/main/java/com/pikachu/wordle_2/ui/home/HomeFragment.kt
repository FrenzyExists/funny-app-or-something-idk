package com.pikachu.wordle_2.ui.home

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.util.TypedValue
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginStart
import androidx.core.view.setMargins
import androidx.core.widget.TextViewCompat
import com.pikachu.wordle_2.R

class HomeFragment : Fragment() {
    // These are settings I wish I could sort of set up on the settings fragment
    private val wordSize = 4
    private val maxTries = 6



    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val grid = view.findViewById<LinearLayout>(R.id.relativeWordle)

        val wordSize = 5 // Change this to the size of your word
        val maxTries = 6

        val cellSize = 60f //dp
        val cellPadding = 5 //dp
        val cellTextSize = 14f // sp
        val cellMargin = 4f // dp

        val transformedCellMargin = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, cellMargin, resources.displayMetrics
        ).toInt()
        for (row in 0 until maxTries) {
            val linearLayout = LinearLayout(requireContext())
            linearLayout.orientation = HORIZONTAL

            linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            linearLayout.gravity = Gravity.CENTER
            for (cell in 0 until wordSize) {
                val c = TextView(requireContext())
                c.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    width = TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, cellSize, resources.displayMetrics
                    ).toInt()
                    height = width
                    setMargins(transformedCellMargin, transformedCellMargin, transformedCellMargin, transformedCellMargin)

                }
                c.setPadding(cellPadding, cellPadding, cellPadding, cellPadding)
                c.gravity = Gravity.CENTER
                c.textSize = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_SP, cellTextSize, resources.displayMetrics
                )

                c.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.gui04))
                c.background = ContextCompat.getDrawable(requireContext(), R.drawable.correct)
                c.background.apply {
                    setTintList(ContextCompat.getColorStateList(requireContext(), R.color.gui01))
                }
                c.focusable = View.FOCUSABLE
                linearLayout.addView(c)
            }
            grid.addView(linearLayout)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // So here will live the logic of the whole game. I'm not sure if there's a better way but
        // welp, shit sucks i guess
    }

    private fun colorThing(
        guess: String,
        check: String,
        connector: String,
        prev: CharSequence = ""
    ): SpannableStringBuilder {
        return SpannableStringBuilder()
    }

    private fun passFocusToNextCell(currentCell: TextView, nextCell: TextView) {

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}