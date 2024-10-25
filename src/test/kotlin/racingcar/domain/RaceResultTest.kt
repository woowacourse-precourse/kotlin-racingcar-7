package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RaceResultTest {

    @Test
    @DisplayName("RaceResult 객체 초기값 확인 테스트")
    fun `RaceResult 객체 초기값 확인 테스트`() {
        val winners = listOf("pobi", "jun")
        val raceResult = RaceResult(winners)
        assertEquals(winners, raceResult.winners)
    }
}