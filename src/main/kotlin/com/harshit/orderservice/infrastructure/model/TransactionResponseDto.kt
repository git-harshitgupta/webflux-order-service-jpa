package com.harshit.orderservice.infrastructure.model

import java.time.LocalDate

data class TransactionResponseDto(
    val userId : Int,
    val amount : Int,
    val status : TransactionStatus
)

enum class TransactionStatus{
    APPROVED,
    DECLINED
}