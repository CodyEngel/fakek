package dev.engel.fakek.fakes

data class FakePassword(val password: String) {
    internal constructor(
        fakerInternet: FakerInternet,
        length: IntRange = 8..16,
        excludeUppercase: Boolean = false,
        excludeSpecial: Boolean = false,
        excludeDigits: Boolean = false
    ) : this (fakerInternet.password(length.first, length.last, !excludeUppercase, !excludeSpecial, !excludeDigits))
}