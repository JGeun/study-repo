package com.jgeun.fastcampus.sns.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jgeun.fastcampus.sns.data.model.BoardDTO

/**
 * @author   JGeun
 * @created  2025/02/23
 */
@Database(
	entities = [BoardDTO::class, RemoteKey::class],
	version = 1
)
@TypeConverters(CommentConverter::class)
abstract class BoardDatabase : RoomDatabase() {
	abstract fun boardDao(): BoardDao

	abstract fun remoteKeyDao(): RemoteKeyDao
}