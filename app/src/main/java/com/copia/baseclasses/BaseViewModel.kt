package com.copia.baseclasses

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.copia.ui.main.model.Settlement

open class BaseViewModel : ViewModel() {
    internal var dataResult = MutableLiveData<ArrayList<Settlement>>()
}