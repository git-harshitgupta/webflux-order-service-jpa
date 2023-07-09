package com.harshit.orderservice.service

import com.harshit.orderservice.entity.PurchaseOrderRequest
import com.harshit.orderservice.entity.PurchaseOrderResponse
import com.harshit.orderservice.entity.RequestContext
import com.harshit.orderservice.entity.TransactionResponse
import com.harshit.orderservice.infrastructure.integration.ProductServiceIntegration
import com.harshit.orderservice.infrastructure.integration.UserServiceIntegration
import com.harshit.orderservice.infrastructure.repository.OrderRepository
import com.harshit.orderservice.mapper.OrderMapper
import com.harshit.orderservice.mapper.ProductMapper
import com.harshit.orderservice.mapper.TransactionMapper
import com.harshit.orderservice.util.EntityUtil
import reactor.core.publisher.Mono

class OrderFulfillmentService (
    private val productServiceIntegration: ProductServiceIntegration,
    private val userServiceIntegration: UserServiceIntegration,
    private val orderRepository: OrderRepository
){

    fun processOrder(purchaseOrderRequest: Mono<PurchaseOrderRequest>) : Mono<PurchaseOrderResponse>{
        return purchaseOrderRequest
            .map {
                RequestContext(purchaseOrderRequest=it)
            }.flatMap {
                getProductDetails(it)
            }.doOnNext {
                EntityUtil::setTransactionDto
            }.flatMap { it?.let {
                makeTransaction(it)
                }
            }.flatMap<PurchaseOrderResponse?> {
                orderRepository.save(OrderMapper.toOrderDto(it))
            }.map {

            }
    }

    fun getProductDetails(requestContext: RequestContext): Mono<RequestContext> {
        return productServiceIntegration.getProductById(requestContext.purchaseOrderRequest.productId)
            .doOnNext {
                requestContext.product = ProductMapper.toProduct(it)
            }.thenReturn(requestContext)
    }

    fun makeTransaction(requestContext: RequestContext) : Mono<RequestContext>? {
        return requestContext.transactionRequest?.let { transactionRequest ->
            userServiceIntegration.makeTransaction(TransactionMapper.toTransactionRequestDto(transactionRequest))
                .doOnNext {
                    requestContext.transactionResponse = TransactionMapper.toTransactionResponse(it)
                }
        }?.thenReturn(requestContext)

    }

}