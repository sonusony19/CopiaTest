package com.copia.utils

import com.copia.ui.main.model.Receipt
import com.copia.ui.main.model.Transaction

fun getTransactions() = arrayListOf(
        Transaction("MG001", 100),
        Transaction("MG002", 200),
        Transaction("MG003", 300),
        Transaction("MG004", 250)
)

fun getReceipts() = arrayListOf(
        Receipt("R001", 100),
        Receipt("R002", 400),
        Receipt("R003", 350)
)
