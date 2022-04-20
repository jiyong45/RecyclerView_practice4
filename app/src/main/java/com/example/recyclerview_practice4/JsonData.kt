package com.example.recyclerview_practice4


import com.google.gson.annotations.SerializedName

class JsonData : ArrayList<JsonData.JsonDataItem>(){
    data class JsonDataItem(
        @SerializedName("list")
        var list: List<Test>?,
        @SerializedName("tabList")
        var tabList: List<Test2>?,
        @SerializedName("title")
        var title: String?
    ) {
        data class Test(
            @SerializedName("img")
            var img: String?,
            @SerializedName("subTitle")
            var subTitle: String?,
            @SerializedName("title")
            var title: String?
        )
        data class Test2(
            @SerializedName("list")
            var list: List<detailImg>?,
            @SerializedName("tabName")
            var tabName: String?
        ) {
            data class detailImg(
                @SerializedName("img")
                var img: String?
            )
        }
    }
}