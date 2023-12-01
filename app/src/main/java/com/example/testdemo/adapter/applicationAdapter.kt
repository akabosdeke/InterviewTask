package com.example.testdemo.adapter


import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testdemo.R
import com.example.testdemo.Response.ResponseApiUser
import com.example.testdemo.databinding.LayoutRecyclerBinding

//var userList: ArrayList<ResponseApiUser.Data.App>?
class ApplicationAdapter(
    var userList: List<ResponseApiUser.Data.App>,

) : RecyclerView.Adapter<ApplicationAdapter.ViewHolder>(){
    lateinit var binding: LayoutRecyclerBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = LayoutRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.apply {
            with(holder.binding) {
                if (userList?.get(position)?.appName.toString().isNotEmpty()) {
                    tvName.text = userList?.get(position)?.appName ?: ""
                }
                if (userList?.get(position)?.appIcon.toString().isNotEmpty()) {
                    Glide.with(context).load(userList?.get(position)?.appIcon)
                        .placeholder(R.drawable.photo).into(rvImage)

                }

                toggle?.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        Toast.makeText(context, "Switch is Checked", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Switch is Not Checked", Toast.LENGTH_SHORT).show()

                    }
                }


            }

        }

    }

    override fun getItemCount(): Int {
        return userList?.size ?: 0
    }

    inner class ViewHolder(val binding: LayoutRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }



}

