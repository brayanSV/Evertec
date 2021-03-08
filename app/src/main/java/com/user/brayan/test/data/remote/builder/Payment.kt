package com.user.brayan.test.data.remote.builder

class Payment(
    val reference: String?,
    val description: String?,
    val amount: Amount?
) {
    class Builder {
        private var reference: String? = null
        private var description: String? = null
        private var amount: Amount? = null
        
        fun setReference(reference: String): Payment.Builder {
            this.reference = reference
            return this
        }

        fun setDescription(description: String): Payment.Builder {
            this.description = description
            return this
        }

        fun setAmount(amount: Amount): Payment.Builder {
            this.amount = amount
            return this
        }

        fun build(): Payment {
            return Payment(reference, description, amount)
        }
    }
}