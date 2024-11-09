package com.mentalhealth.mentalhealth.repository

import com.mentalhealth.mentalhealth.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: JpaRepository<Users, Long> {

}