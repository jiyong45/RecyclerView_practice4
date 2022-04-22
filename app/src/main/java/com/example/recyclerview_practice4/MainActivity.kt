package com.example.recyclerview_practice4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val jsonString by lazy { getJsonDataFromAsset() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (jsonString != null) {
            val data = Gson().fromJson(jsonString, JsonData::class.java)
            val mAdapter = MainAdapter(this,data)
            val main_recyclerView = findViewById<RecyclerView>(R.id.main_scroll)
            main_recyclerView.adapter = mAdapter

        }
    }

    fun getJsonDataFromAsset() : String {

        val jsonString: String
        try{
            jsonString =this.assets.open("jsons/item_json.json").bufferedReader().use{it.readText()}
        } catch (ioExceiption: IOException){
            ioExceiption.printStackTrace()
            return ""
        }
        return jsonString
    }
}