package com.megahed.mybooks.feature_data.data.repository

import com.megahed.mybooks.feature_data.data.data_source.dao.CategoryDao
import com.megahed.mybooks.feature_data.domain.models.Category
import com.megahed.mybooks.feature_data.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(
    private val categoryDao: CategoryDao
):CategoryRepository {

    override suspend fun insertCategory(category: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun update(category: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCategory(category: Category) {
        TODO("Not yet implemented")
    }

    override fun getCategory(): Flow<List<Category>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategoryById(id: Int): Category? {
        TODO("Not yet implemented")
    }

    override fun deleteAllCategory() {
        TODO("Not yet implemented")
    }
}