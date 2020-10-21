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
    fun `given a FakeContext when fakeCat is accessed multiple times it should return the same value multiple times`() {
        val fakeCat = createDistinctList { subject.fakeCat }

        expectThat(fakeCat).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeColor is accessed multiple times it should return the same value multiple times`() {
        val fakeColor = createDistinctList { subject.fakeColor }

        expectThat(fakeColor).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeBook is accessed multiple times it should return the same value multiple times`() {
        val fakeBook = createDistinctList { subject.fakeBook }

        expectThat(fakeBook).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeAvatar is accessed multiple times it should return the same value multiple times`() {
        val fakeAvatar = createDistinctList { subject.fakeAvatar }

        expectThat(fakeAvatar).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeAviation is accessed multiple times it should return the same value multiple times`() {
        val fakeAviation = createDistinctList { subject.fakeAviation }

        expectThat(fakeAviation).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeBoolean is accessed multiple times it should return the same value multiple times`() {
        val fakeBoolean = createDistinctList { subject.fakeBoolean }

        expectThat(fakeBoolean).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeCompany is accessed multiple times it should return the same value multiple times`() {
        val fakeCompany = createDistinctList { subject.fakeCompany }

        expectThat(fakeCompany).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeCommerce is accessed multiple times it should return the same value multiple times`() {
        val fakeCommerce = createDistinctList { subject.fakeCommerce }

        expectThat(fakeCommerce).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeCrypto is accessed multiple times it should return the same value multiple times`() {
        val fakeCrypto = createDistinctList { subject.fakeCrypto }

        expectThat(fakeCrypto).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeAncient is accessed multiple times it should return the same value multiple times`() {
        val fakeAncient = createDistinctList { subject.fakeAncient }

        expectThat(fakeAncient).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeArtist is accessed multiple times it should return the same value multiple times`() {
        val fakeArtist = createDistinctList { subject.fakeArtist }

        expectThat(fakeArtist).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeDog is accessed multiple times it should return the same value multiple times`() {
        val fakeDog = createDistinctList { subject.fakeDog }

        expectThat(fakeDog).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeBeer is accessed multiple times it should return the same value multiple times`() {
        val fakeBeer = createDistinctList { subject.fakeBeer }

        expectThat(fakeBeer).hasSize(1)
    }

    @Test
    fun `given a FakeContext when fakeJob is accessed multiple times it should return the same value multiple times`() {
        val fakeJob = createDistinctList { subject.fakeJob }

        expectThat(fakeJob).hasSize(1)
    }
}
