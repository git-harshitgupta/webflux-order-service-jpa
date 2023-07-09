package com.harshit.orderservice.entity

data class PurchaseOrderResponse(
    val orderId : Int,
    val userId : Int,
    val productId : String,
    val status: TransactionStatus
)
