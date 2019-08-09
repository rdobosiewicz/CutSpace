package com.example.cutspace

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.cutspace.StoreData.Product

class AddProduct : AppCompatActivity() {

    lateinit var nameProduct : EditText
    lateinit var artNumber : EditText
    lateinit var barCodeNumber : EditText
    lateinit var purposeName : EditText
    lateinit var capacitySize : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        //action bar for comeback of store
        val pasekPowrotu = supportActionBar
        pasekPowrotu!!.title = "Powrót"



    }




    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
