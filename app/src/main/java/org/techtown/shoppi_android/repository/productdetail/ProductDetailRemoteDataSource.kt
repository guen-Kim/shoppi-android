package org.techtown.shoppi_android.repository.productdetail

import org.techtown.shoppi_android.model.Product
import org.techtown.shoppi_android.network.ApiClient

class ProductDetailRemoteDataSource(private val api : ApiClient): ProductDetailDataSource {

    //api에 데이터 요청
    override suspend fun getProductDetailData(productId: String): Product {
        return api.getProductDetail(productId)
    }
}