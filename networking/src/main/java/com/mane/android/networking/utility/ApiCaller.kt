package com.mane.android.networking.utility

import com.mane.android.common_libs.data.ApiCallResult

class ApiCaller {

    companion object {
        suspend fun <T> callSafely(service: suspend () -> T): ApiCallResult<T> {
            return try {
                ApiCallResult.Success(service.invoke())
            }
            catch (throwable: Throwable) {
                ApiCallResult.Error(errorMsg = throwable.message)
            }
        }
    }
}