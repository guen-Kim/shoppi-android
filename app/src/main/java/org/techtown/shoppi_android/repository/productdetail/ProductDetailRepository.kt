package org.techtown.shoppi_android.repository.productdetail

import org.techtown.shoppi_android.model.Product
import javax.inject.Inject

class ProductDetailRepository @Inject constructor(
    private val remoteProduct: ProductDetailRemoteDataSource
) {

    suspend fun getProductDetailData(productId: String): Product {
        return remoteProduct.getProductDetailData(productId)
    }
}