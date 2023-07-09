package com.harshit.orderservice.infrastructure.integration

import com.harshit.orderservice.infrastructure.model.TransactionRequestDto
import com.harshit.orderservice.infrastructure.model.TransactionResponseDto
import com.harshit.orderservice.infrastructure.model.UserDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class UserServiceIntegration(
    @Value("\${user.service.url}")
    private val baseUrl:String
) {

    private val webClient = WebClient.builder()
        .baseUrl(baseUrl)
        .build()

    fun getUserById(id:String):Mono<UserDto>{
        return webClient
            .get()
            .uri("{id}",id)
            .retrieve()
            .bodyToMono(UserDto::class.java)
    }

    fun makeTransaction(transactionRequestDto: TransactionRequestDto):Mono<TransactionResponseDto>{
        return webClient
            .post()
            .uri("createTransaction")
            .bodyValue(transactionRequestDto)
            .retrieve()
            .bodyToMono(TransactionResponseDto::class.java)
    }
}