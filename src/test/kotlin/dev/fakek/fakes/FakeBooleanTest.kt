package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeBooleanTest {

    private val trueBoolean by lazy { true }
    private val fakerBoolean: FakerBoolean = mockk {
        every { bool() } returns trueBoolean
    }

    @Test
    fun `given a FakerBoolean when creating a FakeBoolean with param true then the correct boolean should be set`() {
        val subject = FakeBoolean(fakerBoolean)

        expectThat(subject.boolean).isEqualTo(trueBoolean)
    }

}
