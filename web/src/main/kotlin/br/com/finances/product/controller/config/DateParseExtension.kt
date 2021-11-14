package br.com.finances.product.controller.config

import br.com.finances.product.input.exception.ApplicationException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeParseException

fun String.parseLocalDate(fieldName: String): LocalDate =
    try {
        LocalDate.parse(this)
    } catch (e: DateTimeParseException) {
        throw ApplicationException("date.parser.error", this, fieldName)
    }

fun String.parseLocalDateTime(fieldName: String): LocalDateTime =
    try {
        LocalDateTime.parse(this)
    } catch (e: DateTimeParseException) {
        throw ApplicationException("date.parser.error", this, fieldName)
    }