package com.example.letsgetcheckedassignment

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers(
        "x-rapidapi-host: restcountries-v1.p.rapidapi.com",
        "x-rapidapi-key:804fe48456msh73835d4c2e34dddp1291a1jsn3847ab1f6f0d"
    )
    @GET(".")
    fun getData(): Call<List<DataModel>>

}