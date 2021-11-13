package br.com.finances.product.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.nio.charset.StandardCharsets

//@Configuration
class RestTemplateConfig {

    @Bean
    fun createRestTemplate(): RestTemplate {
        return RestTemplate(HttpComponentsClientHttpRequestFactory()).also {
            it.messageConverters.add(0, StringHttpMessageConverter(StandardCharsets.UTF_8))
        }
    }
}