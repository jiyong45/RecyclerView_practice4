package com.example.recyclerview_practice4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Menu1Adapter(private val context: Context, private val dataList: JsonData) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ItemViewHolder(itemView: View, parent : ViewGroup): RecyclerView.ViewHolder(itemView) {
        val test1TabTitle = itemView.findViewById<TextView>(R.id.test1TabTitle)

        fun bind(test_list: JsonData.JsonDataItem?) {
            test1TabTitle.setText(test_list?.title ?: "")
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.test2_menu,parent,false)
        return ItemViewHolder(view,parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ItemViewHolder)?.let{
            it.bind(dataList?.getOrNull(position))
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }
}