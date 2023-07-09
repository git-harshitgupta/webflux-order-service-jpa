package com.harshit.orderservice.mapper

import com.harshit.orderservice.entity.RequestContext
import com.harshit.orderservice.entity.TransactionStatus
import com.harshit.orderservice.infrastructure.model.OrderDto
import com.harshit.orderservice.infrastructure.model.OrderStatus

object OrderMapper {
    fun toOrderDto(requestContext: RequestContext): OrderDto {
        val transaction : OrderStatus
        if (requestContext.transactionResponse?.status?.equals(TransactionStatus.APPROVED) == true){
            transaction = OrderStatus.COMPLETED
        }else{
            transaction = OrderStatus.FAILED
        }
        return OrderDto(
                productId = requestContext.product?.id.toString(),
                userId = requestContext.purchaseOrderRequest.userId,
                amount = requestContext.product?.price,
                orderStatus = transaction
            )
        }
    }
