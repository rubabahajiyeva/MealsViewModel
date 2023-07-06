package com.rubabe.mealviewmodel.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rubabe.mealviewmodel.Constants
import com.rubabe.mealviewmodel.api.Api
import com.rubabe.mealviewmodel.model.Meals
import com.rubabe.mealviewmodel.model.MealsResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel(){
    lateinit var api: Api
    var mealsLiveData = MutableLiveData<MealsResult?>()

    fun getMeal(context : Context, s: String) {
        api = Constants.getApi()
        api.getMealData(s).enqueue(object: Callback<MealsResult> {
            override fun onResponse(call: Call<MealsResult>, response: Response<MealsResult>) {
                val data = response.body()
                mealsLiveData.postValue(data)
            }

            override fun onFailure(call: Call<MealsResult>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }


        })

    }

    fun getMealById(context : Context, i: String) {
        api = Constants.getApi()
        api.getMealByIdDetails(i).enqueue(object: Callback<MealsResult> {
            override fun onResponse(call: Call<MealsResult>, response: Response<MealsResult>) {
                val data = response.body()
                mealsLiveData.postValue(data)
            }

            override fun onFailure(call: Call<MealsResult>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })
    }

    fun getMealByRandom(context : Context) {
        api = Constants.getApi()
        api.getMealByRandom().enqueue(object: Callback<MealsResult> {
            override fun onResponse(call: Call<MealsResult>, response: Response<MealsResult>) {
                val data = response.body()
                mealsLiveData.postValue(data)
            }

            override fun onFailure(call: Call<MealsResult>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

        })
    }

}