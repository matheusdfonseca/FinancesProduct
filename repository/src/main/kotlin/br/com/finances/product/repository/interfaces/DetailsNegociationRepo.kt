package br.com.finances.product.repository.interfaces

import br.com.finances.product.repository.domain.DetailsNegociationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DetailsNegociationRepo: JpaRepository<DetailsNegociationEntity, Long> {
}