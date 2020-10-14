package dev.fakek.fakes

/**
 * FakeCrypto provides a instance with fake generated cryptography.
 *
 * @param md5 message digested in a 128 bit value,
 * see more in [here](https://en.wikipedia.org/wiki/MD5)
 * @param sha1 a random value encrypted in secure hash algorithm 1,
 * see more in [here](https://en.wikipedia.org/wiki/SHA-1)
 * @param sha256 a random value encrypted in secure hash algorithm 2 of 256 family,
 * see more in [here](https://en.wikipedia.org/wiki/SHA-2)
 * @param sha512 a random value encrypted in secure hash algorithm 2 of 512 family,
 * see more in [here](https://en.wikipedia.org/wiki/SHA-2)
 */
data class FakeCrypto(
    val md5: String,
    val sha1: String,
    val sha256: String,
    val sha512: String
) {
    constructor(fakerCrypto: FakerCrypto):
        this(
            fakerCrypto.md5(),
            fakerCrypto.sha1(),
            fakerCrypto.sha256(),
            fakerCrypto.sha512()
        )
}
