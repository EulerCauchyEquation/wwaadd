package com.test.wadiz

/**
 * Created on 2022-09-01
 */
sealed class Result<out T> {
    // Success sub-class
    data class Success<T>(val data: T) : Result<T>()

    // Error sub-class
    data class Error(val error: Int) : Result<Nothing>()

    // Loading sub-class
    class Loading : Result<Nothing>()
}