package com.raywenderlich.home_challenge.erorrhandler

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

open class NetworkErrorHandler(private val uiComponent: UiErrorInterFace) {

    fun handle(e: Throwable){
        when(e){
            is IOException -> {
                uiComponent.onNoInternet()
            }

            is SocketTimeoutException -> {
                uiComponent.onNoInternet()
            }

            is HttpException -> {
                uiComponent.onServerError(message = e.message())
            }
        }
    }

}


interface UiErrorInterFace{

    fun onNoInternet()

    fun onServerError(message: String)


}

fun UiErrorInterFace.handleNetworkError(e: Throwable){
    NetworkErrorHandler(this).handle(e)
}