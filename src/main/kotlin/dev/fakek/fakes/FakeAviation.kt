package dev.fakek.fakes

/**
 * FakeAviation provides a fake aviation info.
 *
 * @param METAR [weather report](https://en.wikipedia.org/wiki/METAR)
 * @param aircraft aircraft model
 * @param airport airport [ICAO code](https://en.wikipedia.org/wiki/International_Civil_Aviation_Organization)
 */
data class FakeAviation(
    @Suppress("ConstructorParameterNaming")
    val METAR: String,
    val aircraft: String,
    val airport: String
) {
    constructor(fakerAviation: FakerAviation) : this(
        fakerAviation.METAR(),
        fakerAviation.aircraft(),
        fakerAviation.airport()
    )
}
