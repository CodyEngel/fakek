package dev.fakek.fakes

/**
 * FakeArtist provides a fake artist object that includes a single parameter - name.
 *
 * @param name is the name of the artist.
 */
data class FakeArtist(
    val name: String
) {
    constructor(fakerArtist: FakerArtist) : this(
        name = fakerArtist.name()
    )
}
