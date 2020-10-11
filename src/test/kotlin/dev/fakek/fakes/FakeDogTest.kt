package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeDogTest {

    private val name = "name"
    private val breed = "breed"
    private val sound = "sound"
    private val memePhrase = "memePhrase"
    private val age = "age"
    private val coatLength = "coatLength"
    private val gender = "gender"
    private val size = "size"

    private val fakerDog: FakerDog = mockk {
        every { name() } returns name
        every { breed() } returns breed
        every { sound() } returns sound
        every { memePhrase() } returns memePhrase
        every { age() } returns age
        every { coatLength() } returns coatLength
        every { gender() } returns gender
        every { size() } returns size
    }

    private val subject = FakeDog(fakerDog)

    @Test
    fun `given a FakerDog when creating a FakeDog then the correct name should be set`() {
        expectThat(subject.name).isEqualTo(name)
    }

    @Test
    fun `given a FakerDog when creating a FakeDog then the correct breed should be set`() {
        expectThat(subject.breed).isEqualTo(breed)
    }

    @Test
    fun `given a FakerDog when creating a FakeDog then the correct sound should be set`() {
        expectThat(subject.sound).isEqualTo(sound)
    }

    @Test
    fun `given a FakerDog when creating a FakeDog then the correct memePhrase should be set`() {
        expectThat(subject.memePhrase).isEqualTo(memePhrase)
    }

    @Test
    fun `given a FakerDog when creating a FakeDog then the correct age should be set`() {
        expectThat(subject.age).isEqualTo(age)
    }

    @Test
    fun `given a FakerDog when creating a FakeDog then the correct coatLength should be set`() {
        expectThat(subject.coatLength).isEqualTo(coatLength)
    }

    @Test
    fun `given a FakerDog when creating a FakeDog then the correct gender should be set`() {
        expectThat(subject.gender).isEqualTo(gender)
    }

    @Test
    fun `given a FakerDog when creating a FakeDog then the correct size should be set`() {
        expectThat(subject.size).isEqualTo(size)
    }
}