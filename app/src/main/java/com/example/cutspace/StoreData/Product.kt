package com.example.cutspace.StoreData

import java.io.Serializable

data class Product(
                var productName: String = "",
                var art: Int = 0,
                // nr id produktu
                var barCode: Int = 0,
                //zastosowanie np. farba do włosów
                var purpose: String = "",
                //pojemnosc produktu np. 100 ml itp.
                var capacity: Double = 0.0) : Serializable