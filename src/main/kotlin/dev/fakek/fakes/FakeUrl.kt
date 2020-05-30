package dev.fakek.fakes

/**
 * FakeUrl provides a fake url with a format of `www.<domain-name>.<tld>`.
 */
data class FakeUrl(val url: String) {
    internal constructor(fakerInternet: FakerInternet): this(fakerInternet.url())
}
