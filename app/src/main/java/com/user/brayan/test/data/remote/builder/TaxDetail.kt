package com.user.brayan.test.data.remote.builder

class TaxDetail(
    val kind: String?,
    val amount: Double?,
    val base: Double?,
) {
    class Builder {
        private var kind: String? = null
        private var amount: Double? = null
        private var base: Double? = null

        fun setKind(kind: String): TaxDetail.Builder {
            this.kind = kind
            return this
        }

        fun setAmount(amount: Double): TaxDetail.Builder {
            this.amount = amount
            return this
        }

        fun setBase(base: Double): TaxDetail.Builder {
            this.base = base
            return this
        }
        
        fun build(): TaxDetail {
            return TaxDetail(kind, amount, base)
        }
    }
}