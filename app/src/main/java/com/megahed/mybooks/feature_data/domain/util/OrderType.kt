package com.megahed.mybooks.feature_data.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}