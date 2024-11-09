package com.mentalhealth.mentalhealth.service

import com.mentalhealth.mentalhealth.dto.UsersDto
import com.mentalhealth.mentalhealth.entity.Users
import com.mentalhealth.mentalhealth.mapper.UsersMapper
import com.mentalhealth.mentalhealth.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UsersService {

    @Autowired
    lateinit var usersRepository: UsersRepository

    fun getUsers(): List<Users> {
        return usersRepository.findAll()
    }

    fun save(usersDto: UsersDto): Users {
        val users = UsersMapper.toEntity(usersDto)
        return usersRepository.save(users)
    }
}