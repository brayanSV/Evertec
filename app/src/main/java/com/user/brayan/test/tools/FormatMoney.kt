package com.user.brayan.test.tools

import java.text.NumberFormat
import java.util.*

class FormatMoney {
    fun FormatCol(double: Double): String {
        val money = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        money.maximumFractionDigits = 0
        return money.format(double)
    }
}