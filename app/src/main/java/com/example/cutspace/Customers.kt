package com.example.cutspace

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Customers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customers)



        //action bar for comeback to first page
        val pasekPowrotu = supportActionBar

        pasekPowrotu!!.title = "Powrót"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
