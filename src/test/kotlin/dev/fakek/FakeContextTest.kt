package dev.fakek

import com.github.javafaker.Faker
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.hasSize

internal class FakeContextTest {

    private val subject by lazy { FakeContext(Faker.instance()) }

    private fun <T> createDistinctList(block: () -> T): List<T> = (0..10).map { block() }.distinct()

    @Test
    fun `given a FakeContext when fakeName is accessed multiple times then it should return the same value multiple times`() {
        val fakeNames = createDistinctList { subject.fakeName }

        expectThat(fakeNames).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeEmailAddress is accessed multiple times it should return the same value multiple times`() {
        val fakeEmailAddresses = createDistinctList { subject.fakeEmailAddress }

        expectThat(fakeEmailAddresses).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakePassword is accessed multiple times it should return the same value multiple times`() {
        val fakePasswords = createDistinctList { subject.fakePassword }

        expectThat(fakePasswords).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeCreditCard is accessed multiple times it should return the same value multiple times`() {
        val fakeCreditCards = createDistinctList { subject.fakeCreditCard }

        expectThat(fakeCreditCards).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeUrl is accessed multiple times it should return the same value multiple times`() {
        val fakeUrls = createDistinctList { subject.fakeUrl }

        expectThat(fakeUrls).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeAddress is accessed multiple times it should return the same value multiple times`() {
        val fakeAddresses = createDistinctList { subject.fakeAddress }

        expectThat(fakeAddresses).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeColor is accessed multiple times it should return the same value multiple times`() {
        val fakeColor = createDistinctList { subject.fakeColor }

        expectThat(fakeColor).hasSize(1)
    }
}
