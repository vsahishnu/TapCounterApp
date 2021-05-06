package com.sagitest.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //counter of clicks
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onTap(view: View) {
        //counter increased on tap
        counter++

        //connect to textview and display counter's value
        val t1 = findViewById(R.id.t1) as TextView
        t1.setText("You have clicked me $counter times")
    }

    fun onTap1(view: View) {
        //counter reset on tap
        //changing the same global counter coz its what which needs to be reset
        counter = 0

        //same display part
        val t1 = findViewById(R.id.t1) as TextView
        t1.setText("You have clicked me $counter times")

    }
}