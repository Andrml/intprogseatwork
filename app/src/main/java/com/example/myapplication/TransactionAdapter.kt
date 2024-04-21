package com.example.myapplication

import Transaction
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class TransactionAdapter(
    context: Context,
    val resource: Int,
    val list: List<Transaction>) :
    ArrayAdapter<Transaction>(context, resource, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder()
            viewHolder.textViewMonth = view.findViewById(R.id.textViewMonth)
            viewHolder.textViewAmount = view.findViewById(R.id.textViewAmount)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val transaction = getItem(position)

        viewHolder.textViewMonth?.text = transaction?.month
        viewHolder.textViewAmount?.text = transaction?.amount.toString()

        return view ?: View(context)
    }

    private class ViewHolder {
        var textViewMonth: TextView? = null
        var textViewAmount: TextView? = null
    }
}
