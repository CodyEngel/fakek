package dev.fakek

import com.github.javafaker.Faker
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.hasSize

internal class FakeContextTest {

    private val subject by lazy { FakeContext(Faker.instance()) }

    @Test
    fun `given a FakeK when fakeName is accessed multiple times then it should return the same value multiple times`() {
        val fakeNames = (0..10).map { subject.fakeName }.distinct()

        expectThat(fakeNames).hasSize(1)
    }

    @Test
    fun `given a FakeK when fakeEmailAddress is accessed multiple times it should return the same value multiple times`() {
        val fakeEmailAddresses = (0..10).map { subject.fakeEmailAddress }.distinct()

        expectThat(fakeEmailAddresses).hasSize(1)
    }

    @Test
    fun `given a FakeK when fakePassword is accessed multiple times it should return the same value multiple times`() {
        val fakePasswords = (0..10).map { subject.fakePassword }.distinct()

        expectThat(fakePasswords).hasSize(1)
    }
}