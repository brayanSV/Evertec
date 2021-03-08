package com.user.brayan.test.data.remote.builder

class Credit(
    val code: String?,
    val type: String?,
    val groupCode: String?,
    val installment: Int?,
    val installments: List<Int>?
) {
    class Builder {
        private var code: String? = null
        private var type: String? = null
        private var groupCode: String? = null
        private var installment: Int? = 0
        private var installments: List<Int>? = null

        fun setCode(code: String): Credit.Builder {
            this.code = code
            return this
        }

        fun setType(type: String): Credit.Builder {
            this.type = type
            return this
        }

        fun setGroupCode(groupCode: String): Credit.Builder {
            this.groupCode = groupCode
            return this
        }

        fun setInstallment(installment: Int): Credit.Builder {
            this.installment = installment
            return this
        }

        fun setInstallment(installments: List<Int>): Credit.Builder {
            this.installments = installments
            return this
        }

        fun build(): Credit {
            return Credit(code, type, groupCode, installment, installments)
        }
    }
}