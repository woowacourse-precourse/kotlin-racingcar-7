package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ViewTest : NsTest() {

    @DisplayName("자동차 이름 가져오기 성공 - 2 개")
    @Test
    fun successGetCarName() {
        val carNames = listOf("우테코", "사랑")
        run(carNames.joinToString(","))

        val result = getCarNames()
        assertTrue(output().contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"))
        assertEquals(result[0], carNames[0])
        assertEquals(result[1], carNames[1])
    }

    @DisplayName("시도 횟수 가져오기 성공")
    @Test
    fun successGetTryCount() {
        val value = 5
        run(value.toString())

        val result = getTryCount()
        assertTrue(output().contains("시도할 횟수는 몇 회인가요?"))
        assertEquals(result, value)
    }

    @DisplayName("시도 횟수 가져오기 실패 - 숫자가 아닌 경우")
    @Test
    fun failGetTryCountWithNonNumber() {
        assertThrows<IllegalArgumentException> {
            run("우테코")
            getTryCount()
        }
    }

    @DisplayName("시도 횟수 가져오기 실패 - 숫자가 너무 큰 경우")
    @Test
    fun failGetTryCountWithOverNumber() {
        assertThrows<IllegalArgumentException> {
            run("${Int.MAX_VALUE.toLong() + 1}")
            getTryCount()
        }
    }

    @DisplayName("실행 결과 문구 출력 성공")
    @Test
    fun successPrintResultTitle() {
        printResultTitle()
        assertTrue(output().contains("실행 결과"))
    }

    override fun runMain() {
    }
}