package com.example.recyclerview_practice4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Item1Adapter (private val context: Context, private val data2List: List<JsonData.JsonDataItem.Test>?) : RecyclerView.Adapter<Item1Adapter.ItemViewHolder>(){
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val test1Img = itemView.findViewById<ImageView>(R.id.test1Img)
        val test1Title = itemView.findViewById<TextView>(R.id.test1Title)
        val test1Descript = itemView.findViewById<TextView>(R.id.test1Descript)

        fun bind(jsonData: JsonData.JsonDataItem.Test?) {
            Glide.with(context).load(jsonData?.img).into(test1Img)
            test1Title.setText(jsonData?.title)
            test1Descript.setText(jsonData?.subTitle)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test1_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data2List?.size ?: 0
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        (holder as? ItemViewHolder)?.let { it ->
            it.bind(data2List?.get(position))
        }
    }
}