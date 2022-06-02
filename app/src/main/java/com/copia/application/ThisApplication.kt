package com.copia.application

import android.app.Application
import android.content.Context
import com.copia.BuildConfig
import com.copia.koin.appModule
import com.copia.koin.networkModule
import com.copia.koin.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ThisApplication : Application() {

    companion object {
        private lateinit var appContext: Context
        fun getContext() = appContext
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        initKoin()
    }


    private fun initKoin() {
        startKoin {
            androidLogger(if (BuildConfig.ENV == "dev") Level.ERROR else Level.NONE)
            androidContext(this@ThisApplication)
            modules(appModule, networkModule, viewModels)
        }
    }
}