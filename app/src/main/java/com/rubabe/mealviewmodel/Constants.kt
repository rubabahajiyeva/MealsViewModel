package com.rubabe.mealviewmodel

import com.rubabe.mealviewmodel.api.Api
import com.rubabe.mealviewmodel.network.RetrofitClient

class Constants {
    companion object{
        val BASE_URL = "https://themealdb.com/api/json/v1/1/"

        fun getApi(): Api {
            return RetrofitClient.getClient(BASE_URL).create(Api::class.java)
        }
    }
}