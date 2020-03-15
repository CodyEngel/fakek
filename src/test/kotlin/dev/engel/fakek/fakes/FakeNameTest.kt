package dev.engel.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeNameTest {

    private val firstName by lazy { "First" }
    private val middleName by lazy { "Middle" }
    private val lastName by lazy { "Last" }
    private val fakerName by lazy {
        mockk<FakerName>()
            .also { every { it.nameWithMiddle() } returns "$firstName $middleName $lastName" }
    }

    @Test
    fun `given a FakerName when creating a FakeName then the correct firstName should be set`() {
        val subject = FakeName(fakerName)

        expectThat(subject.firstName).isEqualTo(firstName)
    }

    @Test
    fun `given a FakerName when creating a FakeName then the correct middleName should be set`() {
        val subject = FakeName(fakerName)

        expectThat(subject.middleName).isEqualTo(middleName)
    }

    @Test
    fun `given a FakerName when creating a FakeName then the correct lastName should be set`() {
        val subject = FakeName(fakerName)

        expectThat(subject.lastName).isEqualTo(lastName)
    }
}
