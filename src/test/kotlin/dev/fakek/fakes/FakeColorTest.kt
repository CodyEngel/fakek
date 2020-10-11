package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeColorTest {

    private val hexColor by lazy { "FF2D00" }
    private val hexColorWithHashSymbol by lazy { "#$hexColor" }
    private val fakerColor: FakerColor = mockk {
        every { hex() } returns hexColor
        every { hex(true) } returns hexColorWithHashSymbol
    }

    private fun fakeColor() = FakeColor(fakerColor)

    @Test
    fun `given a FakerColor when creating a FakeColor then the correct hex color should be set`() {
        val subject = fakeColor()

        expectThat(subject.hex).isEqualTo(hexColor)
    }

    @Test
    fun `given a FakerColor when creating a FakeColor then the correct hex color with hash symbol should be set`() {
        val subject = fakeColor()

        expectThat(subject.hexWithHashSign).isEqualTo(hexColorWithHashSymbol)
    }
}
