package dev.fakek.fakes

/**
 * FakeBook provides a fake book which includes author, genre, publisher, and title. This is great for building a fresh
 * library on a budget 😉
 *
 * @param author is the author that wrote the FakeBook.
 * @param genre is the genre (category/type) of the FakeBook.
 * @param publisher is the publishing company that was responsible for releasing the FakeBook.
 * @param title is the name of the FakeBook.
 */
data class FakeBook(
    val author: String,
    val genre: String,
    val publisher: String,
    val title: String
) {
    constructor(fakerBook: FakerBook) : this(
        author = fakerBook.author(),
        genre = fakerBook.genre(),
        publisher = fakerBook.publisher(),
        title = fakerBook.title()
    )
}
