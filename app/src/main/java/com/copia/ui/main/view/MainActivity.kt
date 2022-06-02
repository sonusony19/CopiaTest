package com.copia.ui.main.view

import android.os.Bundle
import android.util.Log
import com.copia.baseclasses.BaseActivity
import com.copia.databinding.ActivityMainBinding
import com.copia.ui.launcher.viewmodel.LauncherViewModel
import com.copia.ui.main.model.Settlement
import com.copia.utils.getReceipts
import com.copia.utils.getTransactions
import com.google.gson.Gson

class MainActivity : BaseActivity<LauncherViewModel>(LauncherViewModel::class) {
    private lateinit var binding: ActivityMainBinding

    private val transactions = getTransactions()
    private val receipts = getReceipts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        setExampleInUI()
        getSettlements()
    }

    private fun setExampleInUI() {
        var transactionsText = String.format("%s\t%s\n\n", "Transaction Ref", "Amount Paid")
        transactions.forEach { transactionsText += it.toString() }
        binding.transactions.text = transactionsText
        var receiptText = String.format("%s\t\t%s\n\n", "Receipt No.", "Amount to pay")
        receipts.forEach { receiptText += it.toString() }
        binding.receipts.text = receiptText
    }

    private fun getSettlements() {
        viewModel.getSettlements(transactions, receipts)
    }

    override fun observeResult(settlements: ArrayList<Settlement>) {
        var settlementText = String.format("%s\t\t%s\t\t%s\n\n", "Receipt No.", "Mpesa Ref", "Amount")
        settlements.forEach {
            settlementText += it.toString()
            Log.d(TAG, "Settlement: ${Gson().toJson(it)}")
        }
        binding.settlements.text = settlementText
    }
}