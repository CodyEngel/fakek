package dev.fakek.fakes

/**
 * Fake Disease with single param - disease name.
 * @param diseaseName: String.
 */
data class FakeDisease(
    val diseaseName: String
) {
    constructor(fakerDisease: FakerDisease) : this(
        fakerDisease.diseaseName()
    )
}
