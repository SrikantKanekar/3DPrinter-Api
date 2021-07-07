package com.example.features.orders.data

import com.example.database.order.OrderDataSource
import com.example.features.order.domain.Order

class OrdersRepository(
    private val orderDataSource: OrderDataSource
) {

    suspend fun getUserOrders(email: String): List<Order> {
        return orderDataSource.getOrdersOfUser(email)
    }
}