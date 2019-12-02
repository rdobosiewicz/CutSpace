package com.example.cutspace

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.cutspace.StoreData.Product
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_to_store.*

class ToStore : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var productList: MutableList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_store)

        database = FirebaseDatabase.getInstance().getReference("products")

        productList = mutableListOf()

        //action bar for comeback to first page
        val pasekPowrotu = supportActionBar

        pasekPowrotu!!.title = "Powrót"

        val addP = findViewById<Button>(R.id.addProduct)

        addP.setOnClickListener{

            val intent = Intent(this, AddProduct::class.java)
            startActivity(intent)
        }

        database.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

                TODO()
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){

                    for(h in p0.children){
                        val pro = h.getValue(Product::class.java)
                        productList.add(pro!!)
                    }

                }
                }


        } )

        val tableOfProduct = findViewById<ListView>(R.id.tableP)

        tableOfProduct.adapter = MyProductAdapter(this, productList)


    }

    //
    private class MyProductAdapter(context: Context, val productList: List<Product>): BaseAdapter(){


        private val mContext: Context


        init {
            mContext = context
        }

        //responsible for how many rows in my list
        override fun getCount(): Int {
            return productList.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
           return "Test"
        }
        // responsible for rendering out ech row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val textView = TextView(mContext)


            val nameProduct = productList[position]

            textView.text = nameProduct.productName

            textView.textSize = 20F
            return textView

        }
    }

    //this fun is for supportActionBar "pasekPowrotu". He make way comeback to main page
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
