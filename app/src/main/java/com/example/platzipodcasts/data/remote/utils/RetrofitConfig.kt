package com.example.platzipodcasts.data.remote.utils

import retrofit2.Response
import java.io.IOException

inline fun <Api : Any, Data : Any> Response<Api>.handleRequest(mapper: (Api) -> Data): NetworkResult<Data> {
    return try {
        return if (isSuccessful) {
            body()?.let {
                NetworkResult.Success(mapper.invoke(it))
            } ?: NetworkResult.Error("Response body is null", code())
        } else {
            NetworkResult.Error(errorBody()?.string() ?: message(), code())
        }
    } catch (exception: IOException) {
        NetworkResult.Error(exception.toString())
    }
}

sealed interface NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>
    data class Error(val message: String? = String(), val code: Int? = null) :
        NetworkResult<Nothing>
}

inline fun <T : Any> NetworkResult<T>.handleNetworkResult(onSuccess: (T) -> Unit) {
    when (this) {
        is NetworkResult.Success -> onSuccess(data)
        is NetworkResult.Error -> throw RuntimeException("There was an error $message $code")
    }
}
