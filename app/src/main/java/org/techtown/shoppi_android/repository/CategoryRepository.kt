package org.techtown.shoppi_android.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.techtown.shoppi_android.model.Category

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {

    suspend fun getCategories():List<Category> {
       /* // 코루틴이 실행될 스레드 변경 X Retrofit 내부에서 지원해줌
        withContext(Dispatchers.IO){
            remoteDataSource.getCategories()
        }*/


        return remoteDataSource.getCategories()
    }
}