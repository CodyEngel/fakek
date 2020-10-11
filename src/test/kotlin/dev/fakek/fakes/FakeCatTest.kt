package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeCatTest {

    private val catName by lazy { "Balou" }
    private val catBreed by lazy { "Norwegian Forest Cat"}
    private val catRegistry by lazy {"Canadian Cat Association"}
    private val fakerCat: FakerCat = mockk {
        every { name() } returns catName
        every { breed() } returns catBreed
        every { registry() } returns catRegistry
    }

    private fun fakeCat() = FakeCat(fakerCat)

    @Test
    fun `given a FakeCat after creating a FakeCat then expect name to return a given string`() {
        val subject = fakeCat()
        expectThat(subject.name) {
            get { isEqualTo(catName) }
        }
    }

    @Test
    fun `given a FakeCat after creating a FakeCat then expect breed to return a given string`() {
        val subject = fakeCat()
        expectThat(subject.breed) {
            get { isEqualTo(catBreed) }
        }
    }

    @Test
    fun `given a FakeCat after creating a FakeCat then expect registry to return a given string`() {
        val subject = fakeCat()
        expectThat(subject.registry) {
            get { isEqualTo(catRegistry) }
        }
    }


}