package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FakeCryptoTest {

    private val md5 by lazy { "2c259e9e1e874842c3269c1dfbb726f4" }
    private val sha1 by lazy { "9a486863dcdab4d780259df861cb9909de195dc1" }
    private val sha256 by lazy { "f33a0af645b1dc7ed00eb19c53d80e88af3eed4f264c28e6ac3278d7295d1900" }
    private val sha512 by lazy { "24a58e877ed785d9f5a4cab29cfc0c7db2f0075a5fc4c7e3ef8ebbf99d97d8646524b73400061fc10c981c9cfc425a0c754979fbe713e768e3f010345246bf72" }

    private val fakerCrypto by lazy {
        mockk<FakerCrypto>()
            .also {
                every { it.md5() } returns md5
                every { it.sha1() } returns sha1
                every { it.sha256() } returns sha256
                every { it.sha512() } returns sha512
            }
    }

    @Test
    fun `given a FakerCrypto when creating a FakeCrypto then the correct attribute values should be set`() {
        val subject = FakeCrypto(fakerCrypto)

        expectThat(subject) {
            get { md5 }.isEqualTo(md5)
            get { sha1 }.isEqualTo(sha1)
            get { sha256 }.isEqualTo(sha256)
            get { sha512 }.isEqualTo(sha512)
        }
    }
}