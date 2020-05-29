package dev.fakek

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeKKtTest {

    private val fakeContext by lazy { FakeContext() }

    @Test
    fun `given a fakeContext when creating a string then the correct fake string should be returned`() {
        val expected = fakeContext.fakeName.firstName
        val actual = fakek(fakeContext) { fakeName.firstName }

        expectThat(actual).isEqualTo(expected)
    }
}