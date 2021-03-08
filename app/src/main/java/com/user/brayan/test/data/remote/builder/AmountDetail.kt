package com.user.brayan.test.data.remote.builder

class AmountDetail(val kind: String?, val amount: Double?) {
    class Builder {
        private var kind: String? = null
        private var amount: Double? = null
        
        fun setNumber(kind: String): AmountDetail.Builder {
            this.kind = kind
            return this
        }

        fun setExpirationMonth(amount: Double): AmountDetail.Builder {
            this.amount = amount
            return this
        }

        fun build(): AmountDetail {
            return AmountDetail(kind, amount)
        }
    }
}