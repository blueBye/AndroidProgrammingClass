package info.navidlabs.androidprogrammingclass.utils

import info.navidlabs.androidprogrammingclass.data.ApiInterface
import info.navidlabs.androidprogrammingclass.utils.Config.baseURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}