package com.mentalhealth.mentalhealth.dto

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

class UsersDto {


    @NotNull
    @NotBlank(message = "Name cannot be blank")
    var fullName: String? = null
    @NotNull
    @NotBlank(message = "Name cannot be blank")
    var email: String? = null

}