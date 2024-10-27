package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("유효성 검증 객체에 대한 테스트")
class ValidatorTest {
    private val validator = Validator()

    @Nested
    @DisplayName("자동차 이름 중복 검사")
    inner class CarNameDuplicatedTest {

        @Test
        fun `자동차 이름 중에 중복이 없을 경우 false 값을 반환한다`() {
            val appliedCars = listOf("nana", "bobo", "dudu")

            val result = validator.isDuplicatedCarNames(appliedCars)

            assertFalse(result)
        }

        @Test
        fun `자동차 이름 중에 중복이 있을 경우 true 값을 반환한다`() {
            val appliedCars = listOf("nana", "bobo", "bobo")

            val result = validator.isDuplicatedCarNames(appliedCars)

            assertTrue(result)
        }
    }

    @Nested
    @DisplayName("자동차 이름 유효성 검사")
    inner class CarNameValidatorTest {

        @Test
        fun `자동차 이름이 5글자 이내이며 공백이 없을 경우 true 값을 반환한다`() {
            val carName = "mong"

            val result = validator.isValidCarName(carName)

            assertTrue(result)
        }

        @Test
        fun `자동차 이름이 공백일 경우 false 값을 반환한다`() {
            val carName = ""

            val result = validator.isValidCarName(carName)

            assertFalse(result)
        }

        @Test
        fun `자동차 이름이 5자 초과일 경우 false 값을 반환한다`() {
            val carName = "sonson"

            val result = validator.isValidCarName(carName)

            assertFalse(result)
        }

        @Test
        fun `자동차 이름에 공백이 포함되어 있을 경우 false 값을 반환한다`() {
            val carName = "son m"

            val result = validator.isValidCarName(carName)

            assertFalse(result)
        }

        @Test
        fun `자동차 이름이 공백으로만 이루어져있을 경우 false 값을 반환한다`() {
            val carName = "   "

            val result = validator.isValidCarName(carName)

            assertFalse(result)
        }
    }

    @Nested
    @DisplayName("경주 횟수 유효성 검사")
    inner class RaceCountValidatorTest {

        @Test
        fun `경주 횟수가 0이상 양의 정수일 경우 true 값을 반환한다`() {
            val raceCount = "5"

            val result = validator.isValidRaceCount(raceCount)

            assertTrue(result)
        }

        @Test
        fun `경주 횟수가 0일 경우 false 값을 반환한다`() {
            val raceCount = "0"

            val result = validator.isValidRaceCount(raceCount)

            assertFalse(result)
        }

        @Test
        fun `경주 횟수가 실수형일 경우 false 값을 반환한다`() {
            val raceCount = "3.5"

            val result = validator.isValidRaceCount(raceCount)

            assertFalse(result)
        }

        @Test
        fun `경주 횟수가 음수일 경우 false 값을 반환한다`() {
            val raceCount = "-100"

            val result = validator.isValidRaceCount(raceCount)

            assertFalse(result)
        }

        @Test
        fun `경주 횟수가 숫자가 아닐 경우 false 값을 반환한다`() {
            val raceCount = "abc"

            val result = validator.isValidRaceCount(raceCount)

            assertFalse(result)
        }
    }

    @Nested
    @DisplayName("전진 가능에 대한 유효성 검사")
    inner class ForwardValidatorTest {

        @Test
        fun `랜덤 값이 4일 경우 true 값을 반환한다`() {
            val randomValue = 4

            val result = validator.isPossibleForward(randomValue)

            assertTrue(result)
        }

        @Test
        fun `랜덤 값이 3일 경우 false 값을 반환한다`() {
            val randomValue = 3

            val result = validator.isPossibleForward(randomValue)

            assertFalse(result)
        }
    }
}