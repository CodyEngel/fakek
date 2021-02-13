package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeAppTest {

    private val name by lazy { "Treeflex" }
    private val version by lazy { "1.85" }
    private val author by lazy { "Daphne Swift" }
    private val semanticVersionString by lazy { "3.2.5" }
    private val semanticVersionChangedMajorString by lazy { "1.2.5" }
    private val semanticVersionChangedMinorString by lazy { "3.1.5" }
    private val semanticVersionChangedPatchString by lazy { "3.2.1" }
    private val fakerApp: FakerApp = mockk {
        every { name() } returns name
        every { version() } returns version
        every { author() } returns author
    }
    private val semanticVersion = mockk<FakeSemanticVersion>()

    @Test
    fun `given a FakerApp when creating a FakeApp then the correct name should be set`() {
        val subject = FakeApp(fakerApp, semanticVersion)

        expectThat(subject.name).isEqualTo(name)
    }

    @Test
    fun `given a FakerApp when creating a FakeApp then the correct version should be set`() {
        val subject = FakeApp(fakerApp, semanticVersion)

        expectThat(subject.version).isEqualTo(version)
    }

    @Test
    fun `given a FakerApp when creating a FakeApp then the correct author should be set`() {
        val subject = FakeApp(fakerApp, semanticVersion)

        expectThat(subject.author).isEqualTo(author)
    }

    @Test
    fun `given a FakerApp when creating a FakeApp then the correct semantic version should be set`() {
        every { semanticVersion.toString() } returns semanticVersionString

        val subject = FakeApp(fakerApp, semanticVersion)

        expectThat(subject.semanticVersion).isEqualTo(semanticVersionString)
    }

    @Test
    fun `given a FakerApp when creating a FakeApp and changing major semantic version should be different`() {
        val semanticVersionSpy = spyk<FakeSemanticVersion>()
        every { semanticVersionSpy.toString() } returns semanticVersionString andThen semanticVersionChangedMajorString

        val subject1 = FakeApp(fakerApp, semanticVersionSpy)
        expectThat(subject1.semanticVersion).isEqualTo(semanticVersionString)

        semanticVersionSpy.changeMajor(1)
        val subject2 = FakeApp(fakerApp, semanticVersionSpy)
        expectThat(subject2.semanticVersion).isEqualTo(semanticVersionChangedMajorString)
    }

    @Test
    fun `given a FakerApp when creating a FakeApp and changing minor semantic version should be different`() {
        val semanticVersionSpy = spyk<FakeSemanticVersion>()
        every { semanticVersionSpy.toString() } returns semanticVersionString andThen semanticVersionChangedMinorString

        val subject1 = FakeApp(fakerApp, semanticVersionSpy)
        expectThat(subject1.semanticVersion).isEqualTo(semanticVersionString)

        semanticVersionSpy.changeMinor(1)
        val subject2 = FakeApp(fakerApp, semanticVersionSpy)
        expectThat(subject2.semanticVersion).isEqualTo(semanticVersionChangedMinorString)
    }

    @Test
    fun `given a FakerApp when creating a FakeApp and changing patch semantic version should be different`() {
        val semanticVersionSpy = spyk<FakeSemanticVersion>()
        every { semanticVersionSpy.toString() } returns semanticVersionString andThen semanticVersionChangedPatchString

        val subject1 = FakeApp(fakerApp, semanticVersionSpy)
        expectThat(subject1.semanticVersion).isEqualTo(semanticVersionString)

        semanticVersionSpy.changePatch(1)
        val subject2 = FakeApp(fakerApp, semanticVersionSpy)
        expectThat(subject2.semanticVersion).isEqualTo(semanticVersionChangedPatchString)
    }

}

