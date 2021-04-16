package com.adsap.todofirst.api.endpoints

import com.adsap.todofirst.models.EntityRemovedResponse
import com.adsap.todofirst.models.user.User
import com.adsap.todofirst.models.user.UserResponse
import com.adsap.todofirst.models.user.UsersResponse
import retrofit2.Call
import retrofit2.http.*

interface UserEndpoint {

    @GET("users")
    fun getUsers() : Call<UsersResponse>

    @GET("users/{id}")
    fun getUser(@Path("id") id: String) : Call<UserResponse>

    @POST("users")
    fun addUser(@Body user: User) : Call<UserResponse>

    @PUT("users/{id}")
    fun updateUser(@Path("id") id: String) : Call<UserResponse>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id: String) : Call<EntityRemovedResponse>
}