package com.example.estatapi

class RequiredConstants {
    companion object {
        const val CAT01: String = "cat01"
        const val CAT02: String = "cat02"
        private const val CODE_SUFFIX: String = "code"
        private const val NAME_SUFFIX: String = "name"

        const val CAT01_CODE: String = CAT01 + CODE_SUFFIX
        const val CAT01_NAME: String = CAT01 + NAME_SUFFIX
        const val CAT02_CODE: String = CAT02 + CODE_SUFFIX
        const val CAT02_NAME: String = CAT02 + NAME_SUFFIX
    }
}