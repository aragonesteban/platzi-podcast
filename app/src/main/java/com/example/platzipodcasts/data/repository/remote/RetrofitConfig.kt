package com.example.platzipodcasts.data.repository.remote

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
