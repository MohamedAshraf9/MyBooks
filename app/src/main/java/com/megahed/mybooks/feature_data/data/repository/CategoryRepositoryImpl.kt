package com.megahed.mybooks.feature_data.data.repository

import com.megahed.mybooks.feature_data.data.data_source.dao.CategoryDao
import com.megahed.mybooks.feature_data.domain.models.Category
import com.megahed.mybooks.feature_data.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(
    private val categoryDao: CategoryDao
):CategoryRepository {

    override suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    override suspend fun update(category: Category) {
        categoryDao.update(category)
    }

    override suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }

    override fun getCategories(): Flow<List<Category>> {
       return categoryDao.getCategories()
    }

    override suspend fun getCategoryById(id: Int): Category? {
       return categoryDao.getCategoryById(id)
    }

    override fun deleteAllCategory() {
        categoryDao.deleteAllCategory()
    }
}