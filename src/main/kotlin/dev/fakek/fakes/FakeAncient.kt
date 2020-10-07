package dev.fakek.fakes

/**
 * FakeAncient provides a fake ancient which includes a god, primordial, titan, and hero.
 *
 * @param god is a god name.
 * @param primordial is a primordial name.
 * @param titan is a titan name.
 * @param hero is a hero name.
 */
data class FakeAncient(
    val god: String,
    val primordial: String,
    val titan: String,
    val hero: String
) {
    constructor(fakerAncient: FakerAncient) : this(
        god = fakerAncient.god(),
        primordial = fakerAncient.primordial(),
        titan = fakerAncient.titan(),
        hero = fakerAncient.hero()
    )
}
