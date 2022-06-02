package com.copia.ui.launcher.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.copia.R
import com.copia.baseclasses.BaseActivity
import com.copia.ui.launcher.viewmodel.LauncherViewModel
import com.copia.ui.main.view.MainActivity

class LauncherActivity : BaseActivity<LauncherViewModel>(LauncherViewModel::class) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        Handler(Looper.getMainLooper()).postDelayed({
            startNewActivity(MainActivity::class.java, true)
        }, 500)
    }
}