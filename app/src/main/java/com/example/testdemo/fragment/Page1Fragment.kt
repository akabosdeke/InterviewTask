package com.example.testdemo.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testdemo.Response.ResponseApiUser
import com.example.testdemo.adapter.ApplicationAdapter
import com.example.testdemo.apiPackage.ApiHelperImpl
import com.example.testdemo.apiPackage.RetrofitBuilder
import com.example.testdemo.base.UiState
import com.example.testdemo.base.ViewModelFactory
import com.example.testdemo.databasePackage.DatabaseHelperImpl
import com.example.testdemo.databasePackage.entity.DatabaseBuilder
import com.example.testdemo.databinding.FragmentPage1Binding
import com.example.testdemo.utils.ProgressDialogUtils
import com.example.testdemo.viewModel.MainViewModel


class Page1Fragment : Fragment(){

    private var _binding: FragmentPage1Binding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: MainViewModel
    var userList :List<ResponseApiUser.Data.App>?= arrayListOf()
var applicationAdapter:ApplicationAdapter?=null


    // progressbar instance
    private val customProgressDialog by lazy {
        ProgressDialogUtils()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPage1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        initViews()
        observer()
    }

    private fun initViews() {


        _binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty()) {
           var a= userList?.filter { it.appName.toString().contains(s, ignoreCase = true) }
                    _binding?.rvApplication?.adapter =ApplicationAdapter(a?: arrayListOf())
                 //  applicationAdapter?.notifyDataSetChanged()
                }

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }



    private fun observer() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Success -> {
                    customProgressDialog.hideProgress()
                    it.data.data.let {
                        userList = it?.appList?: arrayListOf()
                        applicationAdapter= ApplicationAdapter(userList!!)
                        _binding?.rvApplication?.adapter =applicationAdapter
                    }


                }

                is UiState.Loading -> {
                    customProgressDialog.showProgress(requireContext())

                }

                is UiState.Error -> {
                    //Handle Error
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this, ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService), DatabaseHelperImpl(
                    DatabaseBuilder.getInstance(requireContext())
                )
            )
        )[MainViewModel::class.java]
    }


}