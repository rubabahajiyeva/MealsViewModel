package com.rubabe.mealviewmodel.api


import com.rubabe.mealviewmodel.model.MealsResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("search.php")
    fun getMealData(@Query("s") s: String): Call<MealsResult>

    @GET("lookup.php")
    fun getMealByIdDetails(@Query("i") i: String): Call<MealsResult>

    @GET("random.php")
    fun getMealByRandom(): Call<MealsResult>
}