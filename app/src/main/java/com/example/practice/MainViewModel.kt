package com.example.practice

import android.view.View
import androidx.lifecycle.ViewModel

class MainViewModel(count: Int) :ViewModel() {
    var counterAddition:Int=count;


    fun increment() {
        counterAddition++
    }
}