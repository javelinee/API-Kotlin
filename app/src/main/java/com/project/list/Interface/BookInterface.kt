package com.project.list.Interface

import com.project.list.Data.BookData
import retrofit2.Call
import retrofit2.http.GET


interface BookInterface {
    @GET("/repositories")
    fun getData() : Call<List<BookData>>

}