package com.jgeun.fastcampus.sns.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author   JGeun
 * @created  2025/02/23
 */

@Entity("remote_key")
data class RemoteKey(
	@PrimaryKey val nextPage: Int
)