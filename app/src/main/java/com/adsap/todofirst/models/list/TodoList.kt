package com.adsap.todofirst.models.list

import com.google.gson.annotations.SerializedName

data class TodoList(
    @SerializedName("_id")
    var id : String,
    var author : String,
    var title : String,
    var description : String,
    var category : String
)
