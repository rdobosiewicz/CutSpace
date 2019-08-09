package com.example.cutspace

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ToStore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_store)

        //action bar for comeback to first page
        val pasekPowrotu = supportActionBar

        pasekPowrotu!!.title = "Powrót"

        val addP = findViewById<Button>(R.id.addProduct)

        addP.setOnClickListener{

            val intent = Intent(this, AddProduct::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
