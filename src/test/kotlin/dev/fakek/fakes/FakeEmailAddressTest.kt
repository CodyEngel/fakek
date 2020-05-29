package dev.fakek.fakes

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.endsWith
import strikt.assertions.startsWith

internal class FakeEmailAddressTest {

    private val fakeName by lazy {
        FakeName(
            firstName = "First",
            middleName = "",
            lastName = "Last"
        )
    }

    @Test
    fun `given a FakeName when creating a FakeEmailAddress then the correct emailAddress should be set`() {
        val subject = FakeEmailAddress(fakeName)

        expectThat(subject.emailAddress) {
            startsWith("${fakeName.firstName}.${fakeName.lastName}".toLowerCase())
            endsWith("@example.com")
        }
    }
}