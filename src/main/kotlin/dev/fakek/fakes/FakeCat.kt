package dev.fakek.fakes

/**
 * FakeCat provides a Cat with a random name, a breed and a registry.
 *
 * @param name the name of the cat
 * @param breed the breed of the cat
 * @param registry the cat where it is registered
 */
data class FakeCat(val name: String, val breed: String, val registry: String) {
    constructor(fakeCat: FakerCat): this(fakeCat.name(), fakeCat.breed(), fakeCat.registry())
}
