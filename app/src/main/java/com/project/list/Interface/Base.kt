package com.project.list.Interface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val url = "https://ghapi.huchen.dev/repositories/"

interface Base {
    companion object {
            var retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
    }
}