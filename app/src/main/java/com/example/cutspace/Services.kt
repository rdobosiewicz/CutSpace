package com.example.cutspace

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class Services : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        val koszt = findViewById<TextView>(R.id.viewCost)


        //get value of seekBar
        val pasekWarosciPracy = findViewById<SeekBar>(R.id.costOfWork)
        pasekWarosciPracy.max = 300

        pasekWarosciPracy.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                koszt.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })



        //action bar for comeback to first page
        val pasekPowrotu = supportActionBar

        pasekPowrotu!!.title = "Powrót"

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
