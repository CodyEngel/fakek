package fakes

data class FakeName(val firstName: String, val middleName: String, val lastName: String) {
    internal constructor(fakerName: FakerName) : this(fakerName.nameWithMiddle().split(" "))
    internal constructor(nameWithMiddle: List<String>) : this(firstName = nameWithMiddle[0], middleName = nameWithMiddle[1], lastName = nameWithMiddle[2])
}