package racingcar.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class GenerateNumberKtTest {

    @Test
    fun `0-9 사이 랜덤 숫자 생성 테스트`() {
        val randomNumber = randomNumber()

        assertTrue(randomNumber in 0..9)
    }
}
