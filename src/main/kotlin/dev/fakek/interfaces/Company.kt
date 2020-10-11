package dev.fakek.interfaces

/**
 * Company in an interface to implement fake companies.
 */
interface Company {
    /**
     * @property bs company corporate speak ex: "energistically mesh e-business opportunities".
     */
    val bs: String
    /**
     * @property buzzword
     */
    val buzzword: String
    /**
     * @property catchPhrase
     */
    val catchPhrase: String
    /**
     * @property industry
     */
    val industry: String
    /**
     * @property logo random url of the company logo.
     */
    val logo: String
    /**
     * @property name
     */
    val name: String
    /**
     * @property profession
     */
    val profession: String
    /**
     * @property suffix
     */
    val suffix: String
    /**
     * @property url random url of company website.
     */
    val url: String
}
