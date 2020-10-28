package dev.fakek.fakes

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FakeEducatorTest {

    private val campus = "campus"
    private val course = "course"
    private val secondarySchool = "secondarySchool"
    private val university = "university"

    private val fakerEducator: FakerEducator = mockk {
        every { campus() } returns campus
        every { course() } returns course
        every { secondarySchool() } returns secondarySchool
        every { university() } returns university
    }

    private val subject = FakeEducator(fakerEducator)

    @Test
    fun `given a FakerEducator when creating a FakeEducator then expect campus to be equal`() {
        expectThat(subject.campus).isEqualTo(campus)
    }

    @Test
    fun `given a FakerEducator when creating a FakeEducator then expect course to be equal`() {
        expectThat(subject.course).isEqualTo(course)
    }

    @Test
    fun `given a FakerEducator when creating a FakeEducator then expect secondarySchool to be equal`() {
        expectThat(subject.secondarySchool).isEqualTo(secondarySchool)
    }

    @Test
    fun `given a FakerEducator when creating a FakeEducator then expect university to be equal`() {
        expectThat(subject.university).isEqualTo(university)
    }

}
