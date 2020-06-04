package dev.fakek.fakes

/**
 * FakeAddress provides a fake address which includes the house number, street name, street type, secondary address,
 * city, state abbreviation, and postal code. This should include all of the information required to test normal
 * addresses for the United States.
 *
 * @param houseNumber is the number of the house, apartment or business such as 123.
 * @param streetName is the name of the street such as "Main".
 * @param streetType is the type of the street such as "St" or "Ave".
 * @param secondaryAddress is the secondary part of an address such as "Apt 456".
 * @param city is the city where the address is located such as "Springfield".
 * @param stateAbbreviation is the abbreviation of the state where the address is located such as "OR".
 * @param postalCode is the postal code where the address is located such as "97478".
 */
data class FakeAddress(
    val houseNumber: Int,
    val streetName: String,
    val streetType: String,
    val secondaryAddress: String,
    val city: String,
    val stateAbbreviation: String,
    val postalCode: String
) {
    constructor(fakerAddress: FakerAddress) : this(
        houseNumber = fakerAddress.buildingNumber().toInt(),
        streetName = fakerAddress.streetName(),
        streetType = fakerAddress.streetSuffix(),
        secondaryAddress = fakerAddress.secondaryAddress(),
        city = fakerAddress.cityName(),
        stateAbbreviation = fakerAddress.stateAbbr(),
        postalCode = fakerAddress.zipCode()
    )
}
