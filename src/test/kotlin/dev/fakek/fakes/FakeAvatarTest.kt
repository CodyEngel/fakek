package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeAvatarTest {

    private val fakeImage = "https://example.com/neat-image.png"

    private val fakerAvatar: FakerAvatar = mockk {
        every { image() } returns fakeImage
    }

    private val subject = FakeAvatar(fakerAvatar)

    @Test
    fun `given a FakerAvatar when creating a FakeAvatar then the correct image should be set`() {
        expectThat(subject.image).isEqualTo(fakeImage)
    }
}
