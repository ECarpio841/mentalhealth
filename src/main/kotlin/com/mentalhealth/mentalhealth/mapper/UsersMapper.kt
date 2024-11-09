package com.mentalhealth.mentalhealth.mapper

import com.mentalhealth.mentalhealth.dto.UsersDto
import com.mentalhealth.mentalhealth.entity.Users


object UsersMapper {
    fun toEntity(usersDto: UsersDto): Users {
        val users = Users()
        users.fullName = usersDto.fullName
        users.email = usersDto.email
        return users
    }
}