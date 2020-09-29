package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeBookTest {

    private val author = "author"
    private val genre = "genre"
    private val publisher = "publisher"
    private val title = "title"

    private val fakerBook: FakerBook = mockk {
        every { author() } returns author
        every { genre() } returns genre
        every { publisher() } returns publisher
        every { title() } returns title
    }

    private val subject = FakeBook(fakerBook)

    @Test
    fun `given a FakerBook when creating a FakeBook then the correct author should be set`() {
        expectThat(subject.author).isEqualTo(author)
    }

    @Test
    fun `given a FakerBook when creating a FakeBook then the correct genre should be set`() {
        expectThat(subject.genre).isEqualTo(genre)
    }

    @Test
    fun `given a FakerBook when creating a FakeBook then the correct publisher should be set`() {
        expectThat(subject.publisher).isEqualTo(publisher)
    }

    @Test
    fun `given a FakerBook when creating a FakeBook then the correct title should be set`() {
        expectThat(subject.title).isEqualTo(title)
    }
}
