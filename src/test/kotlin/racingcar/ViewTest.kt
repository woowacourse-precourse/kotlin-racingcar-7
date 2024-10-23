package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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

    override fun runMain() {
    }
}