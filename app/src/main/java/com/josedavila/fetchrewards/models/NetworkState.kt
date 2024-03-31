package com.josedavila.fetchrewards.models

internal sealed class NetworkState<out T> {
    data object Uninitialized : NetworkState<Nothing>()
    data object Loading : NetworkState<Nothing>()
    data class Success<T>(val data: T) : NetworkState<T>()
    data class Error(val message: String) : NetworkState<Nothing>()
}
