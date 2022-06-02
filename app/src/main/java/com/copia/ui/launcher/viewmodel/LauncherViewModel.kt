package com.copia.ui.launcher.viewmodel

import com.copia.baseclasses.BaseViewModel
import com.copia.ui.main.model.Receipt
import com.copia.ui.main.model.Settlement
import com.copia.ui.main.model.Transaction

class LauncherViewModel : BaseViewModel() {

    fun getSettlements(transactions: ArrayList<Transaction>, receipts: ArrayList<Receipt>) {
        val settlements = ArrayList<Settlement>()
        var i = 0
        var j = 0

        while (i < receipts.size) {
            while (i < receipts.size && receipts[i].amountToPay > 0 && j < transactions.size && transactions[j].paidAmount > 0) {
                val receipt = receipts[i]
                val transaction = transactions[j]
                if (receipt.amountToPay == transaction.paidAmount) {
                    val settlement = Settlement(receipt.receiptNo, transaction.transactionRef, receipt.amountToPay)
                    settlements.add(settlement)
                    receipts[i].amountToPay = 0
                    transactions[j].paidAmount = 0
                    i++
                    j++
                } else if (receipt.amountToPay > transaction.paidAmount) {
                    val settlement = Settlement(receipt.receiptNo, transaction.transactionRef, transaction.paidAmount)
                    settlements.add(settlement)
                    receipts[i].amountToPay -= transaction.paidAmount
                    transactions[j].paidAmount = 0
                    j++
                } else {
                    settlements.add(Settlement(receipt.receiptNo, transaction.transactionRef, receipt.amountToPay))
                    transactions[j].paidAmount -= receipt.amountToPay
                    receipts[i].amountToPay = 0
                    i++
                }
            }
        }
        dataResult.value = settlements
    }

}