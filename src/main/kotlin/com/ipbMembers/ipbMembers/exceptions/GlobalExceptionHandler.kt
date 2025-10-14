    package com.ipbMembers.ipbMembers.exceptions

    import com.ipbMembers.ipbMembers.exceptions.handledExceptions.AlreadyCreatedException
    import com.ipbMembers.ipbMembers.exceptions.handledExceptions.NotFoundException
    import org.springframework.http.HttpStatus
    import org.springframework.http.ResponseEntity
    import org.springframework.web.bind.annotation.ControllerAdvice
    import org.springframework.web.bind.annotation.ExceptionHandler
    import org.springframework.web.bind.annotation.RestController
    import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


    @ControllerAdvice
    @RestController
    class GlobalExceptionHandler: ResponseEntityExceptionHandler(){
        @ExceptionHandler(NotFoundException::class)
         fun handleGlobalException(
           ex: NotFoundException,
        ): ResponseEntity<ErrorResponse>{
             val error = ErrorResponse(
                 ex.errorMessage.message,
                 HttpStatus.NOT_FOUND,
             )
            return ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND)
         }

        @ExceptionHandler(AlreadyCreatedException::class)
        fun handleAlreadyCreatedEntity(
            ex: AlreadyCreatedException
        ): ResponseEntity<ErrorResponse>{
            val error = ErrorResponse(
                ex.errorMessage.message,
                HttpStatus.CONFLICT
            )
            return ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT )
        }
    }