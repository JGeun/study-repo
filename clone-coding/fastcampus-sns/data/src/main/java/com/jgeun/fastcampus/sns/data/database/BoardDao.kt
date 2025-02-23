package com.jgeun.fastcampus.sns.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jgeun.fastcampus.sns.data.model.BoardDTO

/**
 * @author   JGeun
 * @created  2025/02/23
 */
@Dao
interface BoardDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertAll(boards: List<BoardDTO>)

	@Query("DELETE FROM boarddto")
	fun deleteAll()

	@Query("SELECT * FROM boarddto ORDER BY id DESC")
	fun getAll(): PagingSource<Int, BoardDTO>
}