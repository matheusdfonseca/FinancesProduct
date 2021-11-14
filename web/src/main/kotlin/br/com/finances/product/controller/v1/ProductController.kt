package br.com.finances.product.controller.v1

import br.com.finances.product.controller.config.getURILocation
import br.com.finances.product.controller.v1.request.ProductCreateRequest
import br.com.finances.product.input.ProductFeature
import br.com.finances.product.input.dto.ProductInputResponseDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@Api(tags = ["Product"], description = "Operações relacionadas aos produtos")
@RequestMapping(value = ["v1/product"], produces = [MediaType.APPLICATION_JSON_VALUE])
class ProductController(
    private val productFeature: ProductFeature
) {

    @PostMapping
    @ApiOperation(
        value = "Create a new product",
        response = ProductInputResponseDTO::class
    )
    fun createNewProduct(
        @RequestBody @Valid request: ProductCreateRequest
    ): ResponseEntity<ProductInputResponseDTO> {

        val created = productFeature.create(request.toCreateInput())

        return ResponseEntity.created(
            getURILocation(
                path = "/{productId}",
                args = mapOf("productId" to created!!.id)
            )
        ).body(created)
    }

    @GetMapping
    @ApiOperation(
        value = "Find all products",
        response = ProductInputResponseDTO::class
    )
    fun getAllProducts(): ResponseEntity<List<ProductInputResponseDTO>>{

        val result = productFeature.getAll()

        return result?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/{productId}")
    @ApiOperation(
        value = "Find product by ID",
        response = ProductInputResponseDTO::class
    )
    fun getProductById(
        @PathVariable productId: Long
    ): ResponseEntity<ProductInputResponseDTO>{

        val result = productFeature.getById(productId)

        return result?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{productId}")
    @ApiOperation(
        value = "Delete product by ID",
        response = ProductInputResponseDTO::class
    )
    fun deleteById(
        @PathVariable productId: Long
    ): ResponseEntity<Any>{

        productFeature.deleteById(productId)

        return ResponseEntity.noContent().build()
    }
}