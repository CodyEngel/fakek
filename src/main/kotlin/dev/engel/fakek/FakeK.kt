package dev.engel.fakek

import com.github.javafaker.Faker
import dev.engel.fakek.fakes.FakeEmailAddress
import dev.engel.fakek.fakes.FakeName
import dev.engel.fakek.fakes.FakePassword

/**
 * The top level function for interacting with FakeK. This provides an instance of [FakeK] scoped to this function. This
 * allows for all interactions with [FakeK] to persist during the usage of [fakek].
 *
 * @param fakeKScope provides a scope on a new [FakeK] instance.
 * @sample FakeKUsageExample
 */
fun <T> fakek(fakeKScope: FakeK.() -> T): T {
    val fake = FakeK()
    return fake.fakeKScope()
}

/**
 * FakeK acts as a Context object for the library. It provides an easy way to access all of the fakes within the library
 * along with caching certain values to allow for proper scoping with the [fakek] function.
 *
 * @param faker is an instance of [Faker] which will be used for generating the various fakes. This will default to a
 * new instance of [Faker].
 */
class FakeK(private val faker: Faker = Faker.instance()) {
    private val fakerName by lazy { faker.name() }
    private val fakerInternet by lazy { faker.internet() }

    /**
     * Provides a [fakeEmailAddress] making use of [fakeName] to help generate parts of the email address.
     */
    val fakeEmailAddress by lazy { FakeEmailAddress(fakeName) }

    /**
     * Provides a [FakeName].
     */
    val fakeName by lazy { FakeName(fakerName) }

    /**
     * Provides a [fakePassword].
     */
    val fakePassword by lazy { FakePassword(fakerInternet) }
}

@Suppress("UnusedPrivateClass", "UnusedPrivateMember") // used for documentation
private class FakeKUsageExample {
    private fun helloFakeK() {
        val fakeHello = fakek { "Hello, ${fakeName.firstName}!" }
        println(fakeHello)
    }
}
