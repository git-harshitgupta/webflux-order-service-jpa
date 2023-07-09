package com.harshit.orderservice.infrastructure.model

data class UserDto (
    val id : Int ?= null,
    val name : String,
    val balance : Int
)