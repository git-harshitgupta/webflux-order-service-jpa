package com.harshit.orderservice.entity

data class PurchaseOrderRequest(
    val userId:Int,
    val productId:String
)