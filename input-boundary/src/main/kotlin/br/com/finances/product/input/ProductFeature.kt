package br.com.finances.product.input

import br.com.finances.product.input.dto.ProductCreateInputDTO
import br.com.finances.product.input.dto.ProductInputResponseDTO

interface ProductFeature {
    fun create(input: ProductCreateInputDTO): ProductInputResponseDTO?
    fun getById(productId: Long): ProductInputResponseDTO?
    fun getAll(): List<ProductInputResponseDTO>?
    fun deleteById(productId: Long)
}