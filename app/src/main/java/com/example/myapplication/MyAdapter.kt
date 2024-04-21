package com.example.myapplication

import Customer
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(val activity: Activity, val list: List<Customer>) :
    ArrayAdapter<Customer>(activity, R.layout.item_list, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.item_list, parent, false)
            viewHolder = ViewHolder()
            viewHolder.imageView = view.findViewById(R.id.imageViewCustomer)
            viewHolder.textViewNumber = view.findViewById(R.id.textViewNumber)
            viewHolder.textViewName = view.findViewById(R.id.textViewName)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val customer = list[position]

        viewHolder.textViewNumber?.text = customer.number.toString()
        viewHolder.textViewName?.text = customer.name
        viewHolder.imageView?.setImageResource(customer.image)

        view?.setOnClickListener {
            val intent = Intent(activity, CustomerDetails::class.java)
            intent.putExtra("Number", customer.number)
            intent.putExtra("Name", customer.name)
            intent.putExtra("Type", customer.type)
            intent.putExtra("Image", customer.image)
            activity.startActivity(intent)
        }

        return view!!
    }

    private class ViewHolder {
        var imageView: ImageView? = null
        var textViewNumber: TextView? = null
        var textViewName: TextView? = null
    }
}
