package com.harshit.orderservice.entity


data class RequestContext(
    var purchaseOrderRequest: PurchaseOrderRequest,
    var product: Product ?= null,
    var transactionRequest: TransactionRequest ?= null,
    var transactionResponse: TransactionResponse ?= null
)
