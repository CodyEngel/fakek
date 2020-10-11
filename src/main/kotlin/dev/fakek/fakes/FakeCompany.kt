package dev.fakek.fakes

import dev.fakek.interfaces.Company

/**
 * FakeCompany provides a company with random information.
 */
data class FakeCompany(
    override val bs: String,
    override val buzzword: String,
    override val catchPhrase: String,
    override val industry: String,
    override val logo: String,
    override val name: String,
    override val profession: String,
    override val suffix: String,
    override val url: String
) : Company {
    constructor(fakerCompany: FakerCompany, fakeUrl: FakeUrl) :
        this(
            fakerCompany.bs(),
            fakerCompany.buzzword(),
            fakerCompany.catchPhrase(),
            fakerCompany.industry(),
            fakerCompany.logo(),
            fakerCompany.name(),
            fakerCompany.profession(),
            fakerCompany.suffix(),
            fakeUrl.url
        )
}
