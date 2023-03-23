package org.techtown.shoppi_android.network


/**
*
* ServiceLocator
 * ApiClient 재사용
*
***/

object ServiceLocator {

    private var apiClient: ApiClient? = null

    // ApiClient 가 이미 생성되었 섰는지 판단
    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }
}