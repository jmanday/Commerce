package com.manday.management.domain

import java.io.Serializable

data class Employee (
    var name: String,
    var surname: String,
    var email: String,
    var typeEmployee: Int
): Serializable