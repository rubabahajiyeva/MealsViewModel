package com.rubabe.mealviewmodel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.rubabe.mealviewmodel.adapter.SearchAdapter
import com.rubabe.mealviewmodel.databinding.ActivityMainBinding
import com.rubabe.mealviewmodel.viewmodel.MainActivityViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getMealByRandom(this)
        binding.apply {
            mealIdEditText.visibility = View.GONE
            searchButton.setOnClickListener {
                viewModel.getMeal(this@MainActivity, mealEditText.text.toString())
            }
            searchButtonById.setOnClickListener {
                viewModel.getMealById(this@MainActivity, mealIdEditText.text.toString())
                mealIdEditText.visibility = View.VISIBLE
            }
        }

        viewModel.mealsLiveData.observe(this, Observer { MealData ->
            binding.recyclerView.adapter = viewModel.mealsLiveData.value?.meals?.let {
                SearchAdapter(
                    it
                )
            }
        })


    }
}