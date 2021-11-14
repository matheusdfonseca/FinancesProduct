package br.com.finances.product.controller.v1.request

import br.com.finances.product.input.dto.ProductCreateInputDTO
import com.sun.istack.NotNull

data class ProductCreateRequest(
    @get:NotNull
    val name: String?,

    val description: String?,
) {
    fun toCreateInput() =
        ProductCreateInputDTO(
            name = this.name,
            description = this.description
        )
}