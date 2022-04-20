package com.example.recyclerview_practice4

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Item3Adapter (private val context: Context, private val dataList : List<JsonData.JsonDataItem.Test>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ItemViewHolder(itemView: View, parent : ViewGroup): RecyclerView.ViewHolder(itemView) {
        val item3_img = itemView.findViewById<ImageView>(R.id.item3_img)
        val test3_cnt = itemView.findViewById<TextView>(R.id.test3_cnt)
        val test3Title = itemView.findViewById<TextView>(R.id.test3Title)
        val test3Descript = itemView.findViewById<TextView>(R.id.test3Descript)

        fun bind(test3_list : JsonData.JsonDataItem.Test?) {
            Glide.with(context).load(test3_list?.img).into(item3_img)
            test3_cnt.setText((position+1).toString())
            test3Title.setText(test3_list?.title ?: "")
            test3Descript.setText(test3_list?.subTitle ?:"")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.test3_item,parent,false)
        return ItemViewHolder(view,parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ItemViewHolder)?.let {
            it.bind(dataList?.getOrNull(position))
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }
}