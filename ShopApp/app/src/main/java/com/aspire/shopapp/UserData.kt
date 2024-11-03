package com.aspire.shopapp

data class UserData(
    val id: Int,
    val username: String,
    val password: String,
    val name: Name,
    val email: String,
    val phone: String,
    val address: Address,
    val __v: Int,

    )