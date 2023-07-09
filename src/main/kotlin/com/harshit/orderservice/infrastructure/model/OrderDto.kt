package com.harshit.orderservice.infrastructure.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class OrderDto(

    @Id
    @GeneratedValue
    val id:Int ?= null,
    val productId:String,
    val userId:Int,
    val amount: Int?,
    val orderStatus: OrderStatus

)


enum class OrderStatus {
    COMPLETED,
    FAILED
}


