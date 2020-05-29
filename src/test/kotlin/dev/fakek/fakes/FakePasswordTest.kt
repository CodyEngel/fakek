package dev.fakek.fakes

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class FakePasswordTest {

    private val mockFakerInternet by lazy { mockk<FakerInternet>(relaxed = true) }

    @Test
    fun `given a FakerInternet when creating a FakePassword then the correct defaults should be used`() {
        FakePassword(mockFakerInternet)

        verify { mockFakerInternet.password(8, 16, true, true, true) }
    }
}