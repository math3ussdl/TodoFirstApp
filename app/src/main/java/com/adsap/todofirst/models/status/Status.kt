package com.adsap.todofirst.models.status

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("_id")
    var id : String,
    var description: String
)
