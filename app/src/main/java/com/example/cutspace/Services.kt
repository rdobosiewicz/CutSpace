package com.example.cutspace

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_services.*

class Services : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)
        var wartoscUslugi = 0.0
        var wartoscPracy = 0.0

        //tiem of work in minutes
        var czasPracy2 = 0

        val czasPracy = findViewById<TextView>(R.id.viewCost)


        //get value of seekBar
        val pasekWarosciPracy = findViewById<SeekBar>(R.id.costOfWork)
        pasekWarosciPracy.max = 300

        pasekWarosciPracy.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                czasPracy.text = progress.toString()
                czasPracy2 = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })



        //action bar for comeback to first page
        val pasekPowrotu = supportActionBar

        pasekPowrotu!!.title = "Powrót"

        opcjePracy.setOnCheckedChangeListener{_, isChecked ->

            when(isChecked) {
                R.id.strzyzenieMeskie -> wartoscPracy = 1.0

                R.id.strzyzenieDamskie -> wartoscPracy = 1.5

                R.id.koloryzacja -> wartoscPracy = 2.0
            }
        }



        obliczWartoscPracy.setOnClickListener {

            wartoscUslugi = obliczW(czasPracy2, wartoscPracy)


            wpiszWartosc.text = "Wartosc usłigi wynosi "+(wartoscUslugi)+" zł"
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun obliczW(czasP: Int, wartoscP: Double): Double{

        return czasP * wartoscP

    }

}
