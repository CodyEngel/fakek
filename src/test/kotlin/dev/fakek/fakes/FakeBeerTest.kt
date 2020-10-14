package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeBeerTest {

    private val name = "Adam Sams"
    private val style = "Fake Lager"
    private val hop = "Fake Cashmere"
    private val malt = "Fake Caramel"
    private val yeast = "Fake 2278 - Czech Pils"
    private val fakerBeer: FakerBeer = mockk {
        every { name() } returns name
        every { style() } returns style
        every { hop() } returns hop
        every { malt() } returns malt
        every { yeast() } returns yeast
    }

    @Test
    fun `when creating a FakeBeer from a FakerBeer, the correct name should be set`() {
        val subject = FakeBeer(fakerBeer)

        expectThat(subject.name).isEqualTo(name)
    }

    @Test
    fun `when creating a FakeBeer from a FakerBeer, the correct style should be set`() {
        val subject = FakeBeer(fakerBeer)

        expectThat(subject.style).isEqualTo(style)
    }

    @Test
    fun `when creating a FakeBeer from a FakerBeer, the correct hop should be set`() {
        val subject = FakeBeer(fakerBeer)

        expectThat(subject.hop).isEqualTo(hop)
    }

    @Test
    fun `when creating a FakeBeer from a FakerBeer, the correct malt should be set`() {
        val subject = FakeBeer(fakerBeer)

        expectThat(subject.malt).isEqualTo(malt)
    }

    @Test
    fun `when creating a FakeBeer from a FakerBeer, the correct yeast should be set`() {
        val subject = FakeBeer(fakerBeer)

        expectThat(subject.yeast).isEqualTo(yeast)
    }
}
