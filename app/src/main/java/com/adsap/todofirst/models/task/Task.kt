package com.adsap.todofirst.models.task

import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("_id")
    var id : String,
    var list : String,
    var description : String,
    @SerializedName("dt_prev")
    var dtPrev : String,
    @SerializedName("dt_exec")
    var dtExec : String,
    var responsible : String
)
