package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import Transaction
import android.graphics.Color

class CustomerDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_details)

        val number = intent.getIntExtra("Number", 0)
        val name = intent.getStringExtra("Name") ?: ""
        val type = intent.getStringExtra("Type") ?: ""
        val image = intent.getIntExtra("Image", R.drawable.bini)
        val transactions =
            intent.getSerializableExtra("Transactions") as? ArrayList<Transaction> ?: ArrayList()

        findViewById<TextView>(R.id.text_customer_number).text = "Customer#: $number"
        findViewById<TextView>(R.id.text_customer_name).text = "Customer Name: $name"
        findViewById<TextView>(R.id.text_customer_type).text = "Customer Type: $type"
        findViewById<ImageView>(R.id.customer_image).setImageResource(image)

        val transactionListView = findViewById<ListView>(R.id.listViewDetails)
        val transactionAdapter = TransactionAdapter(this, R.layout.item_transaction, transactions)
        transactionListView.adapter = transactionAdapter

        val backBtn = findViewById<Button>(R.id.customBackBtn)
        backBtn.setOnClickListener {
            finish()
        }

        // Set the background color based on the customer type
        val customerTypeColor = when (type) {
            "VVIP" -> Color.parseColor("#FF0000") // Red
            "VIP" -> Color.parseColor("#00FF00") // Green
            "REGULAR" -> Color.parseColor("#0000FF") // Blue
            "PWD" -> Color.parseColor("#FFFF00") // Yellow
            else -> Color.parseColor("#000000") // Black
        }
    }
}