package com.harshit.orderservice.mapper

import com.harshit.orderservice.entity.Product
import com.harshit.orderservice.infrastructure.model.ProductDto

object ProductMapper {
    fun toProduct(productDto: ProductDto):Product{
        return Product(
            id = productDto.id,
            description = productDto.description,
            price = productDto.price
        )
    }
}