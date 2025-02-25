package com.jgeun.assistedinjection

/**
 *
 * @author   JGeun
 * @created  2025/02/25
 */
interface UserService

class UserServiceImpl : UserService {
    fun getUser(userNo: Long): User {
        return User()
    }
}