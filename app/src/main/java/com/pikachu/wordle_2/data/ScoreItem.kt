package com.pikachu.wordle_2.data

import java.util.Date

class ScoreItem(private val score: Int, private val timeStamp: Date) {
    private val scoreTime: Date = timeStamp
    private val scoreValue: Int = score
}

//class ScoreItem(val score: String, val isHighScore: Boolean, timestamp: Date) {
//    private val timestamp: Date
//
//    init {
//        this.timestamp = timestamp
//    }
//
//    fun getTimestamp(): Date {
//        return timestamp
//    } // You can add more methods and fields as needed
//}