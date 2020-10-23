package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeSSNTest {

    private val ssnValid by lazy { "111-11-1111" }
    private val ssnInvalid by lazy { "000-00-0000" }

    private val fakerSSN: FakerSSN = mockk {
        every { valid() } returns ssnValid
        every { invalid() } returns ssnInvalid
        every { ssnValid() } returns ssnValid
    }

    @Test
    fun `given a FakerSSN when creating a FakeSSN then the correct ssnValid should be set`() {
        val subject = FakeSSN(fakerSSN)

        expectThat(subject.valid).isEqualTo(ssnValid)
        expectThat(subject.ssnValid).isEqualTo(ssnValid)
    }

    @Test
    fun `given a FakerSSN when creating a FakeSSN then the correct ssnInvalid should be set`() {
        val subject = FakeSSN(fakerSSN)

        expectThat(subject.invalid).isEqualTo(ssnInvalid)
    }


}
