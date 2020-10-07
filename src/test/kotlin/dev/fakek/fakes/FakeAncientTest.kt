package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeAncientTest {

    private val god by lazy { "God" }
    private val primordial by lazy { "Primordial" }
    private val titan by lazy { "Titan" }
    private val hero by lazy { "Hero" }
    private val fakerAncient: FakerAncient = mockk {
        every { god() } returns god
        every { primordial() } returns primordial
        every { titan() } returns titan
        every { hero() } returns hero
    }

    @Test
    fun `given a FakerAncient when creating a FakeAncient then the correct god should be set`() {
        val subject = FakeAncient(fakerAncient)

        expectThat(subject.god).isEqualTo(god)
    }

    @Test
    fun `given a FakerAncient when creating a FakeAncient then the correct primordial should be set`() {
        val subject = FakeAncient(fakerAncient)

        expectThat(subject.primordial).isEqualTo(primordial)
    }

    @Test
    fun `given a FakerAncient when creating a FakeAncient then the correct titan should be set`() {
        val subject = FakeAncient(fakerAncient)

        expectThat(subject.titan).isEqualTo(titan)
    }

    @Test
    fun `given a FakerAncient when creating a FakeAncient then the correct hero should be set`() {
        val subject = FakeAncient(fakerAncient)

        expectThat(subject.hero).isEqualTo(hero)
    }
}