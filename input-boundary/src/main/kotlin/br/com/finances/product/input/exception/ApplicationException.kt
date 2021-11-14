package br.com.finances.product.input.exception

class ApplicationException(message: String, vararg  val args: Any?): RuntimeException(message)