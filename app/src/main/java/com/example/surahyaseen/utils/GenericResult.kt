package com.example.surahyaseen.utils

sealed class GenericResult<T>(val data: T? = null, val message: String? = null) {

    class Loading<T> : GenericResult<T>()
    class Success<T>(data: T?) : GenericResult<T>(data)
    class Error<T>(message: String?) : GenericResult<T>(message = message)
}