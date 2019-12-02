package com.example.cutspace

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.cutspace.StoreData.Product
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProduct : AppCompatActivity() {

    lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        var nameP = "null"
        var useP = "null"
        var capacityP = "null"
        var categoryP = "null"

        //action bar for comeback of store
        val pasekPowrotu = supportActionBar
        pasekPowrotu!!.title = "Powrót"
        //radioGroup for use product and save to variable
        zastosowanieProduktu.setOnCheckedChangeListener{_, isChecked ->

            when(isChecked){
                R.id.odzywki_I_Szampony ->
                    useP = odzywki_I_Szampony.text.toString()
                R.id.farbyDoWlosow ->
                    useP = farbyDoWlosow.text.toString()
                R.id.inneProdukty ->
                    useP = inneProdukty.text.toString()
            }
        }

        kategoriaProduktu.setOnCheckedChangeListener{_, isChecked ->

            when(isChecked){
                R.id.dlaSklepu ->
                    categoryP = dlaSklepu.text.toString()
                R.id.dlaSalonuFryzierskiego ->
                    categoryP = dlaSalonuFryzierskiego.text.toString()
            }

        }

        //listener for add product to base
        przyciskDodajProdukt.setOnClickListener {
            //saved name which one write in the gap on app under name to variable nameP
            editText = findViewById(R.id.nProduktu) as EditText
            nameP = editText.text.toString()
            //saved capacity which one write in the gap on app under name to variable capacity
            editText = findViewById(R.id.pojemnoscProduktu) as EditText
            capacityP = editText.text.toString()
            //save new product (object) to database of firebase
            var addNewProduct = Product()
            with(addNewProduct){
                productName = nameP
                purpose = useP
                capacity = capacityP.toDouble()
                category = categoryP
            }

            var firebaseDatabase = FirebaseDatabase.getInstance()
            var databaseReference = firebaseDatabase.getReference()
            databaseReference.child("products").push().setValue(addNewProduct)
        }



    }




    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
