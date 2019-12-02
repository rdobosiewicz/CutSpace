package com.example.cutspace.StoreData

import java.io.Serializable

data class Product(
                var productName: String = "name",
                // nr id produktu
                var art: Int = 0,
                //zastosowanie np. farba do włosów
                var purpose: String = "",
                //pojemnosc produktu np. 100 ml itp.
                var capacity: Double = 0.0,
                //kategoria produktu
                var category: String = "")