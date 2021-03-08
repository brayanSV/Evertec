package com.user.brayan.test.data.remote.builder

class Token(
    val token: String?,
    val subtoken: String?,
    val franchise: String?,
    val franchiseName: String?,
    val issuerName: String?,
    val lastDigits: String?,
    val validUntil: String?
) {
    class Builder {
        private var token: String? = null
        private var subtoken: String? = null
        private var franchise: String? = null
        private var franchiseName: String? = null
        private var issuerName: String? = null
        private var lastDigits: String? = null
        private var validUntil: String? = null

        fun setToken(token: String): Token.Builder {
            this.token = token
            return this
        }

        fun setSubToken(subtoken: String): Token.Builder {
            this.subtoken = subtoken
            return this
        }

        fun setFranchise(franchise: String): Token.Builder {
            this.franchise = franchise
            return this
        }

        fun setFranchiseName(franchiseName: String): Token.Builder {
            this.franchiseName = franchiseName
            return this
        }

        fun setIssuerName(issuerName: String): Token.Builder {
            this.issuerName = issuerName
            return this
        }

        fun setLastDigits(lastDigits: String): Token.Builder {
            this.lastDigits = lastDigits
            return this
        }

        fun setValidUntil(validUntil: String): Token.Builder {
            this.validUntil = validUntil
            return this
        }

        fun build(): Token {
            return Token(token, subtoken, franchise, franchiseName, issuerName, lastDigits, validUntil)
        }
    }
}