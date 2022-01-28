package com.megahed.mybooks.feature_data.data.data_source.dao

import androidx.room.*
import com.megahed.mybooks.feature_data.domain.models.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Update
    suspend fun update(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Query("SELECT * FROM category")
    fun getCategory(): Flow<List<Category>>

    @Query("SELECT * FROM category WHERE id = :id")
    suspend fun getCategoryById(id: Int): Category?


    @Query("DELETE FROM category")
    fun deleteAllCategory()


}