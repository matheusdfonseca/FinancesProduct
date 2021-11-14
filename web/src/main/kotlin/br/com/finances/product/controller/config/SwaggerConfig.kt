package br.com.finances.product.controller.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.PathProvider
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.paths.RelativePathProvider
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import javax.servlet.ServletContext

@Configuration
@EnableSwagger2
class SwaggerConfig(val servletContext: ServletContext) {

    @Value("\${swagger.base.ref}")
    private val swaggerBaseRef: String? = null

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .pathProvider(getPathProvider())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.btg.pactual.banking.account.controller"))
            .paths(PathSelectors.any())
            .build()
    }

    private fun getPathProvider(): PathProvider {
        class Rpp(servletContext: ServletContext) : RelativePathProvider(servletContext) {
            override fun getApplicationBasePath(): String = swaggerBaseRef.orEmpty()
        }
        return Rpp(servletContext)
    }
}