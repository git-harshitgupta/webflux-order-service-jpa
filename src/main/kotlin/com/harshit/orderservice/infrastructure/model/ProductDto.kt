package com.harshit.orderservice.infrastructure.model

data class ProductDto(
    var id : String ?= null,
    val description : String ?=null,
    val price : Int ?=0
)