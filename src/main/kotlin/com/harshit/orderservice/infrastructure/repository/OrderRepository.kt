package com.harshit.orderservice.infrastructure.repository

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderDto,Int> {
}