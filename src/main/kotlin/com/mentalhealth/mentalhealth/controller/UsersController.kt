package com.mentalhealth.mentalhealth.controller

import com.mentalhealth.mentalhealth.dto.UsersDto
import com.mentalhealth.mentalhealth.entity.Users
import com.mentalhealth.mentalhealth.response.JSendResponse
import com.mentalhealth.mentalhealth.service.UsersService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UsersController {

    @Autowired
    lateinit var usersService: UsersService

    @GetMapping
    fun getUsers(): ResponseEntity<*> {
        return try {
            ResponseEntity.ok(JSendResponse.success(data = usersService.getUsers(), message = "Success", code = 200))
        } catch (e: Exception) {
            ResponseEntity(
                JSendResponse.error(
                    message = "Error al obtener los sistemas",
                    ),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
    @PostMapping
    fun save(@RequestBody @Valid usersDto: UsersDto):ResponseEntity<Any>{
        val user =  usersService.save(usersDto)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(mapOf("status" to "success", "data" to user, "message" to "User created successfully"))
    }
}