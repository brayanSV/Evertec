package com.user.brayan.test.data.remote.builder

class Card(
    val number: String?,
    val expirationMonth: String?,
    val expirationYear: String?,
    val cvv: String?
) {
    class Builder {
        private var number: String? = null
        private var expirationMonth: String? = null
        private var expirationYear: String? = null
        private var cvv: String? = null

        fun setNumber(number: String): Builder {
            this.number = number
            return this
        }

        fun setExpirationMonth(expirationMonth: String): Builder {
            this.expirationMonth = expirationMonth
            return this
        }

        fun setExpirationYear(expirationYear: String): Builder {
            this.expirationYear = expirationYear
            return this
        }

        fun setCvv(cvv: String): Builder {
            this.cvv = cvv
            return this
        }

        fun build(): Card {
            return Card(number, expirationMonth, expirationYear, cvv)
        }
    }
}