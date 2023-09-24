package com.example.pruebapt.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebapt.databinding.ActivityMainBinding
import com.example.pruebapt.presentation.BankListViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: BankListViewModel by viewModels()
    private lateinit var adapter: AdpBank
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            viewModel.apiCall(this)

        }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        viewModel.adpBank.observe(this){
            adapter = it
            binding.recycler.adapter = it
        }
    }
}