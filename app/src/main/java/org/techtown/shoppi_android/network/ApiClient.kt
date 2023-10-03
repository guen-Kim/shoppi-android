package org.techtown.shoppi_android.network

import org.techtown.shoppi_android.model.Category
import org.techtown.shoppi_android.model.CategoryDetail
import org.techtown.shoppi_android.model.Product
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
}