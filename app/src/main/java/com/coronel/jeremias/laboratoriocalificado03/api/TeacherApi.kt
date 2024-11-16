package com.coronel.jeremias.laboratoriocalificado03.api

import retrofit2.Call
import retrofit2.http.GET
import com.coronel.jeremias.laboratoriocalificado03.models.Teacher

// Interfaz para definir los endpoints del API
interface TeacherApi {

    // Endpoint para obtener la lista de profesores
    @GET("list/teacher-b")
    fun getTeachers(): Call<Map<String, List<Teacher>>>
}