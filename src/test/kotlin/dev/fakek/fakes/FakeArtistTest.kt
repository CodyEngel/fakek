package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FakeArtistTest {

    private val name = "John Lennon"

    private val fakerArtist: FakerArtist = mockk {
        every { name() } returns name
    }

    @Test
    fun `given a FakerArtist when creating a FakeArtist then expect names to be equal`() {
        val result = FakeArtist(name)
        expectThat(result.name) {
            get { isEqualTo(name) }
        }
    }

}
