package racingcar.interfaces

import racingcar.domain.Car
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputAdapterTest {

    @Test
    @DisplayName("splitCarName 함수는 자동차 이름 리스트를 반환하는 지 확인하는 테스트")
    fun `splitCarName 함수는 자동차 이름 리스트를 반환하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car1,car2,car3", "3")
        val cars = inputAdapter.splitCarName()
        assertEquals(listOf("car1", "car2", "car3"), cars)
    }

    @Test
    @DisplayName("validateCarName 함수는 이름이 5자 초과면 예외를 출력하는 지 확인하는 테스트")
    fun `validateCarName 함수는 이름이 5자 초과면 예외를 출력하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car123,car2,car3", "3")
        val exception = assertThrows<IllegalArgumentException>{
            inputAdapter.validateCarName(listOf("car123", "car2", "car3"))
        }
        assertTrue(exception.message!!.contains("잘못된 입력입니다: 자동차 이름에 이름은 5자 이하만 가능합니다."))
    }

    @Test
    @DisplayName("validateCarName 함수는 이름이 빈 문자열이면 예외를 출력하는 지 확인하는 테스트")
    fun `validateCarName 함수는 이름이 빈 문자열이면 예외를 출력하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter(",car2,car3", "3")
        val exception = assertThrows<IllegalArgumentException>{
            inputAdapter.validateCarName(listOf("", "car2", "car3"))
        }
        assertTrue(exception.message!!.contains("잘못된 입력입니다: 자동차 이름에 빈 문자을 입력했습니다."))
    }

    @Test
    @DisplayName("validateCarName 함수는 이름이 공백이면 예외를 출력하는 지 확인하는 테스트")
    fun `validateCarName 함수는 이름이 공백이면 예외를 출력하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("  ,car2,car3", "3")
        val exception = assertThrows<IllegalArgumentException>{
            inputAdapter.validateCarName(listOf("  ", "car2", "car3"))
        }
        assertTrue(exception.message!!.contains("잘못된 입력입니다: 자동차 이름에 공백을 입력했습니다."))
    }

    @Test
    @DisplayName("validateCarName 함수는 똑같은 이름을 2번 넣으면 예외를 출력하는 지 확인하는 테스트")
    fun `validateCarName 함수는 똑같은 이름을 2번 넣으면 예외를 출력하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car2,car2,car3", "3")
        val exception = assertThrows<IllegalArgumentException>{
            inputAdapter.validateCarName(listOf("car2", "car2", "car3"))
        }
        assertTrue(exception.message!!.contains("잘못된 입력입니다: 자동차 이름에 동일한 이름을 입력했습니다."))
    }

    @Test
    @DisplayName("validateCarName 함수는 경기가능한 차량이 한대면 에러를 출력하는지 확인하는 테스트")
    fun `validateCarName 함수는 경기가능한 차량이 한대면 에러를 출력하는지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car2,car2,car3", "3")
        val exception = assertThrows<IllegalArgumentException>{
            inputAdapter.validateCarName(listOf("car2"))
        }
        assertTrue(exception.message!!.contains("잘못된 입력입니다: 자동차 게임이 진행가능한 자동차 이름이 하나만 있습니다."))
    }

    @Test
    @DisplayName("changeTypeOfCar 함수는 Car 객체 리스트로 변환하는 지 확인하는 테스트")
    fun `changeTypeOfCar 함수는 Car 객체 리스트로 변환하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car1,car2,car3", "3")
        val racingCar = setOf("car1", "car2", "car3")
        val readyRacingCar = inputAdapter.changeTypeOfCar(racingCar)
        assertTrue(readyRacingCar[0] is Car)
        assertEquals("car1", readyRacingCar[0].name)
        assertEquals(0, readyRacingCar[0].distance)
    }

    @Test
    @DisplayName("changeTypeOfMatches 함수는 Matches 숫자로 변환하는 지 확인하는 테스트")
    fun `changeTypeOfMatches 함수는 Matches 숫자로 변환하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car1,car2,car3", "3")
        val matches = inputAdapter.changeTypeOfMatches()
        assertTrue(matches is Int)
        assertEquals(3, matches)
    }

    @Test
    @DisplayName("validateMatches 함수는 정수가 아닌 값을 입력하면 예외로 처리하는 지 확인하는 테스트")
    fun `validateMatches 함수는 정수가 아닌 값을 입력하면 예외로 처리하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car1,car2,car3", "t")
        val exception = assertThrows<IllegalArgumentException> { inputAdapter.validateMatches() }
        assertTrue(exception.message!!.contains("잘못된 입력입니다: 시도 횟수에 정수가 아닌 값을 입력했습니다."))
    }

    @Test
    @DisplayName("validateMatches 함수는 0을 입력하면 예외로 처리하는 지 확인하는 테스트")
    fun `validateMatches 함수는 0을 입력하면 예외로 처리하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car1,car2,car3", "0")
        val exception = assertThrows<IllegalArgumentException> { inputAdapter.validateMatches() }
        assertTrue(exception.message!!.contains("잘못된 입력입니다: 시도 횟수에 0을 입력했습니다."))
    }

    @Test
    @DisplayName("validateMatches 함수는 음수을 입력하면 예외로 처리하는 지 확인하는 테스트")
    fun `validateMatches 함수는 음수을 입력하면 예외로 처리하는 지 확인하는 테스트`() {
        val inputAdapter = InputAdapter("car1,car2,car3", "-1")
        val exception = assertThrows<IllegalArgumentException> { inputAdapter.validateMatches() }
        assertTrue(exception.message!!.contains("잘못된 입력입니다: 시도 횟수에 음수를 입력했습니다."))
    }
}