package dev.fakek.fakes

/**
 * FakeBoolean provides a fake boolean.
 */
data class FakeBoolean(val boolean: Boolean) {
    constructor(fakerBoolean: FakerBoolean) : this(fakerBoolean.bool())
}
