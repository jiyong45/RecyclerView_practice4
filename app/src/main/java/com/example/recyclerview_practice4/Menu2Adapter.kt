package com.example.recyclerview_practice4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Menu2Adapter (private val context: Context, private val dataList : List<JsonData.JsonDataItem.Test2>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ItemViewHolder(itemView: View, parent : ViewGroup): RecyclerView.ViewHolder(itemView) {
        val test2TabTitle = itemView.findViewById<TextView>(R.id.test2TabTitle)

        fun bind(test3_list: JsonData.JsonDataItem.Test2?) {
            test2TabTitle.setText(test3_list?.tabName ?: "")
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