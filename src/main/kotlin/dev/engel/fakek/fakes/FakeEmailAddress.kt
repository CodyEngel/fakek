package dev.engel.fakek.fakes

data class FakeEmail(val email: String) {
    internal constructor(fakeName: FakeName) : this("${fakeName.firstName}.${fakeName.lastName}@example.com".toLowerCase())
}