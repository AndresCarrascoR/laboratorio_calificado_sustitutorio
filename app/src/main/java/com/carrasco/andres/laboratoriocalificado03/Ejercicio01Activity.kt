package com.carrasco.andres.laboratoriocalificado03

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carrasco.andres.laboratoriocalificado03.api.RetrofitInstance
import com.carrasco.andres.laboratoriocalificado03.models.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Ejercicio01Activity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchPosts()
    }

    private fun fetchPosts() {
        RetrofitInstance.api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body() ?: emptyList()
                    postAdapter = PostAdapter(this@Ejercicio01Activity, posts)
                    recyclerView.adapter = postAdapter
                } else {
                    // Manejar el error de respuesta no exitosa
                    Log.e("Ejercicio01Activity", "Error en la respuesta del API: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // Manejar el error de falla en la solicitud
                Log.e("Ejercicio01Activity", "Error en la solicitud del API: ${t.message}")
            }
        })
    }
}