package com.adsap.todofirst.models.category

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("_id")
    var id : String,
    var description: String
)
