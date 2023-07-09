package com.harshit.orderservice.infrastructure.integration

import com.harshit.orderservice.infrastructure.model.ProductDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class ProductServiceIntegration(
    @Value("\${product.service.url}")
    private val baseUrl : String

) {
    private val webClient = WebClient.builder()
        .baseUrl(baseUrl)
        .build()

    fun getProductById(id:String): Mono<ProductDto> {
        return webClient
            .get()
            .uri("{id}",id)
            .retrieve()
            .bodyToMono(ProductDto::class.java)
    }
}