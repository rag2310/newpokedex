package com.rago.data.utils

data class GenericResponse<T>(
    val error: String? = null,
    val data: T? = null
)