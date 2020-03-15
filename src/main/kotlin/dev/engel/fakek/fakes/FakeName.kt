package dev.engel.fakek.fakes

/**
 * FakeName provides a fake full name which includes a first, middle, and last name.
 *
 * @param firstName is a first name.
 * @param middleName is a middle name.
 * @param lastName is a last name.
 */
data class FakeName(val firstName: String, val middleName: String, val lastName: String) {
    internal constructor(fakerName: FakerName) : this(fakerName.nameWithMiddle().split(" "))
    internal constructor(
        nameWithMiddle: List<String>
    ) : this(firstName = nameWithMiddle[0], middleName = nameWithMiddle[1], lastName = nameWithMiddle[2])
}
