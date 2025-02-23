package com.jgeun.fastcampus.sns.data.di

import android.content.Context
import androidx.room.Room
import com.jgeun.fastcampus.sns.data.database.BoardDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author   JGeun
 * @created  2025/02/23
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class SingletonModule {

	companion object {

		@Provides
		fun provideBoardDatabase(context: Context): BoardDatabase {
			return Room.databaseBuilder(
				context,
				BoardDatabase::class.java,
				"BoardDatabase"
			)
				.build()
		}
	}
}