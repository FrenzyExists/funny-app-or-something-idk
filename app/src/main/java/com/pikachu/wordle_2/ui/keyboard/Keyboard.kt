package com.pikachu.wordle_2.ui.keyboard//import android.content.Context

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.pikachu.wordle_2.R

interface InputListener {
    fun onInput(key: Char)
}

class Keyboard : Fragment() {
    private var inputListener: InputListener? = null
    private val keyboardArray: Array<Array<Char>> = arrayOf(
        arrayOf('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'),
        arrayOf('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'),
        arrayOf('#', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', '&') // # -> Enter, & -> Backspace
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_keyboard, container, false)
        val keyboardTable = view.findViewById<TableLayout>(R.id.keyboard_table)

        for (rows in keyboardArray) {
            val row = createKeyboardRow(rows)
            keyboardTable.addView(row)
        }
        return view
    }

    private fun createKeyboardRow(keys: Array<Char>): TableRow {
        val kewbRow = TableRow(requireContext())

        // Calculate the width of each button based on screen size
        val displayMetrics = resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels

        val marginVerticalPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 3f, resources.displayMetrics
        ).toInt()

        val buttonWidth = (screenWidth / keys.size.toFloat()).toInt() - marginVerticalPx * 2

        val layoutParams = TableRow.LayoutParams(
            buttonWidth,
            TableRow.LayoutParams.WRAP_CONTENT
        ).apply {

            setMargins(marginVerticalPx, marginVerticalPx, 0, marginVerticalPx)
            gravity = Gravity.CENTER_HORIZONTAL
        }

        for (key in keys) {
            val keyb = Button(requireContext())
            keyb.textSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 6f, resources.displayMetrics
            )
            keyb.setTextColor(ContextCompat.getColor(requireContext(), R.color.gui04))
            keyb.background = ContextCompat.getDrawable(requireContext(), R.drawable.key)
            keyb.layoutParams = layoutParams

            when (key) {
                '#' -> {  // Enter
                    keyb.text = "↵"

                    // Keep this in mind, this is how you would change the color of the background
                    // val colorStateList = ColorStateList.valueOf(Color.RED)
                    // keyb.backgroundTintList = colorStateList
                }

                '&' -> { // Backspace
                    keyb.text = "⌫"
                }

                else -> {
                    keyb.text = key.toString()
                }
            }
            keyb.setOnClickListener {
                // implement inputListener here. When I press a button, it should be as if I am
                // pressing from a keyboard
                inputListener?.onInput(key)
            }
            kewbRow.addView(keyb)
        }
        return kewbRow
    }

    fun setInputListener(listener: InputListener) {
        inputListener = listener
    }
}
