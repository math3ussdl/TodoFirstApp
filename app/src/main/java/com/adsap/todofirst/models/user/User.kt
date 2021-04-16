package com.adsap.todofirst.models.user

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id")
    var id : String,
    var name : String,
    var phone : String,
    var email : String
)
