package com.mane.android.common_libs.data

sealed class ApiCallResult<out T> {
    data class Success<out T>(val value: T) : ApiCallResult<T>()
    data class Error(val errorMsg: String? = null) : ApiCallResult<Nothing>()
}
