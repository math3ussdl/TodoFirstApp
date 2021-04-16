package com.adsap.todofirst.api.endpoints

import com.adsap.todofirst.models.list.TodoListsResponse
import retrofit2.Call
import retrofit2.http.GET

interface TodoListEndpoint {

    @GET("lists")
    fun getLists() : Call<TodoListsResponse>
}