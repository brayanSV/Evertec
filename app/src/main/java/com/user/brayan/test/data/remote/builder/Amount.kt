package com.user.brayan.test.data.remote.builder

class Amount(
    val currency: String?,
    val total: Double?,
    val taxes: List<TaxDetail>?,
    val details: List<AmountDetail>?
) {
    class Builder {
        private var currency: String? = null
        private var total: Double? = null
        private var taxes: List<TaxDetail>? = null
        private var details: List<AmountDetail>? = null

        fun setCurrency(currency: String): Amount.Builder {
            this.currency = currency
            return this
        }

        fun setTotal(total: Double): Amount.Builder {
            this.total = total
            return this
        }

        fun setTaxes(taxes: List<TaxDetail>): Amount.Builder {
            this.taxes = taxes
            return this
        }

        fun setDetails(details: List<AmountDetail>): Amount.Builder {
            this.details = details
            return this
        }

        fun build(): Amount {
            return Amount(currency, total, taxes, details)
        }
    }
}