package org.techtown.shoppi_android.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.techtown.shoppi_android.model.Category
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * HTTP 통신 객체
 * */
interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories(): List<Category>

    companion object {


        private val baseUrl = "https://shoppi-b0c49-default-rtdb.firebaseio.com/"


        fun create(): ApiClient {

            val logger = HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()


            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(ApiClient::class.java)
        }
    }
}