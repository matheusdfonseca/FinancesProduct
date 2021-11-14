package br.com.finances.product.usecase.converter

import br.com.finances.product.input.dto.ProductInputResponseDTO
import br.com.finances.product.output.repository.dto.ProductOutputDTO

fun ProductOutputDTO.toInput() =
    ProductInputResponseDTO(
        id = this.id!!,
        name = this.name,
        description = this.description
    )