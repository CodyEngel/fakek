package dev.fakek.fakes

/**
 * FakeBook provides a fake beer, with a name, a style, a type of hops, a type of malt, and a type
 * of yeast. Refreshing!
 *
 * @param name is the name of the fake beer
 * @param style is the style of the fake beer
 * @param hop is the type of hop used in the fake beer
 * @param malt is the type of malt used in the fake beer
 * @param yeast is the type of yeast used in the fake beer
 */
data class FakeBeer(
    val name: String,
    val style: String,
    val hop: String,
    val malt: String,
    val yeast: String
) {
    constructor(fakerBeer: FakerBeer) : this(
        name = fakerBeer.name(),
        style = fakerBeer.style(),
        hop = fakerBeer.hop(),
        malt = fakerBeer.malt(),
        yeast = fakerBeer.yeast()
    )
}
