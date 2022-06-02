package com.copia.baseclasses

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.copia.ui.main.model.Settlement
import com.copia.utils.animateSlideLeft
import com.copia.utils.animateSlideRight
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass


open class BaseActivity<V : BaseViewModel>(private val viewModelClass: KClass<V>) : AppCompatActivity() {

    protected val TAG = "Copia"
    protected lateinit var viewModel: V
    private var loader: BottomSheetDialog? = null
    var extraFragments: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseInit()
    }

    private fun baseInit() {
        viewModel = getViewModel(clazz = viewModelClass)
        viewModel.dataResult.observe(this, dataResultObserver)
    }

    private val dataResultObserver = Observer<ArrayList<Settlement>> { observeResult(it) }

    open fun observeResult(settlements: ArrayList<Settlement>) {}

    protected fun startNewActivity(activity: Class<*>, shouldFinish: Boolean = false) {
        startNewActivity(Intent(this, activity), shouldFinish)
    }

    protected fun startNewActivity(intent: Intent, shouldFinish: Boolean = false) {
        startActivity(intent)
        animateSlideLeft()
        if (shouldFinish) finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        animateSlideRight()
    }
}