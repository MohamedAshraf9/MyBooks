package com.megahed.mybooks.feature_data.domain.repository

import com.megahed.mybooks.feature_data.domain.models.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {


    suspend fun insertCategory(category: Category)

    suspend fun update(category: Category)

    suspend fun deleteCategory(category: Category)

    fun getCategories(): Flow<List<Category>>

    suspend fun getCategoryById(id: Int): Category?

    fun deleteAllCategory()

}
