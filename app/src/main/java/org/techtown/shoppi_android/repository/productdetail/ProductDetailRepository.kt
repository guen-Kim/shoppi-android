package org.techtown.shoppi_android.repository.productdetail

import org.techtown.shoppi_android.model.Product

class ProductDetailRepository(
    private val remoteProduct: ProductDetailRemoteDataSource
) {

    suspend fun getProductDetailData(productId: String): Product {
        return remoteProduct.getProductDetailData(productId)
    }
}