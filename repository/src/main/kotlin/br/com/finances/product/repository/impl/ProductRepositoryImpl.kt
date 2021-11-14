package br.com.finances.product.repository.impl

import br.com.finances.product.output.repository.ProductOutputRepository
import br.com.finances.product.output.repository.dto.ProductCreateOutput
import br.com.finances.product.output.repository.dto.ProductOutputDTO
import br.com.finances.product.repository.converter.toEntity
import br.com.finances.product.repository.converter.toOutput
import br.com.finances.product.repository.interfaces.ProductRepo
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val repo: ProductRepo
) : ProductOutputRepository {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun create(output: ProductCreateOutput): ProductOutputDTO =
        try {
            logger.info("ProductRepositoryImpl.create output: $output")

            val entity = output.toEntity()

            repo.save(entity).toOutput()

        } catch (e: Exception) {
            logger.error("ProductRepositoryImpl.create[ERROR] output: $output")
            throw e
        }

    override fun getById(productId: Long): ProductOutputDTO? =
        try {
            logger.info("ProductRepositoryImpl.getById productId: $productId")

            repo.findByIdOrNull(id = productId)?.toOutput()

        } catch (e: Exception) {
            logger.error("ProductRepositoryImpl.getById[ERROR] productId: $productId")
            throw e
        }

    override fun getAll(): List<ProductOutputDTO>? =
        try {
            logger.info("ProductRepositoryImpl.getAll ")

            repo.findAll().map { it.toOutput() }

        } catch (e: Exception) {
            logger.error("ProductRepositoryImpl.getAll[ERROR] ")
            throw e
        }

    override fun deleteById(productId: Long) {
        repo.deleteById(productId)
    }
}