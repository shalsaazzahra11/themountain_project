package org.d3if4038.themountain.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/shalsaazzahra11/mountain-asset/data_mountain/mountain_json/"

//object moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//object retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface TheMountainApiService{
    @GET("mountainfix.json")
    fun getProperties(): Deferred<List<TheMountainProperty>>
    object TheMountainApi{
        val retrofitService : TheMountainApiService by lazy {
            retrofit.create(TheMountainApiService::class.java)
        }
    }
}