package dev.fakek.fakes

import com.github.javafaker.Faker
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.matches

internal class FakeUrlTest {

    private val fakeUrl by lazy { FakeUrl(Faker.instance().internet()) }

    @Test
    fun `given a FakeUrl with an internet instance, it should have the correct format`() {
        expectThat(fakeUrl.url).matches("(www.)(\\w)*-(\\w)*.(\\w){2,24}".toRegex())
    }
}