package dev.engel.fakek.fakes

/**
 * FakePassword provides a fake password.
 *
 * @param password the instance of the fake password. By default this will be between 8 and 16 characters in length and
 * will include uppercase letters, special characters, and digits.
 */
data class FakePassword(val password: String) {
    internal constructor(
        fakerInternet: FakerInternet,
        length: IntRange = DEFAULT_PASSWORD_MINIMUM..DEFAULT_PASSWORD_MAXIMUM,
        excludeUppercase: Boolean = false,
        excludeSpecial: Boolean = false,
        excludeDigits: Boolean = false
    ) : this (fakerInternet.password(length.first, length.last, !excludeUppercase, !excludeSpecial, !excludeDigits))

    companion object {
        private const val DEFAULT_PASSWORD_MINIMUM = 8
        private const val DEFAULT_PASSWORD_MAXIMUM = 16
    }
}
