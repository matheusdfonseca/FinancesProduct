package br.com.finances.product.controller.config

import br.com.finances.product.input.exception.ApplicationException
import org.jetbrains.kotlin.com.google.gson.GsonBuilder
import org.springframework.context.MessageSource
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class RestResponseEntityExceptionHandler(
    private val messageSource: MessageSource
) : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ApplicationException::class])
    protected fun handleBusinnesError(
        ex: ApplicationException,
        request: WebRequest
    ): ResponseEntity<Any?>? {
        val apiError = ApiError(
            code = ex.message ?: "server.error",
            message = messageSource.getMessage(
                ex.message ?: "server.error",
                ex.args,
                ex.message ?: "server.error",
                Locale.getDefault()
            )
        )
        return handleExceptionInternal(
            ex, GsonBuilder().create().toJson(apiError),
            HttpHeaders(), HttpStatus.BAD_REQUEST, request
        )
    }

}