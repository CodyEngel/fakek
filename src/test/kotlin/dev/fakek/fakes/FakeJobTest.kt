package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class FakeJobTest {
    private val field: String = "Computer Science"
    private val keySkills: String = "Problem Solving"
    private val position: String = "Engineer"
    private val seniority: String = "Lead"
    private val title: String = "Lead Engineer"
    private val fakerJob: FakerJob = mockk {
        every { field() } returns field.toString()
        every { keySkills() } returns keySkills
        every { position() } returns position
        every { seniority() } returns seniority
        every { title() } returns title
    }

    private val subject = FakeJob(fakerJob)

    @Test
    fun `given a FakerJob when creating a FakeJob then the correct field should be set`() {
        expectThat(subject.field).isEqualTo(field)
    }

    @Test
    fun `given a FakerJob when creating a FakeJob then the correct keySkills should be set`() {
        expectThat(subject.keySkills).isEqualTo(keySkills)
    }

    @Test
    fun `given a FakerJob when creating a FakeJob then the correct position should be set`() {
        expectThat(subject.position).isEqualTo(position)
    }

    @Test
    fun `given a FakerJob when creating a FakeJob then the correct seniority should be set`() {
        expectThat(subject.seniority).isEqualTo(seniority)
    }

    @Test
    fun `given a FakerJob when creating a FakeJob then the correct title should be set`() {
        expectThat(subject.title).isEqualTo(title)
    }
}