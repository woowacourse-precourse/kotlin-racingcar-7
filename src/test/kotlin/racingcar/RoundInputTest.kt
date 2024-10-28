package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.ValidatorUtil.validateCarLength
import racingcar.util.ValidatorUtil.validateRoundRange
import racingcar.util.ValidatorUtil.validateRoundType

class RoundInputTest {
    @Test
    fun `시도 횟수가 숫자로 변환 할 수 없을 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            val input = "ㄱㄴㄷ"
            validateRoundType(input)
        }
    }

    @Test
    fun `시도 횟수가 양수가 아닐 경우 반환`() {
        assertThrows<IllegalArgumentException> {
            val input = -1
            validateRoundRange(input)
        }
    }

}