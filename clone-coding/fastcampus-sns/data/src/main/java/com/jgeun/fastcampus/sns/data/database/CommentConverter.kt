package com.jgeun.fastcampus.sns.data.database

import androidx.room.TypeConverter
import com.jgeun.fastcampus.sns.data.model.CommentDTO
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * @author   JGeun
 * @created  2025/02/23
 */
class CommentConverter {

	@TypeConverter
	fun fromCommentListToJson(commentList: List<CommentDTO>):String{
		return Json.encodeToString(commentList)
	}

	@TypeConverter
	fun fromJsonToCommentList(json:String):List<CommentDTO>{
		return Json.decodeFromString(json)
	}

	@TypeConverter
	fun fromCommentToJson(comment:CommentDTO):String{
		return Json.encodeToString(comment)
	}

	@TypeConverter
	fun fromJsonToComment(json:String):CommentDTO{
		return Json.decodeFromString(json)
	}
}