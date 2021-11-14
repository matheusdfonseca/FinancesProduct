package br.com.finances.product.repository.interfaces

import br.com.finances.product.repository.domain.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepo: JpaRepository<ProductEntity, Long> {
}