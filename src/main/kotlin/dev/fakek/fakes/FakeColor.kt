package dev.fakek.fakes

/**
 * Fakecolor provides a random color.
 *
 * @param hex the hexadecimal representation of a color.
 * @param hexWithHashSign the hexadecimal representation of a color with a hash symbol(#) before de hexadecimal value.
 */
data class FakeColor(val hex: String, val hexWithHashSign: String) {
    constructor(fakerColor: FakerColor): this(fakerColor.hex(), fakerColor.hex(true))
}
