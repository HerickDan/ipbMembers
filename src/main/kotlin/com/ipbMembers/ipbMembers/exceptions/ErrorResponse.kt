package com.ipbMembers.ipbMembers.exceptions

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val errorMessage: String,
    val httpStatus: HttpStatus,
)
