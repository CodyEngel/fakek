package dev.fakek.fakes

import dev.fakek.fakes.utils.FakeCompanyBaseTest
import dev.fakek.interfaces.Company
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA

internal class FakeCommerceTest : FakeCompanyBaseTest() {

    @Test
    fun `given a FakeCommerce it should be subtype of FakeCompany with a fake address`() {
        val subject = FakeCommerce(mockk(), fakeCompany())

        expectThat(subject) {
            isA<Company>()
            get { address }.isA<FakeAddress>()
        }
    }

}