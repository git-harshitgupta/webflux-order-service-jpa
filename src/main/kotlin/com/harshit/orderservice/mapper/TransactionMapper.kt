package com.harshit.orderservice.mapper

import com.harshit.orderservice.entity.TransactionRequest
import com.harshit.orderservice.entity.TransactionResponse
import com.harshit.orderservice.entity.TransactionStatus
import com.harshit.orderservice.infrastructure.model.TransactionRequestDto
import com.harshit.orderservice.infrastructure.model.TransactionResponseDto

object TransactionMapper {

    fun toTransactionRequestDto(transactionRequest: TransactionRequest):TransactionRequestDto{
        return TransactionRequestDto(
            userId = transactionRequest.userId,
            amount = transactionRequest.amount
        )
    }

    fun toTransactionResponse(transactionResponseDto: TransactionResponseDto):TransactionResponse{
        return TransactionResponse(
            userId = transactionResponseDto.userId,
            amount =transactionResponseDto.amount,
            status = TransactionStatus.valueOf(transactionResponseDto.status.toString())
        )
    }
}