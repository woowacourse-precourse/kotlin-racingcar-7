package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingCarTest {
    @DisplayName("자동차 이름 : 길이가 1 ~ 5사이, 영대소문자 & 숫자")
    @Test
    fun carName() {
        assertEquals(RacingCar.checkCarName("aaaa"), true)
        assertEquals(RacingCar.checkCarName(""), false)
        assertEquals(RacingCar.checkCarName("111111"), false)
        assertEquals(RacingCar.checkCarName("$"), false)
        assertEquals(RacingCar.checkCarName("ㅁ"), false)
    }

    @DisplayName("올바르지 않은 자동차 이름 입력시 예외 발생")
    @Test
    fun carNameException() {
        assertThrows(RuntimeException::class.java) { RacingCar("ㅁ") }
    }

    @DisplayName("차수별 실행 결과")
    @Test
    fun move() {
        val carName = "a"
        val racingCar = RacingCar(carName)
        racingCar.moveCount = 2
        assertEquals(racingCar.toString(), "$carName : --")
    }
}