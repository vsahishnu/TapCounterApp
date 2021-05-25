package com.sagitest.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.activity_main.*
//import android.widget.TextView
//import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    //counter of clicks
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun updateText() {
        t1.text = "You have clicked me $counter times"
    }

    fun onTap(view: View) {
        //counter increased on tap
        counter++

        //connect to textview and display counter's value
        updateText()
    }

    fun onReset(view: View) {
        //counter reset on tap
        //changing the same global counter coz its what which needs to be reset
        counter = 0

        //same display part
        updateText()
    }

    override fun onStop() {
        super.onStop()

        val prefs: SharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE)
        val editor:SharedPreferences.Editor =  prefs.edit()

        editor.putInt("tally", counter)

        editor.apply()
    }

    override fun onStart() {
        super.onStart()

        val prefs: SharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE)

        counter = prefs.getInt("tally", 0)
        updateText()
    }
}