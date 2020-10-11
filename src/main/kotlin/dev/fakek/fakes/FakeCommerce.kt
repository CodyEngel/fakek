package dev.fakek.fakes

import dev.fakek.interfaces.Company

/**
 * FakeCommerce provides a commerce with random information.
 */
data class FakeCommerce(val address: FakeAddress, private val fakeCompany: FakeCompany) : Company by fakeCompany
