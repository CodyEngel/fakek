package dev.fakek.fakes

/**
 * FakeApp provides a fake app which includes a name, version, author, and semantic version.
 *
 * @param name is an app name.
 * @param version is an app version.
 * @param author is an app author name.
 * @param semanticVersion is the semantic version including major, minor and patch.
 */
data class FakeApp(
    val name: String,
    val version: String,
    val author: String,
    val semanticVersion: String
) {

    constructor(fakerApp: FakerApp, fakeSemanticVersion: FakeSemanticVersion) : this(
        name = fakerApp.name(),
        version = fakerApp.version(),
        author = fakerApp.author(),
        semanticVersion = fakeSemanticVersion.toString()
    )

}
