package com.example.recyclerview_practice4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Item2Adapter (private val context: Context, private val dataList : List<JsonData.JsonDataItem.Test2.detailImg>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ItemViewHolder(itemView: View, parent : ViewGroup): RecyclerView.ViewHolder(itemView) {
        val test2Img = itemView.findViewById<ImageView>(R.id.test2Img)
        val test2Title = itemView.findViewById<TextView>(R.id.test2Title)

        fun bind(test3_list : JsonData.JsonDataItem.Test2.detailImg?) {
            Glide.with(context).load(test3_list).into(test2Img)
            //test2Title.setText(test3_list?.tabName ?: "")
            //여기서 text는 어떻게 받아야되지? ;;
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.test2_menu,parent,false)
        return ItemViewHolder(view,parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? Item2Adapter.ItemViewHolder)?.let{
            it.bind(dataList?.getOrNull(position))
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }
}