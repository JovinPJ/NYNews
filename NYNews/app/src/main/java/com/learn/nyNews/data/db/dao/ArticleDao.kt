package com.learn.nyNews.data.db.dao

import androidx.room.*
import com.learn.nyNews.data.db.entity.ArticleEntity

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllArticles(articles: List<ArticleEntity>)

    @Query("SELECT * FROM Article WHERE `title` = :title")
    suspend fun fetchArticle(title: String): ArticleEntity

    @Query("SELECT * FROM Article")
    suspend fun fetchAllArticles(): List<ArticleEntity>

    @Delete
    suspend fun deleteArticle(articleEntity: ArticleEntity)

    @Query("DELETE FROM Article")
    suspend fun deleteAll()
}