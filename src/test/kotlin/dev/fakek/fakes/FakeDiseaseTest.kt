package dev.fakek.fakes

import com.github.javafaker.Medical
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FakeDiseaseTest {

    private val diseaseName: String = "COVID-19"
    private val medical: Medical = mockk {
        every { diseaseName() } returns diseaseName
    }

    @Test
    fun `given a Medical when creating a FakeDisease then expect disease names to be equals`() {
        val result = FakeDisease(medical)
        expectThat(result.diseaseName) {
            get { isEqualTo(diseaseName) }
        }
    }

}
