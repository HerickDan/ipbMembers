package com.ipbMembers.ipbMembers.exceptions

import com.ipbMembers.ipbMembers.exceptions.handledExceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler: ResponseEntityExceptionHandler(){
    @ExceptionHandler(NotFoundException::class)
     fun handleGlobalException(
       ex: Exception,
       message:String,
       status: HttpStatus,
    ): ResponseEntity<ErrorResponse>{
         val error = ErrorResponse(
             message,
             status,
             ex
         )
        return ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND)
     }
}