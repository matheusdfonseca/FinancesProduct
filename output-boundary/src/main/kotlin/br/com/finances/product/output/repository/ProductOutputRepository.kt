package br.com.finances.product.output.repository

import br.com.finances.product.output.repository.dto.ProductCreateOutput
import br.com.finances.product.output.repository.dto.ProductOutputDTO

interface ProductOutputRepository {
    fun create(output: ProductCreateOutput): ProductOutputDTO
    fun getById(productId: Long): ProductOutputDTO?
    fun getAll(): List<ProductOutputDTO>?
    fun deleteById(productId: Long)
}