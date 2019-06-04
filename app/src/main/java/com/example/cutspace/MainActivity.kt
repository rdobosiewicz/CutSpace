package com.example.cutspace

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //main buttons in app
        val magazyn = findViewById<Button>(R.id.store)

        magazyn.setOnClickListener{

            val intent = Intent(this, ToStore::class.java)
            startActivity(intent)
        }

        val wycenaUslugi = findViewById<Button>(R.id.services)

        wycenaUslugi.setOnClickListener{

            val intentTwo = Intent(this, Services::class.java)
            startActivity(intentTwo)
        }

        val listaKlientow = findViewById<Button>(R.id.customerList)

        listaKlientow.setOnClickListener{

            val intentThree = Intent(this, Customers::class.java)
            startActivity(intentThree)
        }

        val sprzedaz = findViewById<Button>(R.id.sale)

        sprzedaz.setOnClickListener{

            val intentFour = Intent(this, Sale::class.java)
            startActivity(intentFour)
        }
    }
}
