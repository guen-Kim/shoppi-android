package org.techtown.shoppi_android.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.techtown.shoppi_android.model.Category
import org.techtown.shoppi_android.model.CategoryDetail
import org.techtown.shoppi_android.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * HTTP 통신 객체
 * */
interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories(): List<Category>
    @GET("fashion_female.json")
    suspend fun getCategoryDetail() : CategoryDetail
    @GET("products/{productId}.json")
    suspend fun getProductDetail(@Path("productId") productId: String) : Product




    /**
     *
메서드의 인자로 url path 정보 받을 경우
@GET("{categoryId}.json")
suspend fun getCategoryDetail(@Path("categoryId") categoryId: String) : CategoryDetail

     * **/


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