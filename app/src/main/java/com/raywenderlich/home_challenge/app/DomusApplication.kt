package com.raywenderlich.home_challenge.app

import android.app.Application
import android.content.Context

class DomusApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }


    companion object{

        var context: Context? = null

    }


}