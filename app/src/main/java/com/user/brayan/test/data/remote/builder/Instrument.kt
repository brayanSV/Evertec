package com.user.brayan.test.data.remote.builder

class Instrument(
    val card: Card?,
    val token: Token?,
    val credit: Credit?,
    val otp: String?
) {
    class Builder {
        private var card: Card? = null
        private var token: Token? = null
        private var credit: Credit? = null
        private var otp: String? = null

        fun setCard(card: Card): Instrument.Builder {
            this.card = card
            return this
        }

        fun setToken(token: Token): Instrument.Builder {
            this.token = token
            return this
        }

        fun setCredit(credit: Credit): Instrument.Builder {
            this.credit = credit
            return this
        }

        fun setOtp(otp: String): Instrument.Builder {
            this.otp = otp
            return this
        }

        fun build(): Instrument {
            return Instrument(card, token, credit, otp)
        }
    }
}