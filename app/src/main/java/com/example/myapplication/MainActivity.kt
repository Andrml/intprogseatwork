package com.example.myapplication

import Customer
import Transaction
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf<Customer>()
        list.add(
            Customer(
                25, "Maraiah Queen Arceta", "VVIP", R.drawable.aiah,
                listOf(
                    Transaction("January 13, 2024", 2500),
                    Transaction("January 19, 2024", 8500),
                    Transaction("January 23, 2024", 13000),
                )
            )
        )
        list.add(
            Customer(
                25, "Colet Vergara", "VIP", R.drawable.colet,
                listOf(
                    Transaction("January 13, 2024", 2500),
                    Transaction("January 19, 2024", 8500),
                    Transaction("January 23, 2024", 13000),
                )
            )
        )
        list.add(
            Customer(
                25, "Maloi Ricalde", "REGULAR", R.drawable.maloi,
                listOf(
                    Transaction("January 13, 2024", 2500),
                    Transaction("January 19, 2024", 8500),
                    Transaction("January 23, 2024", 13000),
                )
            )
        )
        list.add(
            Customer(
                25, "Stacey Sevilleja", "VVIP", R.drawable.stacey,
                listOf(
                    Transaction("January 13, 2024", 2500),
                    Transaction("January 19, 2024", 8500),
                    Transaction("January 23, 2024", 13000),
                )
            )
        )
        list.add(
            Customer(
                25, "Gwen Apuli", "VVIP", R.drawable.gwen,
                listOf(
                    Transaction("January 13, 2024", 2500),
                    Transaction("January 19, 2024", 8500),
                    Transaction("January 23, 2024", 13000),
                )
            )
        )
        list.add(
            Customer(
                25, "Mikhaela Janna Lim", "VVIP", R.drawable.mikha,
                listOf(
                    Transaction("January 13, 2024", 2500),
                    Transaction("January 19, 2024", 8500),
                    Transaction("January 23, 2024", 13000),
                )
            )
        )
        list.add(
            Customer(
                25, "Jhoanna Robles", "VVIP", R.drawable.jhoanna,
                listOf(
                    Transaction("January 13, 2024", 2500),
                    Transaction("January 19, 2024", 8500),
                    Transaction("January 23, 2024", 13000),
                )
            )
        )
        myAdapter = MyAdapter(this, list)
        val listView = findViewById<ListView>(R.id.list)
        listView.adapter = myAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val customer = list[position]
            val intent = Intent(this, CustomerDetails::class.java)
            // Pass individual fields
            intent.putExtra("Number", customer.number)
            intent.putExtra("Name", customer.name)
            intent.putExtra("Type", customer.type)
            intent.putExtra("Image", customer.image)
            // Pass transactions as an ArrayList
            intent.putExtra("Transactions", ArrayList(customer.transactions))
            startActivity(intent)
        }
    }
}
