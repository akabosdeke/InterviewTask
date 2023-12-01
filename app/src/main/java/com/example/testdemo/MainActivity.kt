package com.example.testdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.testdemo.apiPackage.ApiHelperImpl
import com.example.testdemo.apiPackage.RetrofitBuilder
import com.example.testdemo.base.UiState
import com.example.testdemo.base.ViewModelFactory
import com.example.testdemo.databasePackage.DatabaseHelperImpl
import com.example.testdemo.databasePackage.entity.DatabaseBuilder
import com.example.testdemo.databinding.ActivityMainBinding
import com.example.testdemo.fragment.Page1Fragment
import com.example.testdemo.fragment.Page2Fragment
import com.example.testdemo.utils.statusBar
import com.example.testdemo.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    private lateinit  var viewPagerAdapter:ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBar()
        initViews()
      initControll()
    }

    private fun initControll() {
        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initViews() {

       viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.add(Page1Fragment(), "Applications")
        viewPagerAdapter.add(Page2Fragment(), "Settings")
        binding.viewpager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }


}