package br.com.finances.product.usecase

import br.com.finances.product.input.ProductFeature
import br.com.finances.product.input.dto.ProductCreateInputDTO
import br.com.finances.product.input.dto.ProductInputResponseDTO
import br.com.finances.product.output.repository.ProductOutputRepository
import br.com.finances.product.output.repository.dto.ProductCreateOutput
import br.com.finances.product.usecase.converter.toInput
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ProductFeatureImpl(
    private val productRepository: ProductOutputRepository
) : ProductFeature {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun create(input: ProductCreateInputDTO): ProductInputResponseDTO? {
        logger.info("ProductFeatureImpl.save input: $input")

        val output = ProductCreateOutput(
            name = input.name,
            description = input.description
        )

        return productRepository.create(output).toInput()
    }

    override fun getById(productId: Long): ProductInputResponseDTO? =
        try {
            productRepository.getById(productId)?.toInput()
        } catch (e: Exception) {
            throw e
        }

    override fun getAll(): List<ProductInputResponseDTO>? =
        try {
            productRepository.getAll()?.map { it.toInput() }
        } catch (e: Exception) {
            throw e
        }

    override fun deleteById(productId: Long) {
        try {
            productRepository.deleteById(productId)
        } catch (e: Exception) {
            throw e
        }
    }
}