package dev.fakek.fakes.utils

import dev.fakek.fakes.FakeCompany
import dev.fakek.fakes.FakeUrl
import io.mockk.every
import io.mockk.mockk
import dev.fakek.fakes.FakerCompany

internal open class FakeCompanyBaseTest {
    protected val bs = "fake everthing"
    protected val buzzword = "Fake-focused"
    protected val catchPhrase = "fake until you make it"
    protected val industry = "Fake Pproduct Services"
    protected val logo = "https://pigment.github.com/fake-logos/logos/medium/color/5.png"
    protected val name = "Faker-Corporate"
    protected val profession = "Faker"
    protected val suffix = "Group"

    protected val fakerCompany: FakerCompany = mockk {
        every { bs() } returns bs
        every { buzzword() } returns buzzword
        every { catchPhrase() } returns catchPhrase
        every { industry() } returns industry
        every { logo() } returns logo
        every { name() } returns name
        every { profession() } returns profession
        every { suffix() } returns suffix
    }

    protected val url = "www.fake-url.com.fk"

    protected val fakeUrl = FakeUrl(url)

    protected fun fakeCompany() = FakeCompany(fakerCompany, fakeUrl)
}