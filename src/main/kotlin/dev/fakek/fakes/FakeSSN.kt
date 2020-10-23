package dev.fakek.fakes

/**
 * FakeSSN provides a fake valid Social Security Number.
 *
 * @param valid is a valid Social Security Number.
 * @param invalid is an invalid Social Security Number.
 * @param ssnValid is a valid EnIdNumber Social Security Number.
 */
data class FakeSSN(
    val valid: String,
    val invalid: String,
    val ssnValid: String
) {
    constructor(
        fakerSSN: FakerSSN
    ) : this(
        valid = fakerSSN.valid(),
        invalid = fakerSSN.invalid(),
        ssnValid = fakerSSN.ssnValid()
    )
}
