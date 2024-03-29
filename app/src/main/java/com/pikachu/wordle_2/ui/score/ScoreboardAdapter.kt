package com.pikachu.wordle_2.ui.score

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pikachu.wordle_2.R
import com.pikachu.wordle_2.data.ScoreItem

private const val VIEW_TYPE_EMPTY = 2

class ScoreAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val scoreList: List<ScoreItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ScoreViewHolder(inflater.inflate(R.layout.score_item, parent, false))
    }

    class ScoreViewHolder(inflate: View) : RecyclerView.ViewHolder(inflate) {
        private val scoreText: TextView
        init {
            scoreText = inflate.findViewById(R.id.text_score)
        }
        fun bind() {
            scoreText.text = "Test"
        }
    }

    override fun getItemCount(): Int {
        return scoreList?.size ?: -1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

