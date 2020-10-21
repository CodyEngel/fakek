package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeAviationTest {

    private val METAR by lazy { "KTVL 021553Z 02012KT 10SM SKC 15/05 A3000" }
    private val aircraft by lazy { "An-2" }
    private val airport by lazy { "AGAF." }

    private val fakerAviation: FakerAviation = mockk {
        every { METAR() } returns METAR
        every { aircraft() } returns aircraft
        every { airport() } returns airport
    }

    private fun fakeAviation() = FakeAviation(fakerAviation)

    @Test
    fun `given a FakerAviation when creating a FakeAviation then the correct attributes should be set`() {
        val subject = fakeAviation()

        expectThat(subject) {
            get { METAR } isEqualTo(METAR)
            get { aircraft } isEqualTo(aircraft)
            get { airport } isEqualTo(airport)
        }
    }
}
