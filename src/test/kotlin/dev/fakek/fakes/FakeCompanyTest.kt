package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expect
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FakeCompanyTest {

    private val bs = "fake everthing"
    private val buzzword = "Fake-focused"
    private val catchPhrase = "fake until you make it"
    private val industry = "Fake Pproduct Services"
    private val logo = "https://pigment.github.com/fake-logos/logos/medium/color/5.png"
    private val name = "Faker-Corporate"
    private val profession = "Faker"
    private val suffix = "Group"

    private val fakerCompany: FakerCompany = mockk {
        every { bs() } returns bs
        every { buzzword() } returns buzzword
        every { catchPhrase() } returns catchPhrase
        every { industry() } returns industry
        every { logo() } returns logo
        every { name() } returns name
        every { profession() } returns profession
        every { suffix() } returns suffix
    }

    private val url = "www.fake-url.com.fk"

    private val fakerUrl = FakeUrl(url)

    private fun fakeCompany() = FakeCompany(fakerCompany, fakerUrl)

    @Test
    fun `given a FakerCompany and FakerUrl when creating a FakeCompany then the correct data should be set`() {
        val subject = fakeCompany()

        expectThat(subject) {
            get { bs } isEqualTo(bs)
            get { buzzword } isEqualTo(buzzword)
            get { catchPhrase } isEqualTo(catchPhrase)
            get { industry } isEqualTo(industry)
            get { logo } isEqualTo(logo)
            get { name } isEqualTo(name)
            get { profession } isEqualTo(profession)
            get { suffix } isEqualTo(suffix)
            get { url } isEqualTo(url)
        }
    }
}
