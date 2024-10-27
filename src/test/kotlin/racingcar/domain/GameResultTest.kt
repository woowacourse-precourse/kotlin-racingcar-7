package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GameResultTest {

  @Test
  @DisplayName("RaceResult 객체 초기값 확인 테스트")
  fun `RaceResult 객체 초기값 확인 테스트`() {
    val winners = listOf("pobi", "jun")
    val gameResult = GameResult(winners)
    assertEquals(winners, gameResult.winners)
  }
}