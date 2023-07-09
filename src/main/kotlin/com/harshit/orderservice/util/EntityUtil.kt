package com.harshit.orderservice.util

import com.harshit.orderservice.entity.RequestContext
import com.harshit.orderservice.entity.TransactionRequest
import reactor.core.publisher.Mono

object EntityUtil {
    fun setTransactionDto(requestContext: RequestContext): Mono<Void> {
        val transactionRequest = requestContext.product?.price?.let {
            TransactionRequest(
                userId = requestContext.purchaseOrderRequest.userId,
                amount = it
            )
        }
        requestContext.transactionRequest = transactionRequest
    }
}