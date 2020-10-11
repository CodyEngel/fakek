package dev.fakek.fakes

import dev.fakek.fakes.utils.FakeCompanyBaseTest
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal open class FakeCompanyTest : FakeCompanyBaseTest() {

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
