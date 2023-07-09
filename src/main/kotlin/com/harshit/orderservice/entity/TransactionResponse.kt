package com.harshit.orderservice.entity

data class TransactionResponse(
    val userId: Int,
    val amount : Int,
    val status : TransactionStatus
)

enum class TransactionStatus{
    APPROVED,
    DECLINED
}