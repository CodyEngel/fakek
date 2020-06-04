package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeAddressTest {
    private val houseNumber = 123
    private val streetName = "Main"
    private val streetType = "St"
    private val secondaryAddress = "Apt 456"
    private val city = "Springfield"
    private val state = "OR"
    private val zipCode = "97478"
    private val fakerAddress: FakerAddress = mockk {
        every { buildingNumber() } returns houseNumber.toString()
        every { streetName() } returns streetName
        every { streetSuffix() } returns streetType
        every { secondaryAddress() } returns secondaryAddress
        every { cityName() } returns city
        every { stateAbbr() } returns state
        every { zipCode() } returns zipCode
    }

    private val subject = FakeAddress(fakerAddress)

    @Test
    fun `given a FakerAddress when creating a FakeAddress then the correct house number should be set`() {
        expectThat(subject.houseNumber).isEqualTo(houseNumber)
    }

    @Test
    fun `given a FakerAddress when creating a FakeAddress then the correct street name should be set`() {
        expectThat(subject.streetName).isEqualTo(streetName)
    }

    @Test
    fun `given a FakerAddress when creating a FakeAddress then the correct street type should be set`() {
        expectThat(subject.streetType).isEqualTo(streetType)
    }

    @Test
    fun `given a FakerAddress when creating a FakeAddress then the correct secondary address should be set`() {
        expectThat(subject.secondaryAddress).isEqualTo(secondaryAddress)
    }

    @Test
    fun `given a FakerAddress when creating a FakeAddress then the correct city should be set`() {
        expectThat(subject.city).isEqualTo(city)
    }

    @Test
    fun `given a FakerAddress when creating a FakeAddress then the correct state should be set`() {
        expectThat(subject.stateAbbreviation).isEqualTo(state)
    }

    @Test
    fun `given a FakerAddress when creating a FakeAddress then the correct zip code should be set`() {
        expectThat(subject.postalCode).isEqualTo(zipCode)
    }
}