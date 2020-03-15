package dev.engel.fakek

import com.github.javafaker.Faker
import dev.engel.fakek.fakes.FakeEmail
import dev.engel.fakek.fakes.FakeName
import dev.engel.fakek.fakes.FakePassword

/**
 * The top level 
 */
fun <T> fakek(fakeBuilder: Fake.() -> T): T {
    val fake = Fake()
    return fake.fakeBuilder()
}

class Fake(private val faker: Faker = Faker.instance()) {
    private val fakerName by lazy { faker.name() }
    private val fakerInternet by lazy { faker.internet() }

    val fakeEmail by lazy { FakeEmail(fakeName) }

    val fakeName by lazy { FakeName(fakerName) }

    val fakePassword by lazy { FakePassword(fakerInternet) }
}