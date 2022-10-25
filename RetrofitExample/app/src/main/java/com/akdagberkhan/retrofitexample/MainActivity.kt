package com.akdagberkhan.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.akdagberkhan.retrofitexample.data.api.ApiClient
import com.akdagberkhan.retrofitexample.data.model.Post
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        initNavController()
        //getPosts()

    }

    private fun initNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }


    private fun getPosts(){

        ApiClient.getApiService().getPosts().enqueue(object  : retrofit2.Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.isSuccessful)
                {
                    val post= response.body()
                    post?.let{
                        Log.d("test",it.toString())
                    }
                }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {


            }
        })

    }

}