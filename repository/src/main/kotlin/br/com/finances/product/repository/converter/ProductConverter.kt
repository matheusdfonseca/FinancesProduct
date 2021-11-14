package br.com.finances.product.repository.converter

import br.com.finances.product.output.repository.dto.ProductCreateOutput
import br.com.finances.product.output.repository.dto.ProductOutputDTO
import br.com.finances.product.repository.domain.ProductEntity

fun ProductCreateOutput.toEntity() =
    ProductEntity(
        name = this.name,
        description = this.description
    )

fun ProductEntity.toOutput() =
    ProductOutputDTO(
        id =  this.id,
        name = this.name,
        description = this.description
    )
