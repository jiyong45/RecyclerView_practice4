package com.example.recyclerview_practice4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainAdapter(private val context: Context,private val jsonData : List<JsonData.JsonDataItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class ItemViewHolder(itemView: View, parent : ViewGroup): RecyclerView.ViewHolder(itemView){
        val view = LayoutInflater.from(context).inflate(R.layout.main_recycle,parent,false)
        val test1_menu = itemView.findViewById<RecyclerView>(R.id.test1_menu)
        val test1_items = itemView.findViewById<ViewPager2>(R.id.test1_items)
        val test2_menu = itemView.findViewById<RecyclerView>(R.id.test2_menu)
        val test2_items = itemView.findViewById<RecyclerView>(R.id.test2_items)
        val test3_items = itemView.findViewById<RecyclerView>(R.id.test3_items)

        fun bind(jsonData: JsonData.JsonDataItem?) {


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
        val view = LayoutInflater.from(context).inflate(R.layout.main_recycle,parent,false)
        return ItemViewHolder(view,parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
        (holder as? ItemViewHolder)?.let{
            it.bind(jsonData?.getOrNull(position))
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return jsonData?.size ?: 0
    }
}