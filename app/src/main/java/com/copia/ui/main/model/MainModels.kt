package com.copia.ui.main.model

data class Transaction(
        val transactionRef: String,
        var paidAmount: Int
) {
    override fun toString() = String.format("%s\t\t\t\t\t\t\t\t\t\t\t%d\n", transactionRef, paidAmount)
}

data class Receipt(
        val receiptNo: String,
        var amountToPay: Int
) {
    override fun toString() = String.format("%s\t\t\t\t\t\t\t\t\t\t\t%d\n", receiptNo, amountToPay)
}

data class Settlement(
        val receiptNo: String,
        val mPesaRef: String,
        val allocatedAmount: Int
) {
    override fun toString() = String.format("%s\t\t\t\t\t\t\t\t%s\t\t\t\t\t\t\t%d\n", receiptNo, mPesaRef, allocatedAmount)
}