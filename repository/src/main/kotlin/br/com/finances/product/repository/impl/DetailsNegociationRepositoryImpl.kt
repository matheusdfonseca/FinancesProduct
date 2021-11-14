package br.com.finances.product.repository.impl

import br.com.finances.product.output.repository.DetailsNegociationOutputRepository
import br.com.finances.product.repository.interfaces.DetailsNegociationRepo
import org.slf4j.LoggerFactory


class DetailsNegociationRepositoryImpl(
    private val repo: DetailsNegociationRepo
): DetailsNegociationOutputRepository {
    private val logger = LoggerFactory.getLogger(this::class.java)
}