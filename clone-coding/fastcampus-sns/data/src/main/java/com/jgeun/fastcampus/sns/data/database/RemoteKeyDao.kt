package com.jgeun.fastcampus.sns.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author   JGeun
 * @created  2025/02/23
 */
@Dao
interface RemoteKeyDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertOrReplace(remoteKey: RemoteKey)

	@Query("SELECT * FROM remote_key ORDER BY nextPage DESC LIMIT 1")
	suspend fun getNextKey(): RemoteKey

	@Query("DELETE FROM remote_key")
	suspend fun deleteAll()
}