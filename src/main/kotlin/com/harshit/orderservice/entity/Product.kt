package com.harshit.orderservice.entity

data class Product(
    var id : String ?= null,
    val description : String ?=null,
    val price : Int ?=0
)