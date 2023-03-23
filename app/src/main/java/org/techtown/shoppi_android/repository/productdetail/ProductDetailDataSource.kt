package org.techtown.shoppi_android.repository.productdetail

import org.techtown.shoppi_android.model.Product

interface ProductDetailDataSource {
    suspend fun getProductDetailData(productId: String) : Product
}